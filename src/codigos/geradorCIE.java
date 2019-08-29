package codigos;

import asncie.Asncie;
import com.beanit.jasn1.ber.BerTag;
/*import asncie.pkix1explicit88.*;
import asncie.pkix1explicit88.OtherAttribute.Value;*/
import com.beanit.jasn1.ber.ReverseByteArrayOutputStream;
import com.beanit.jasn1.ber.types.BerBitString;
import com.beanit.jasn1.ber.types.BerGeneralizedTime;
import com.beanit.jasn1.ber.types.BerObjectIdentifier;
import com.beanit.jasn1.ber.types.BerOctetString;
import com.beanit.jasn1.ber.types.string.BerPrintableString;
/*import com.oss.asn1.ASN1Project;*/
import com.oss.asn1.BadObjectIdentifierException;
import com.oss.asn1.BitString;
import com.oss.asn1.Coder;
import com.oss.asn1.DERCoder;
import com.oss.asn1.DecodeFailedException;
import com.oss.asn1.DecodeNotSupportedException;
import com.oss.asn1.EncodeFailedException;
import com.oss.asn1.EncodeNotSupportedException;
import com.oss.asn1.GeneralizedTime;
import com.oss.asn1.ObjectIdentifier;
import com.oss.asn1.OctetString;
import com.oss.asn1.PrintableString;
import com.oss.asn1.ValidateFailedException;
import com.oss.asn1.ValidateNotSupportedException;
import com.oss.coders.*;
import com.oss.util.HexTool;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.ParseConversionEvent;
import org.postgresql.util.Base64;
import pkix1explicit88.AlgorithmIdentifier;
import projetocie.CIEViewController;

public class geradorCIE {

    /**
     * @param args the command line arguments
     */
    Boolean flag = true;
    Boolean flagToken = true;

