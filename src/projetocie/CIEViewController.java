/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocie;

/*import asncie.pkix1explicit88.AttCertVersion;
import asncie.pkix1explicit88.AttributeCertificate;
import asncie.pkix1explicit88.AttributeCertificateInfo;*/
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import codigos.*;
import com.oss.asn1.BadObjectIdentifierException;
import com.oss.asn1.ValidateNotSupportedException;

import java.io.File;
import java.security.UnrecoverableKeyException;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

//jASN
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class CIEViewController implements Initializable {

    @FXML
    private Button buttonAbrir;

    @FXML
    private Button buttonGerar;

    @FXML
    private Text textArquivo;

    @FXML
    private Label labelStatus;

    @FXML
    private Text textImagens;

    @FXML
    private Button buttonImagens;
    
    @FXML
    private Menu btnOpenOptions;
    
    @FXML
    private MenuItem btnOptionsCIE;
    

    String enderecoCompleto;
    String enderecoCompletoImagens;

    @FXML
    void actionAbre(ActionEvent event) {
        try {
            FileChooser open = new FileChooser();
            open.setTitle("Selecione a Planilha - Formato XLS");
            //FileChooser.ExtensionFilter extensoes = new FileChooser.ExtensionFilter("Arquivos Excel - xls", "*.xls");
            //open.getExtensionFilters().add(extensoes);
            File end = open.showOpenDialog(null);

            String endereco = end.getPath();

            String nome = end.getName();
            int tamanho = endereco.length() - nome.length();
            String enderecoP = endereco.substring(0, tamanho);

            enderecoCompleto = endereco;

            textArquivo.setText("Arquivo: " + enderecoCompleto);
            //labelStatus.setText("");

            if ((!enderecoCompleto.substring(enderecoCompleto.length() - 3, enderecoCompleto.length()).equals("xls"))) {
                chamaWarnig("Formato Inválido!", "O arquivo de entrada deve ser uma planilha excel no formato XLS.");
                enderecoCompleto = "";
            }

        } catch (Exception e) {
        }

    }

    @FXML
    void actionImagem(ActionEvent event) {
        try {
            bancoCIE banco = new bancoCIE();
            banco.conexaoMysql();
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Selecione o Diretorio de Imagens - Formato JPG");
            File end = directoryChooser.showDialog(null);

            String endereco = end.getPath();

            enderecoCompletoImagens = endereco;
            textImagens.setText("Imagens: " + enderecoCompletoImagens);

        } catch (Exception e) {
        }
    }

    @FXML
    void actionGera(ActionEvent event) throws IOException, BiffException, SQLException, UnrecoverableKeyException, WriteException, InterruptedException {

        chamaWarnig("", "Aguarde a geração das CIE até aparecer a mensagem FINALIZADO!");

        if (!enderecoCompleto.equals("")) {
            leitorExcel leitor = new leitorExcel();
            bancoCIE banco = new bancoCIE();
            geradorCIE geradorCIE = new geradorCIE();
            List<Estudante> listaEstudantes = new ArrayList<>();
            fotosCIE ftCIE = new fotosCIE();
            Boolean envioFoto;
            Boolean geraCert;
            //Retorna uma lista dos estudantes da planilha
            listaEstudantes = leitor.lerArquivo(enderecoCompleto);
            
            banco.conexaoMysql();
            
            //Confere se os dados estao no formato dos OIDs
            leitor.confereRestricoes(listaEstudantes);

            ftCIE.abreSessao();
            //ftCIE.listarFoto(listaEstudantes.get(0).getCodigoCliente() + listaEstudantes.get(0).getCodigoEstudante(), enderecoCompletoImagens);
            
            //Insere o QRCode na planilha
            leitor.insereQRCode(enderecoCompleto, listaEstudantes);

            List<Estudante> estudantesErro = new ArrayList<>();
            String strErro = "Algum problema ocorreu ao gerar o certificado do(s) estudante(s): \n";

            //Gera o certificado dos alunos
            for (int i = 0; i < listaEstudantes.size(); i++) {
                try {
                    //Gera o Certificado de Atributo
                    geraCert = geradorCIE.GerarCIE(listaEstudantes.get(i));
                    //envia foto para o servidor
                    envioFoto = ftCIE.listarFoto(listaEstudantes.get(i).getCodigoCliente() + listaEstudantes.get(i).getCodigoEstudante(), enderecoCompletoImagens);

                    if (geraCert && envioFoto) {
                        //Salva dados dos estudante e da validacao no BD
                        banco.insereEstudante(listaEstudantes.get(i));
                        banco.insereValidacao(listaEstudantes.get(i));
                    } else {
                        estudantesErro.add(listaEstudantes.get(i));
                        strErro += listaEstudantes.get(i).getNomeEstudante() + "\n";
                    }
                } catch (BadObjectIdentifierException | ValidateNotSupportedException ex) {
                    Logger.getLogger(CIEViewController.class.getName()).log(Level.SEVERE, null, ex);
                }

                envioFoto = null;
                geraCert = null;
            }
            //leitor.SalvarTXT(enderecoCompleto, listaEstudantes);
            if (!estudantesErro.isEmpty()) {
                leitor.SalvarTXT(enderecoCompleto, estudantesErro);
                chamaWarnig("Erro ao Gerar Alguns Certificados", "Um arquivo foi salvo [" + enderecoCompleto.substring(0, enderecoCompleto.length() - 4) + "-ERRO.txt]" + " com o nome dos Estudantes que apresentaram erro na geração do certificado! \n\nOs demais certificados foram gerados com sucesso!");
            } else {
                chamaWarnig("Finalizado!", "Todos os certificados foram gerados com sucesso!");
            }
            
            ftCIE.fechaConexao();
            banco.fechaConexao();
            
        } else {
            chamaWarnig("Formato Inválido!", "O arquivo de entrada deve ser uma planilha excel no formato XLS.");
            enderecoCompleto = "";
        }

        enderecoCompletoImagens = null;
        enderecoCompleto = null;
        
        labelStatus.setText("FINALIZADO!");
    }

    @FXML
    void actionOptions(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OptionsView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Opcoes CIE - Cracha e Cartoes");
        stage.setResizable(false);//desabilita botao maximizar
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void actionZera(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ZeraView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Zerar CIEs - Cracha e Cartoes");
        stage.setResizable(false);//desabilita botao maximizar
        stage.setScene(scene);
        stage.show();
    }
    
    public void chamaWarnig(String title, String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);

        alert.showAndWait();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
