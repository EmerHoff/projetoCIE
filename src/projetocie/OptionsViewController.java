/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocie;

import codigos.*;
import codigos.bancoCIE;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Emerson
 */
public class OptionsViewController implements Initializable {

    @FXML
    private Button btnSalvarOptions;

    @FXML
    private Button btnBuscarOptions;

    @FXML
    private Button btnExcluirOptions;

    @FXML
    private Text textNomeOptions;

    @FXML
    private Text textInstituicaoOptions;

    @FXML
    private Text textCursoOptions;

    @FXML
    private Text textDocumentoOptions;

    @FXML
    private Text textValidadeOptions;

    @FXML
    private TextField textFieldBuscar;

    @FXML
    private TextField textValidadeCampo;

    //Zerar
    @FXML
    private TextField textBuscarAno;

    @FXML
    private Button btnExcluirAno;

    bancoCIE banco = new bancoCIE();

    String codigoBusca = null;

    public void limpaCampos() {
        codigoBusca = null;
        textNomeOptions.setText("Nome:");
        textInstituicaoOptions.setText("Instituição:");
        textCursoOptions.setText("Curso:");
        textDocumentoOptions.setText("Documento:");
        textValidadeCampo.clear();
    }

    @FXML
    void actionBuscarOptions(ActionEvent event) {
        limpaCampos();
        codigoBusca = textFieldBuscar.getText();
        banco.conexaoMysql();
        try {
            Date validade = banco.buscaCIEValidade(codigoBusca);
            if (validade != null) {
                SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
                String strValidade = fmt.format(validade);
                strValidade = strValidade.replace("-", "/");
                textValidadeCampo.setText(strValidade);
            }

            Estudante estudante = banco.buscaCIEInformacoes(codigoBusca);
            if (estudante != null) {
                textNomeOptions.setText("Nome: " + estudante.getNomeEstudante());
                textInstituicaoOptions.setText("Instituição: " + estudante.getInstituicao());
                textCursoOptions.setText("Curso: " + estudante.getNomeCurso());
                textDocumentoOptions.setText("Documento: " + estudante.getCPF());
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionsViewController.class.getName()).log(Level.SEVERE, null, ex);
            chamaWarnig("Não foi possivel buscar a CIE", "Verifique se o código está correto e tente novamente!");
        }
    }

    @FXML
    void actionExcluirOptions(ActionEvent event) throws SQLException {
        if (codigoBusca != null) {
            //TODO: warning: tem certeza??
            System.out.println("cod: " + codigoBusca);
            if (banco.excluirCIE(codigoBusca)) {
                chamaWarnig("CIE excluida com Sucesso!", "");
            } else {
                chamaWarnig("Ocorreu algum problema ao Excluir a CIE!", "Tente novamente!");
            }
        } else {
            chamaWarnig("Não foi possivel excluir a CIE", "Tente buscar a CIE novamente!");
        }
        limpaCampos();
    }

    @FXML
    void actionSalvarOptions(ActionEvent event) throws SQLException {
        if (codigoBusca != null) {
            try {
                if (!textValidadeCampo.getText().isEmpty()) {
                    String validade = textValidadeCampo.getText().replace("/", "-");
                    String dayString = validade.substring(0, 2);
                    String monthString = validade.substring(3, 5);
                    String yearString = validade.substring(6, 10);
                    validade = yearString + "-" + monthString + "-" + dayString;

                    if (banco.salvaAlteracoesCIE(codigoBusca, validade)) {
                        chamaWarnig("Alteração salva com Sucesso!", "");
                    } else {
                        chamaWarnig("Ocorreu algum problema ao Salvar a alteração!", "Tente novamente!");
                    }
                }
            } catch (SQLException e) {
                chamaWarnig("Problema na Data de Validade!", "Verifique se a Data de Validade encontra-se correta e no padrão (dd/mm/aaaa)!");
            }
        } else {
            chamaWarnig("Não foi possivel excluir a CIE", "Tente buscar a CIE novamente!");
        }
        limpaCampos();
    }

    @FXML
    void actionExcluirAnoZera(ActionEvent event) {
        String anoDeletar = textBuscarAno.getText();
        if (!anoDeletar.equals("") && anoDeletar.length() == 4) {
            banco.conexaoMysql();
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Excluir CIEs do Ano");
                alert.setHeaderText(null);
                alert.setContentText("Tem certeza que deseja excluir todas as CIEs com validade ate o ANO " + anoDeletar + "?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    banco.zerarAnoCIE(anoDeletar);
                    chamaWarnig("Operação com Sucesso", "As CIEs com validade em " + anoDeletar + " foram excluidas!");
                } else {
                    chamaWarnig("Operação Cancelada", "A operação para excluir as CIEs foi cancelada!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(OptionsViewController.class.getName()).log(Level.SEVERE, null, ex);
                chamaWarnig("Não foi possivel buscar a CIE", "Verifique se o código está correto e tente novamente!");
            }
        } else {
            chamaWarnig("Erro no Ano Digitado", "O Ano digitado está incorreto ou ocorreu algum problema!");
        }
    }

    public void chamaWarnig(String title, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);

        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        banco.conexaoMysql();
    }

}