    //public static void main(String[] args) throws ValidateNotSupportedException, BadObjectIdentifierException {
    public Boolean GerarCIE(Estudante estudante) throws BadObjectIdentifierException, ValidateNotSupportedException {
        flag = true;
        // Initialize the project 
        /*try {
            Asncie.initialize();
        } catch (Exception e) {
            System.out.println("Initialization exception: " + e);
            flag = false;
            System.exit(1);
        }*/

        /*AttributeCertificate AC = new AttributeCertificate();

        //ACINFO
        AttributeCertificateInfo acinfo = new AttributeCertificateInfo();

        //Version
        acinfo.setVersion(AttCertVersion.v2);

        //Holder
        Holder holder = new Holder();
        IssuerSerial baseCertificateID = new IssuerSerial();
        GeneralNames issuer = new GeneralNames();
        Name directoryName = new Name();
        RelativeDistinguishedName relative = new RelativeDistinguishedName();

        AttributeTypeAndValue attributeTypeAndValue = new AttributeTypeAndValue();
        attributeTypeAndValue.setType(new ObjectIdentifier("{ 2 5 4 6 }"));
        attributeTypeAndValue.setValue(new PrintableString("BR"));
        relative.insert(attributeTypeAndValue, 0);
        directoryName.insert(relative, 0);

        attributeTypeAndValue = new AttributeTypeAndValue();
        relative = new RelativeDistinguishedName();
        attributeTypeAndValue.setType(new ObjectIdentifier("{ 2 5 4 10 }"));
        attributeTypeAndValue.setValue(new PrintableString("ICP-Brasil"));
        relative.insert(attributeTypeAndValue, 0);
        directoryName.insert(relative, 1);

        attributeTypeAndValue = new AttributeTypeAndValue();
        relative = new RelativeDistinguishedName();
        attributeTypeAndValue.setType(new ObjectIdentifier("{ 2 5 4 11 }"));
        attributeTypeAndValue.setValue(new PrintableString("Secretaria da Receita Federal do Brasil - RFB"));
        relative.insert(attributeTypeAndValue, 0);
        directoryName.insert(relative, 2);

        attributeTypeAndValue = new AttributeTypeAndValue();
        relative = new RelativeDistinguishedName();
        attributeTypeAndValue.setType(new ObjectIdentifier("{ 2 5 4 3 }"));
        attributeTypeAndValue.setValue(new PrintableString(estudante.getNomeEstudante()));
        relative.insert(attributeTypeAndValue, 0);
        directoryName.insert(relative, 3);

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
        attributeIssuer.setType(new ObjectIdentifier("{ 2 5 4 6 }"));
        attributeIssuer.setValue(new PrintableString("BR"));
        relativeIssuer.insert(attributeIssuer, 0);
        directoryNameIssuer.insert(relativeIssuer, 0);

        relativeIssuer = new RelativeDistinguishedName();
        attributeIssuer = new AttributeTypeAndValue();
        attributeIssuer.setType(new ObjectIdentifier("{ 2 5 4 10 }"));
        attributeIssuer.setValue(new PrintableString("ICP-Brasil"));
        relativeIssuer.insert(attributeIssuer, 0);
        directoryNameIssuer.insert(relativeIssuer, 1);

        relativeIssuer = new RelativeDistinguishedName();
        attributeIssuer = new AttributeTypeAndValue();
        attributeIssuer.setType(new ObjectIdentifier("{ 2 5 4 11 }"));
        attributeIssuer.setValue(new PrintableString("Secretaria da Receita Federal do Brasil - RFB"));
        relativeIssuer.insert(attributeIssuer, 0);
        directoryNameIssuer.insert(relativeIssuer, 2);

        relativeIssuer = new RelativeDistinguishedName();
        attributeIssuer = new AttributeTypeAndValue();
        attributeIssuer.setType(new ObjectIdentifier("{ 2 5 4 3 }"));
        attributeIssuer.setValue(new PrintableString("AC SAFEWEB RFB v5"));
        relativeIssuer.insert(attributeIssuer, 0);
        directoryNameIssuer.insert(relativeIssuer, 3);

        issuerName.setDirectoryName(directoryNameIssuer);
        v2Forms.setIssuerName(issuerName);
        attCertIssuer.setV2Form(v2Forms);
        acinfo.setIssuer(attCertIssuer);

        //Signature
        AlgorithmIdentifier signature = new AlgorithmIdentifier();
        signature.setAlgorithm(new ObjectIdentifier("{ 1 2 840 113549 1 1 11}"));
        acinfo.setSignature(signature);

        //SerialNumber
        CertificateSerialNumber serialNumber = new CertificateSerialNumber();
        //serialNumber.setValue(Integer.parseInt(estudante.getCodigoCliente() + estudante.getCodigoEstudante()));
        serialNumber.setValue(Long.parseLong(estudante.getCodigoCliente() + estudante.getCodigoEstudante()));
        acinfo.setSerialNumber(serialNumber); 

        //AttrCertValidityPeriod
        AttCertValidityPeriod attCertValidityPeriod = new AttCertValidityPeriod();

        GeneralizedTime notBefore = new GeneralizedTime();
        notBefore.setValue("20190301000000Z");
        attCertValidityPeriod.setNotBeforeTime(notBefore);

        GeneralizedTime notAfter = new GeneralizedTime();
        notAfter.setValue("20200331235959Z");
        attCertValidityPeriod.setNotAfterTime(notAfter);

        acinfo.setAttrCertValidityPeriod(attCertValidityPeriod);

        //Attributes
        NameAttributes attributes = new NameAttributes();
        OtherAttribute otherAttribute = new OtherAttribute();
        AttributeValue attributeValue = new AttributeValue();
        Value value = new Value();

        otherAttribute.setType(new ObjectIdentifier("{ 2 16 76 1 10 1 }"));
        attributeValue.setValue(estudante.getDataNascimento() + estudante.getCPF() + estudante.getNumeroMatricula() + estudante.getRG() + estudante.getOrgaoExpeditor());
        value.insert(attributeValue, 0);
        otherAttribute.setValue(value);
        attributes.insert(otherAttribute, 0);

        otherAttribute = new OtherAttribute();
        attributeValue = new AttributeValue();
        value = new Value();
        otherAttribute.setType(new ObjectIdentifier("{ 2 16 76 1 10 2 }"));
        attributeValue.setValue(estudante.getInstituicao() + estudante.getGrauEscolaridade() + estudante.getNomeCurso() + estudante.getMunicipioInstituicao() + estudante.getUFInstituicao());
        value.insert(attributeValue, 0);
        otherAttribute.setValue(value);
        attributes.insert(otherAttribute, 1);

        otherAttribute = new OtherAttribute();
        attributeValue = new AttributeValue();
        value = new Value();
        otherAttribute.setType(new ObjectIdentifier("{ 2 16 76 1 4 3 }"));
        attributeValue.setValue(estudante.getNomeSocial());
        value.insert(attributeValue, 0);
        otherAttribute.setValue(value);
        attributes.insert(otherAttribute, 2);

        acinfo.setAttributes(attributes);

        //Extensions
        Extensions extensions = new Extensions();
        //Authority Key Identifier
        Extension extension = new Extension();
        extension.setExtnID(new ObjectIdentifier("{ 2 5 29 35 }"));
        byte[] valueByte = javax.xml.bind.DatatypeConverter.parseHexBinary("E23809c369a93423188036de2895d944285e48bf");

        OctetString extnValue = new OctetString(valueByte);
        extension.setExtnValue(extnValue);
        extensions.insert(extension, 0);

        //Authority Information Access
        extension = new Extension();
        extension.setExtnID(new ObjectIdentifier("{ 1 3 6 1 5 5 7 1 1 }"));
        valueByte = javax.xml.bind.DatatypeConverter.parseHexBinary("301306082b06010505073002040786054854545053");

        extnValue = new OctetString(valueByte);
        extension.setExtnValue(extnValue);
        extensions.insert(extension, 1);

        //CRL Distribution Points
        extension = new Extension();
        extension.setExtnID(new ObjectIdentifier("{ 2 5 29 31 }"));
        valueByte = javax.xml.bind.DatatypeConverter.parseHexBinary("3023a121861f687474703a2f2f7265706f7369746f72696f2e6163736166657765622e636f6d2e62722f61632d736166657765627266622f6c63722d61632d7361666577656272666276352e63726c");

        extnValue = new OctetString(valueByte);
        extension.setExtnValue(extnValue);
        extensions.insert(extension, 2);
        acinfo.setExtensions(extensions);

        //AC acinfo
        AC.setAcinfo(acinfo);*/
        
        
        ////////////////////////////////////////////////NOVO COMPILADOR///////////////////////////////////////////////////////////////////////////////
        
        ReverseByteArrayOutputStream os = new ReverseByteArrayOutputStream(1000);

        pkix1explicit88.AttributeCertificate AC = new pkix1explicit88.AttributeCertificate();

        //ACINFO
        pkix1explicit88.AttributeCertificateInfo acinfo = new pkix1explicit88.AttributeCertificateInfo();

        //Version
        pkix1explicit88.AttCertVersion version = new pkix1explicit88.AttCertVersion();
        version.value = BigInteger.valueOf(1);
        acinfo.setVersion(version);
        
        //Holder
        pkix1explicit88.Holder holder = new pkix1explicit88.Holder();
        pkix1explicit88.IssuerSerial baseCertificateID = new pkix1explicit88.IssuerSerial();
        pkix1explicit88.GeneralNames issuer = new pkix1explicit88.GeneralNames();
        pkix1explicit88.Name directoryName = new pkix1explicit88.Name();
        pkix1explicit88.RelativeDistinguishedName relative = new pkix1explicit88.RelativeDistinguishedName();

        pkix1explicit88.AttributeTypeAndValue attributeTypeAndValue = new pkix1explicit88.AttributeTypeAndValue();
        int[] oidValue = {2,5,4,6};
        attributeTypeAndValue.setType(new BerObjectIdentifier(oidValue));               
        byte[] valueByte = "BR".getBytes();
        attributeTypeAndValue.setValue(new BerPrintableString(valueByte));
        
        relative.getAttributeTypeAndValue().add(0, attributeTypeAndValue);
        directoryName.getRelativeDistinguishedName().add(0, relative);   

        attributeTypeAndValue = new pkix1explicit88.AttributeTypeAndValue();
        relative = new pkix1explicit88.RelativeDistinguishedName();
        int[] oidValue2 = {2,5,4,10};
        attributeTypeAndValue.setType(new BerObjectIdentifier(oidValue2));                  
        byte[] valueByte2 = "ICP-Brasil".getBytes();
        attributeTypeAndValue.setValue(new BerPrintableString(valueByte2));
        
        relative.getAttributeTypeAndValue().add(0, attributeTypeAndValue);
        directoryName.getRelativeDistinguishedName().add(1, relative);

        attributeTypeAndValue = new pkix1explicit88.AttributeTypeAndValue();
        relative = new pkix1explicit88.RelativeDistinguishedName(); 
        int[] oidValue3 = {2,5,4,11};
        attributeTypeAndValue.setType(new BerObjectIdentifier(oidValue3));                
        byte[] valueByte3 = "Secretaria da Receita Federal do Brasil - RFB".getBytes();
        attributeTypeAndValue.setValue(new BerPrintableString(valueByte3));
        
        relative.getAttributeTypeAndValue().add(0, attributeTypeAndValue);
        directoryName.getRelativeDistinguishedName().add(2, relative);

        attributeTypeAndValue = new pkix1explicit88.AttributeTypeAndValue();
        relative = new pkix1explicit88.RelativeDistinguishedName();
        int[] oidValue4 = {2,5,4,3};
        attributeTypeAndValue.setType(new BerObjectIdentifier(oidValue4)); 
        byte[] valueByte4 = estudante.getNomeEstudante().getBytes();
        attributeTypeAndValue.setValue(new BerPrintableString(valueByte4));
        
        relative.getAttributeTypeAndValue().add(0, attributeTypeAndValue);
        directoryName.getRelativeDistinguishedName().add(3, relative);

        issuer.setDirectoryName(directoryName);
        baseCertificateID.setIssuer(issuer);
        holder.setBaseCertificateID(baseCertificateID);
        acinfo.setHolder(holder);
        
        
        
        //Issuer
        pkix1explicit88.AttCertIssuer attCertIssuer = new pkix1explicit88.AttCertIssuer();
        pkix1explicit88.V2Forms v2Forms = new pkix1explicit88.V2Forms();
        pkix1explicit88.GeneralNames issuerName = new pkix1explicit88.GeneralNames();
        pkix1explicit88.Name directoryNameIssuer = new pkix1explicit88.Name();
        pkix1explicit88.RelativeDistinguishedName relativeIssuer = new pkix1explicit88.RelativeDistinguishedName();
        
        pkix1explicit88.AttributeTypeAndValue attributeIssuer = new pkix1explicit88.AttributeTypeAndValue();
        
        int[] oidValue5 = {2,5,4,6};
        attributeIssuer.setType(new BerObjectIdentifier(oidValue5));                
        byte[] valueByte5 = "BR".getBytes();
        attributeIssuer.setValue(new BerPrintableString(valueByte5));
        
        relativeIssuer.getAttributeTypeAndValue().add(0, attributeIssuer);
        directoryNameIssuer.getRelativeDistinguishedName().add(0, relativeIssuer);


        relativeIssuer = new pkix1explicit88.RelativeDistinguishedName();
        attributeIssuer = new pkix1explicit88.AttributeTypeAndValue();
        int[] oidValue6 = {2,5,4,10};
        attributeIssuer.setType(new BerObjectIdentifier(oidValue6));                
        byte[] valueByte6 = "ICP-Brasil".getBytes();
        attributeIssuer.setValue(new BerPrintableString(valueByte6));
        
        relativeIssuer.getAttributeTypeAndValue().add(0, attributeIssuer);
        directoryNameIssuer.getRelativeDistinguishedName().add(1, relativeIssuer);

        relativeIssuer = new pkix1explicit88.RelativeDistinguishedName();
        attributeIssuer = new pkix1explicit88.AttributeTypeAndValue();        
        int[] oidValue7 = {2,5,4,11};
        attributeIssuer.setType(new BerObjectIdentifier(oidValue7));                
        byte[] valueByte7 = "Secretaria da Receita Federal do Brasil - RFB".getBytes();
        attributeIssuer.setValue(new BerPrintableString(valueByte7));
        
        relativeIssuer.getAttributeTypeAndValue().add(0, attributeIssuer);
        directoryNameIssuer.getRelativeDistinguishedName().add(2, relativeIssuer);

        relativeIssuer = new pkix1explicit88.RelativeDistinguishedName();
        attributeIssuer = new pkix1explicit88.AttributeTypeAndValue();
        int[] oidValue8 = {2,5,4,3};
        attributeIssuer.setType(new BerObjectIdentifier(oidValue8));                
        byte[] valueByte8 = "AC SAFEWEB RFB v5".getBytes();
        attributeIssuer.setValue(new BerPrintableString(valueByte8));
        
        relativeIssuer.getAttributeTypeAndValue().add(0, attributeIssuer);
        directoryNameIssuer.getRelativeDistinguishedName().add(3, relativeIssuer);

        issuerName.setDirectoryName(directoryNameIssuer);
        v2Forms.setIssuerName(issuerName);
        attCertIssuer.setV2Form(v2Forms);
        acinfo.setIssuer(attCertIssuer);
        
        
        //Signature
        pkix1explicit88.AlgorithmIdentifier signature = new pkix1explicit88.AlgorithmIdentifier();
        
        int[] oidValue00 = {1,2,840,113549,1,1,11};        
        signature.setAlgorithm(new BerObjectIdentifier(oidValue00));
        acinfo.setSignature(signature);

        //SerialNumber
        pkix1explicit88.CertificateSerialNumber serialNumber = new pkix1explicit88.CertificateSerialNumber();
        serialNumber.value = BigInteger.valueOf(Long.parseLong(estudante.getCodigoCliente() + estudante.getCodigoEstudante()));
        acinfo.setSerialNumber(serialNumber);

        //AttrCertValidityPeriod
        pkix1explicit88.AttCertValidityPeriod attCertValidityPeriod = new pkix1explicit88.AttCertValidityPeriod();
        
        attCertValidityPeriod.setNotBeforeTime(new BerGeneralizedTime("20190301000000Z"));
        attCertValidityPeriod.setNotAfterTime(new BerGeneralizedTime("20200331235959Z"));
        acinfo.setAttrCertValidityPeriod(attCertValidityPeriod);
        
        
        //Attributes
        pkix1explicit88.NameAttributes attributes = new pkix1explicit88.NameAttributes();
        pkix1explicit88.OtherAttribute otherAttribute = new pkix1explicit88.OtherAttribute();
        pkix1explicit88.AttributeValue attributeValue = new pkix1explicit88.AttributeValue();
        pkix1explicit88.OtherAttribute.Value value = new pkix1explicit88.OtherAttribute.Value();

        int[] oidValue9 = {2,16,76,1,10,1};
        otherAttribute.setType(new BerObjectIdentifier(oidValue9));                
        byte[] valueByte9 = (estudante.getDataNascimento() + estudante.getCPF() + estudante.getNumeroMatricula() + estudante.getRG() + estudante.getOrgaoExpeditor()).getBytes();
        attributeValue.value = valueByte9;  
        value.getAttributeValue().add(0, attributeValue);
        otherAttribute.setValue(value);
        attributes.getOtherAttribute().add(0, otherAttribute);

        otherAttribute = new pkix1explicit88.OtherAttribute();
        attributeValue = new pkix1explicit88.AttributeValue();
        value = new pkix1explicit88.OtherAttribute.Value();     
        int[] oidValue10 = {2,16,76,1,10,2};
        otherAttribute.setType(new BerObjectIdentifier(oidValue10));                
        byte[] valueByte10 = (estudante.getInstituicao() + estudante.getGrauEscolaridade() + estudante.getNomeCurso() + estudante.getMunicipioInstituicao() + estudante.getUFInstituicao()).getBytes();
        attributeValue.value = valueByte10;  
        value.getAttributeValue().add(0, attributeValue);
        otherAttribute.setValue(value);
        attributes.getOtherAttribute().add(1, otherAttribute);

        otherAttribute = new pkix1explicit88.OtherAttribute();
        attributeValue = new pkix1explicit88.AttributeValue();
        value = new pkix1explicit88.OtherAttribute.Value();
        int[] oidValue11 = {2,16,76,1,4,3};
        otherAttribute.setType(new BerObjectIdentifier(oidValue11));                
        byte[] valueByte11 = estudante.getNomeSocial().getBytes();
        attributeValue.value = valueByte11;  
        value.getAttributeValue().add(0, attributeValue);
        otherAttribute.setValue(value);
        attributes.getOtherAttribute().add(2, otherAttribute);

        acinfo.setAttributes(attributes);

        //Extensions
        pkix1explicit88.Extensions extensions = new pkix1explicit88.Extensions();
        //Authority Key Identifier
        pkix1explicit88.Extension extension = new pkix1explicit88.Extension();
        
        int[] oidValue001 = {2,5,29,35};
        extension.setExtnID(new BerObjectIdentifier(oidValue001));
        byte[] valueByte001 = "E23809c369a93423188036de2895d944285e48bf".getBytes();
        extension.setExtnValue(new BerOctetString(valueByte001));
        extensions.getExtension().add(0, extension);

        //Authority Information Access
        extension = new pkix1explicit88.Extension();
        int[] oidValue002 = {1,3,6,1,5,5,7,1,1};
        extension.setExtnID(new BerObjectIdentifier(oidValue002));
        byte[] valueByte002 = "301306082b06010505073002040786054854545053".getBytes();
        extension.setExtnValue(new BerOctetString(valueByte002));        
        extensions.getExtension().add(1, extension);
        

        //CRL Distribution Points
        extension = new pkix1explicit88.Extension();
        int[] oidValue003 = {2,5,29,31};
        extension.setExtnID(new BerObjectIdentifier(oidValue003));
        byte[] valueByte003 = "3023a121861f687474703a2f2f7265706f7369746f72696f2e6163736166657765622e636f6d2e62722f61632d736166657765627266622f6c63722d61632d7361666577656272666276352e63726c".getBytes();
        extension.setExtnValue(new BerOctetString(valueByte003));        
        extensions.getExtension().add(2, extension);
        
        acinfo.setExtensions(extensions);
        
        AC.setAcinfo(acinfo);
        
        ////////////////////////////////////////////////Termina NOVO COMPILADOR///////////////////////////////////////////////////////////////////////////////

        //AC signatureAlgorithm
        AlgorithmIdentifier signatureAlgorithm = new AlgorithmIdentifier();
        int[] oidValue004 = {1,2,840,113549,1,1,11};
        signatureAlgorithm.setAlgorithm(new BerObjectIdentifier(oidValue004));
        AC.setSignatureAlgorithm(signatureAlgorithm);

        //AC signatureValue
        BerBitString signatureValue = new BerBitString();
        byte[] sigValue = "00".getBytes();
        byte[] sigValueAux = new byte[128];
        
        try {
            //TODO: Colocar a assinatura da Cracha
            sigValue = geradorAssinatura(estudante);
            if (HexTool.getHex(sigValue).equals("00")) {
                flag = false;
            }
            
            System.arraycopy(sigValue, 0, sigValueAux, 0, 128);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | KeyStoreException | NoSuchProviderException | IOException | CertificateException | UnrecoverableKeyException ex) {
            Logger.getLogger(geradorCIE.class.getName()).log(Level.SEVERE, null, ex);
        }

        signatureValue.value = sigValueAux;
        //byte[] teste = "0".getBytes();
        //signatureValue.value = teste;
        AC.setSignatureValue(signatureValue);

        
            //Chama o metodo que assina passando o acinfo, Ex: signature(acinfo)
            //Encode and Decode
            // Verifica as restricoes para o CA
            /*try {
            final int success = 0;
            System.out.println("Checking constraints for the AC ...");
            Coder coder = Asncie.getDERCoder();
            if (coder.validate(AC) == success) {
            System.out.println("Constraint checking suceeded.");
            }
            } catch (ValidateFailedException e) {
            System.out.println("Constraint checking failed: " + e);
            flag = false;
            }*/
            
            // Encode the anotherCard value using DER
            /*try {
            Coder coder = Asncie.getDERCoder();
            ByteArrayOutputStream sink = new ByteArrayOutputStream();
            // Enable trace output from the encoder and decoder 
            coder.enableEncoderDebugging();
            //coder.enableDecoderDebugging();

            //aquiiii
            coder.encode(AC, sink);
            
            // Extract the encoding from the sink stream 
            byte[] encoding = sink.toByteArray();
            
            // Print the encoding using the HexTool utility 
            //System.out.println("Card encoded into " + encoding.length + " bytes.");
            estudante.setCodigoHex(HexTool.getHex(encoding));
            estudante.setCodigoPEM(Base64.encodeBytes(encoding).replace("\n", ""));

            /*try {
            ByteArrayInputStream source = new ByteArrayInputStream(encoding);
            // Decode the card whose encoding is in the 'encoding' byte array.
            System.out.println("\nThe decoder's trace messages ...\n");
            AttributeCertificate decodedCard = (AttributeCertificate) coder.decode(source, new AttributeCertificate());
            System.out.println("Card decoded.");
            // Print out the player's batting average
            //double batting_average = decodedCard.getBatting_average();
            
            System.out.println(decodedCard);
            } catch (DecodeFailedException e) {
            System.out.println("Decoder exception: " + e);
            } catch (DecodeNotSupportedException e) {
            System.out.println("Decoder exception: " + e);
            }
            } catch (EncodeFailedException e) {
            System.out.println("Encoder exception: " + e);
            flag = false;
            } catch (EncodeNotSupportedException e) {
            System.out.println("Encoder exception: " + e);
            flag = false;
            }
            
            // Do final cleanup
            Asncie.deinitialize();*/
            
        try {
            AC.encode(os);
        } catch (IOException ex) {
            Logger.getLogger(geradorCIE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Encoded bytes:");
        System.out.println(DatatypeConverter.printHexBinary(os.getArray()));
       
        System.out.println("Encoded bytes in PEM:");
        System.out.println(Base64.encodeBytes(os.getArray()));
        
        estudante.setCodigoHex(DatatypeConverter.printHexBinary(os.getArray()));
        estudante.setCodigoPEM(Base64.encodeBytes(os.getArray()).replace("\n", ""));
        
        //Date today = new Date(2020, 3, 31);
        //Adiciona a data de validade da CIE para dia 31/03 do proximo ano
        int year = Calendar.getInstance().get(Calendar.YEAR);
        year++;
        String date = String.valueOf(year) + "-03-31";
        estudante.setDataValidade(date);

        return flag;

    }

    public byte[] geradorAssinatura(Estudante estudante) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, KeyStoreException, NoSuchProviderException, IOException, CertificateException, UnrecoverableKeyException, ValidateNotSupportedException {
          
        String mensagem = estudante.getCodigoCliente() + estudante.getCodigoEstudante() + estudante.getDataNascimento() + estudante.getCPF() + estudante.getNumeroMatricula() + estudante.getRG() + estudante.getOrgaoExpeditor() + estudante.getInstituicao() + estudante.getGrauEscolaridade() + estudante.getNomeCurso() + estudante.getMunicipioInstituicao() + estudante.getUFInstituicao() + estudante.getNomeSocial() + estudante.getNomeEstudante() + estudante.getQRCode();

        //System.out.println("mensagem: " + mensagem);
        
        //Gera o hash SHA-256 dos atributos codificados
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(mensagem.getBytes(), 0, mensagem.length());
        mensagem = new BigInteger(1, sha.digest()).toString(16);

        //System.out.println("SHA-256: " + mensagem);

        Signature signature = Signature.getInstance("SHA256withRSA");

        //KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        //SecureRandom secureRan = new SecureRandom();
        //kpg.initialize(512, secureRan);
        //KeyPair kp = kpg.generateKeyPair();
        //PublicKey pubKey = kp.getPublic();
        PrivateKey priKey = buscaCertificados();

        if (flag) {           
            signature.initSign(priKey);
            signature.update(mensagem.getBytes());
            byte[] assinatura = signature.sign();            
            return assinatura;
        }

        return null;
    }

    public PrivateKey buscaCertificados() throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyStoreException, CertificateException, UnrecoverableKeyException {
        //Busca Certificados Instalados no PC e retorna a key
        PrivateKey key = null;
        List<String> strResult = new ArrayList<>();
        Integer intCnt = 0;
        boolean booCertValido = false;

        KeyStore ks = retornaKeyStore();
        try {
            Enumeration<String> aliasEnum = ks.aliases();

            while (aliasEnum.hasMoreElements()) {
                String aliasKey = (String) aliasEnum.nextElement();

                if (booCertValido == false) {
                    strResult.add(aliasKey);
                    //System.out.println("TESTE: " + ks.getCertificate(aliasKey).getPublicKey());
                    //strResult[intCnt] = aliasKey;
                } else if (ks.isKeyEntry(aliasKey)) {
                    strResult.add(aliasKey);
                    //strResult[intCnt] = aliasKey;
                }

                if (strResult != null) {
                    intCnt = intCnt + 1;
                }

            }

        } catch (KeyStoreException ex) {
            System.out.println("ERROR " + ex.getMessage());
            flag = false;
        }

        int i;
        for (i = 0; i < strResult.size(); i++) {
            if (strResult.get(i).equals("BRANDELERO INDUSTRIA E COMERCIO LTDA:73409385000119")) {
                key = (PrivateKey) ks.getKey(strResult.get(i), "0407".toCharArray());
                break;
            }
        }

        //key = (PrivateKey) ks.getKey(strResult.get(i), "0407".toCharArray());

        if (key == null) {
            flag = false;
            CIEViewController view = new CIEViewController();
            if(flagToken){
                flagToken = false;
                view.chamaWarnig("Erro ao obter Token", "Houve um problema ao tentar obter o token, verifique se a senha e/ou token foram inseridos corretamente!");
            }         
        }

        return key;

    }

    /*public PrivateKey retornaPriKey(KeyStore ks, String aliasKey) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {

        PrivateKey privateKey = null;

        FileInputStream fis = new FileInputStream("C:\\Users\\Emerson\\Downloads\\Projeto Carteirinhas\\conteudoCertificado_Token.cer");
        //Efetua o load do keystore
        ks.load(null, null);
        //captura a chave privada para a assinatura
        privateKey = (PrivateKey) ks.getKey(aliasKey, "0407".toCharArray());

        //System.out.println("private key: " + privateKey);
        return privateKey;
    }*/
    
    public KeyStore retornaKeyStore() throws NoSuchProviderException {
        String strResult = "";
        KeyStore ks = null;

        try {
            ks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
            try {
                ks.load(null, null);
            } catch (IOException ex) {
                Logger.getLogger(geradorCIE.class.getName()).log(Level.SEVERE, null, ex);
                flag = false;
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(geradorCIE.class.getName()).log(Level.SEVERE, null, ex);
                flag = false;
            } catch (CertificateException ex) {
                Logger.getLogger(geradorCIE.class.getName()).log(Level.SEVERE, null, ex);
                flag = false;
            }

            Enumeration<String> aliasEnum = ks.aliases();

            //System.out.println("esse: " + ks.getCertificateAlias(ks.getCertificate(strResult)));
            while (aliasEnum.hasMoreElements()) {
                String aliasKey = (String) aliasEnum.nextElement();

                if (ks.isKeyEntry(aliasKey)) {
                    strResult = aliasKey;
                    //System.out.println("strResult: " + strResult);
                }
            }

        } catch (KeyStoreException ex) {
            System.out.println("ERROR " + ex.getMessage());
            flag = false;
        }

        return ks;
    }
}
