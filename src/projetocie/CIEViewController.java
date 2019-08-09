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

import javafx.stage.DirectoryChooser;

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

    @FXML
    private Text textImagens;

    @FXML
    private Button buttonImagens;

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
        
        
        /*
        
        ReverseByteArrayOutputStream os = new ReverseByteArrayOutputStream(1000);

        // Name name = new Name(new BerVisibleString("John"), new
        // BerVisibleString("P"), new BerVisibleString("Smith"));
        // instead of creating the Name object as in previous statement you can
        // assign the byte code directly as in the following statement. The
        // encode function of the name object will then simply insert this byte
        // array in the BerOutputStream. This can speed up things if the code
        // for certain structures is known and does not change.
        //AttCertVesion version = new AttCertVesion();
        

        BerObjectIdentifier oid;
        
        AttributeCertificate AC = new AttributeCertificate();

        //ACINFO
        AttributeCertificateInfo acinfo = new AttributeCertificateInfo();

        //Version
        AttCertVersion version = new AttCertVersion();
        version.value = BigInteger.valueOf(1);
        acinfo.setVersion(version);
        
        //Holder
        Holder holder = new Holder();
        IssuerSerial baseCertificateID = new IssuerSerial();
        GeneralNames issuer = new GeneralNames();
        Name directoryName = new Name();
        RelativeDistinguishedName relative = new RelativeDistinguishedName();

        AttributeTypeAndValue attributeTypeAndValue = new AttributeTypeAndValue();
        int[] oidValue = {2,5,4,6};
        attributeTypeAndValue.setType(new BerObjectIdentifier(oidValue));               
        byte[] valueByte = javax.xml.bind.DatatypeConverter.parseHexBinary("BR");
        attributeTypeAndValue.setValue(new BerPrintableString(valueByte));
        
        relative.getAttributeTypeAndValue().add(0, attributeTypeAndValue);
        directoryName.getRelativeDistinguishedName().add(0, relative);   

        attributeTypeAndValue = new AttributeTypeAndValue();
        relative = new RelativeDistinguishedName();
        int[] oidValue2 = {2,5,4,10};
        attributeTypeAndValue.setType(new BerObjectIdentifier(oidValue2));                  
        byte[] valueByte2 = javax.xml.bind.DatatypeConverter.parseHexBinary("ICP-Brasil");
        attributeTypeAndValue.setValue(new BerPrintableString(valueByte2));
        
        relative.getAttributeTypeAndValue().add(0, attributeTypeAndValue);
        directoryName.getRelativeDistinguishedName().add(1, relative);

        attributeTypeAndValue = new AttributeTypeAndValue();
        relative = new RelativeDistinguishedName(); 
        int[] oidValue3 = {2,5,4,11};
        attributeTypeAndValue.setType(new BerObjectIdentifier(oidValue3));                
        byte[] valueByte3 = javax.xml.bind.DatatypeConverter.parseHexBinary("Secretaria da Receita Federal do Brasil - RFB");
        attributeTypeAndValue.setValue(new BerPrintableString(valueByte3));
        
        relative.getAttributeTypeAndValue().add(0, attributeTypeAndValue);
        directoryName.getRelativeDistinguishedName().add(2, relative);

        attributeTypeAndValue = new AttributeTypeAndValue();
        relative = new RelativeDistinguishedName();
        int[] oidValue4 = {2,5,4,3};
        attributeTypeAndValue.setType(new BerObjectIdentifier(oidValue4)); 
        byte[] valueByte4 = javax.xml.bind.DatatypeConverter.parseHexBinary(estudante.getNomeEstudante());
        attributeTypeAndValue.setValue(new BerPrintableString(valueByte4));
        
        relative.getAttributeTypeAndValue().add(0, attributeTypeAndValue);
        directoryName.getRelativeDistinguishedName().add(3, relative); 

        issuer.setDirectoryName(directoryName);
        baseCertificateID.setIssuer(issuer);
        holder.setBaseCertificateID(baseCertificateID);
        acinfo.setHolder(holder);
        
        
        //Issuer
        AttCertIssuer attCertIssuer = new AttCertIssuer();
        V2Forms v2Forms = new V2Forms();
        GeneralNames issuerName = new GeneralNames();
        Name directoryNameIssuer = new Name();
        RelativeDistinguishedName relativeIssuer = new RelativeDistinguishedName();

        AttributeTypeAndValue attributeIssuer = new AttributeTypeAndValue();
        
        int[] oidValue5 = {2,5,4,6};
        attributeIssuer.setType(new BerObjectIdentifier(oidValue5));                
        byte[] valueByte5 = javax.xml.bind.DatatypeConverter.parseHexBinary("BR");
        attributeIssuer.setValue(new BerPrintableString(valueByte5));
        
        relativeIssuer.getAttributeTypeAndValue().add(0, attributeIssuer);
        directoryNameIssuer.getRelativeDistinguishedName().add(0, relativeIssuer);

        relativeIssuer = new RelativeDistinguishedName();
        attributeIssuer = new AttributeTypeAndValue();
        int[] oidValue6 = {2,5,4,10};
        attributeIssuer.setType(new BerObjectIdentifier(oidValue6));                
        byte[] valueByte6 = javax.xml.bind.DatatypeConverter.parseHexBinary("ICP-Brasil");
        attributeIssuer.setValue(new BerPrintableString(valueByte6));
        
        relativeIssuer.getAttributeTypeAndValue().add(0, attributeIssuer);
        directoryNameIssuer.getRelativeDistinguishedName().add(1, relativeIssuer);

        relativeIssuer = new RelativeDistinguishedName();
        attributeIssuer = new AttributeTypeAndValue();        
        int[] oidValue7 = {2,5,4,11};
        attributeIssuer.setType(new BerObjectIdentifier(oidValue7));                
        byte[] valueByte7 = javax.xml.bind.DatatypeConverter.parseHexBinary("Secretaria da Receita Federal do Brasil - RFB");
        attributeIssuer.setValue(new BerPrintableString(valueByte7));
        
        relativeIssuer.getAttributeTypeAndValue().add(0, attributeIssuer);
        directoryNameIssuer.getRelativeDistinguishedName().add(2, relativeIssuer);

        relativeIssuer = new RelativeDistinguishedName();
        attributeIssuer = new AttributeTypeAndValue();
        int[] oidValue8 = {2,5,4,3};
        attributeIssuer.setType(new BerObjectIdentifier(oidValue8));                
        byte[] valueByte8 = javax.xml.bind.DatatypeConverter.parseHexBinary("AC SAFEWEB RFB v5");
        attributeIssuer.setValue(new BerPrintableString(valueByte8));
        
        relativeIssuer.getAttributeTypeAndValue().add(0, attributeIssuer);
        directoryNameIssuer.getRelativeDistinguishedName().add(3, relativeIssuer);

        issuerName.setDirectoryName(directoryNameIssuer);
        v2Forms.setIssuerName(issuerName);
        attCertIssuer.setV2Form(v2Forms);
        acinfo.setIssuer(attCertIssuer);
        
        
        //Signature
        AlgorithmIdentifier signature = new AlgorithmIdentifier();
        
        int[] oidValue00 = {1,2,840,113549,1,1,11};        
        signature.setAlgorithm(new BerObjectIdentifier(oidValue00));
        acinfo.setSignature(signature);

        //SerialNumber
        CertificateSerialNumber serialNumber = new CertificateSerialNumber();
        //serialNumber.setValue(Integer.parseInt(estudante.getCodigoCliente() + estudante.getCodigoEstudante()));
        serialNumber.value = BigInteger.valueOf(Long.parseLong(estudante.getCodigoCliente() + estudante.getCodigoEstudante()));
        acinfo.setSerialNumber(serialNumber);

        //AttrCertValidityPeriod
        AttCertValidityPeriod attCertValidityPeriod = new AttCertValidityPeriod();
        
        attCertValidityPeriod.setNotBeforeTime(new BerGeneralizedTime("20190301000000Z"));
        attCertValidityPeriod.setNotAfterTime(new BerGeneralizedTime("20200331235959Z"));

        acinfo.setAttrCertValidityPeriod(attCertValidityPeriod);
        
        
        //Attributes
        NameAttributes attributes = new NameAttributes();
        OtherAttribute otherAttribute = new OtherAttribute();
        AttributeValue attributeValue = new AttributeValue();
        Value value = new Value();

        int[] oidValue9 = {2,16,76,1,10,1};
        otherAttribute.setType(new BerObjectIdentifier(oidValue9));                
        byte[] valueByte9 = javax.xml.bind.DatatypeConverter.parseHexBinary(estudante.getDataNascimento() + estudante.getCPF() + estudante.getNumeroMatricula() + estudante.getRG() + estudante.getOrgaoExpeditor());
        attributeValue.value = valueByte9;  
        value.getAttributeValue().add(0, attributeValue);
        otherAttribute.setValue(value);
        attributes.getOtherAttribute().add(0, otherAttribute);

        otherAttribute = new OtherAttribute();
        attributeValue = new AttributeValue();
        value = new Value();     
        int[] oidValue10 = {2,16,76,1,10,2};
        otherAttribute.setType(new BerObjectIdentifier(oidValue10));                
        byte[] valueByte10 = javax.xml.bind.DatatypeConverter.parseHexBinary(estudante.getInstituicao() + estudante.getGrauEscolaridade() + estudante.getNomeCurso() + estudante.getMunicipioInstituicao() + estudante.getUFInstituicao());
        attributeValue.value = valueByte10;  
        value.getAttributeValue().add(0, attributeValue);
        otherAttribute.setValue(value);
        attributes.getOtherAttribute().add(1, otherAttribute);

        otherAttribute = new OtherAttribute();
        attributeValue = new AttributeValue();
        value = new Value();
        int[] oidValue11 = {2,16,76,1,4,3};
        otherAttribute.setType(new BerObjectIdentifier(oidValue11));                
        byte[] valueByte11 = javax.xml.bind.DatatypeConverter.parseHexBinary(estudante.getNomeSocial());
        attributeValue.value = valueByte11;  
        value.getAttributeValue().add(0, attributeValue);
        otherAttribute.setValue(value);
        attributes.getOtherAttribute().add(2, otherAttribute);

        acinfo.setAttributes(attributes);

        //Extensions
        Extensions extensions = new Extensions();
        //Authority Key Identifier
        Extension extension = new Extension();
        
        int[] oidValue001 = {2,5,29,35};
        extension.setExtnID(new BerObjectIdentifier(oidValue001));    
        byte[] valueByte001 = javax.xml.bind.DatatypeConverter.parseHexBinary("E23809c369a93423188036de2895d944285e48bf");
        extension.setExtnValue(new BerOctetString(valueByte001));
        extensions.getExtension().add(0, extension);

        //Authority Information Access
        extension = new Extension();
        int[] oidValue002 = {1,3,6,1,5,5,7,1,1};
        extension.setExtnID(new BerObjectIdentifier(oidValue002));
        byte[] valueByte002 = javax.xml.bind.DatatypeConverter.parseHexBinary("301306082b06010505073002040786054854545053");
        extension.setExtnValue(new BerOctetString(valueByte002));        
        extensions.getExtension().add(1, extension);
        

        //CRL Distribution Points
        extension = new Extension();
        int[] oidValue003 = {2,5,29,31};
        extension.setExtnID(new BerObjectIdentifier(oidValue003));
        byte[] valueByte003 = javax.xml.bind.DatatypeConverter.parseHexBinary("3023a121861f687474703a2f2f7265706f7369746f72696f2e6163736166657765622e636f6d2e62722f61632d736166657765627266622f6c63722d61632d7361666577656272666276352e63726c");
        extension.setExtnValue(new BerOctetString(valueByte003));        
        extensions.getExtension().add(2, extension);
        
        acinfo.setExtensions(extensions);
        
        
        AC.setAcinfo(acinfo);
        //AC.encode(os);
        //version.encode(os);
        
        System.out.println("Encoded bytes:");
        System.out.println(DatatypeConverter.printHexBinary(os.getArray()));
       
        System.out.println("Encoded bytes in PEM:");
        System.out.println(Base64.encodeBytes(os.getArray()));
        
         */
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
