/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocie;

import asncie.pkix1explicit88.AttCertVersion;
import asncie.pkix1explicit88.AttributeCertificate;
import asncie.pkix1explicit88.AttributeCertificateInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import codigos.*;
import codigos.geradorCIE.*;
import com.beanit.jasn1.ber.ReverseByteArrayOutputStream;
import com.beanit.jasn1.ber.types.string.BerVisibleString;
import com.beanit.jasn1.util.HexConverter;
import com.oss.asn1.BadObjectIdentifierException;
import com.oss.asn1.ValidateNotSupportedException;
import com.oss.util.HexTool;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.UnrecoverableKeyException;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import jxl.Cell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import javax.swing.JOptionPane;
import jxl.write.WriteException;

/**
 * FXML Controller class
 *
 * @author Vilson
 */
public class CIEViewController implements Initializable {

    @FXML
    private Button buttonAbrir;

    @FXML
    private Button buttonGerar;

    @FXML
    private Text textArquivo;

    @FXML
    private Label labelStatus;

    String enderecoCompleto;

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
            labelStatus.setText("");

            if ((!enderecoCompleto.substring(enderecoCompleto.length() - 3, enderecoCompleto.length()).equals("xls"))) {
                chamaWarnig("Formato Inválido!", "O arquivo de entrada deve ser uma planilha excel no formato XLS.");
                enderecoCompleto = "";
            }

        } catch (Exception e) {
        }

    }

    @FXML
    void actionGera(ActionEvent event) throws IOException, BiffException, SQLException, UnrecoverableKeyException, WriteException, InterruptedException {

        chamaWarnig("", "Aguarde a geração das CIE até aparecer a mensagem FINALIZADO!");

        /*if (!enderecoCompleto.equals("")) {
            leitorExcel leitor = new leitorExcel();
            bancoCIE banco = new bancoCIE();
            geradorCIE geradorCIE = new geradorCIE();
            List<Estudante> listaEstudantes = new ArrayList<>();

            //Retorna uma lista dos estudantes da planilha
            listaEstudantes = leitor.lerArquivo(enderecoCompleto);

            //Confere se os dados estao no formato dos OIDs
            leitor.confereRestricoes(listaEstudantes);

            //Insere o QRCode na planilha
            leitor.insereQRCode(enderecoCompleto, listaEstudantes);

            List<Estudante> estudantesErro = new ArrayList<>();
            String strErro = "Algum problema ocorreu ao gerar o certificado do(s) estudante(s): \n";

            //banco.insereEstudante(listaEstudantes.get(0));
            //banco.insereValidacao(listaEstudantes.get(0));

            try {
                //Gera o certificado dos alunos
                for (int i = 0; i < listaEstudantes.size(); i++) {
                    if (geradorCIE.GerarCIE(listaEstudantes.get(i))) {
                        //Salva dados dos estudante e da validacao no BD
                        banco.insereEstudante(listaEstudantes.get(i));
                        banco.insereValidacao(listaEstudantes.get(i));
                    } else {
                        estudantesErro.add(listaEstudantes.get(i));
                        strErro += listaEstudantes.get(i).getNomeEstudante() + "\n";
                    }
                }

                //leitor.SalvarTXT(enderecoCompleto, listaEstudantes);

                if (!estudantesErro.isEmpty()) {
                    chamaWarnig("Erro ao Gerar Certificado", strErro + "\nTente novamente com uma planilha individual para esse(s) estudante(s)! \n\nOs demais certificados foram gerados com sucesso!");
                } else {
                    chamaWarnig("Finalizado!", "Todos os certificados foram gerados com sucesso!");
                }
            } catch (BadObjectIdentifierException ex) {
                Logger.getLogger(CIEViewController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ValidateNotSupportedException ex) {
                Logger.getLogger(CIEViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            chamaWarnig("Formato Inválido!", "O arquivo de entrada deve ser uma planilha excel no formato XLS.");
            enderecoCompleto = "";
        }*/
        System.out.println("teste");

        

        labelStatus.setText("FINALIZADO!");
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
