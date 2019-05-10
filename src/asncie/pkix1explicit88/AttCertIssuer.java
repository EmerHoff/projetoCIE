/*************************************************************/
/* Copyright (C) 2019 OSS Nokalva, Inc.  All rights reserved.*/
/*************************************************************/

/* THIS FILE IS PROPRIETARY MATERIAL OF OSS NOKALVA, INC.
 * AND MAY BE USED ONLY BY DIRECT LICENSEES OF OSS NOKALVA, INC.
 * THIS FILE MAY NOT BE DISTRIBUTED.
 * THIS COPYRIGHT STATEMENT MAY NOT BE REMOVED. */

/* Generated for: UNIIOESTE (Trial), License 78483Z 78483Z. */
/* Abstract syntax: asncie */
/* ASN.1 Java project: asncie.Asncie */
/* Created: Wed Mar 13 23:08:37 2019 */
/* ASN.1 Compiler for Java version: 8.0 */
/* ASN.1 compiler options and file names specified:
 * -toed -output asncie -der -root -noSampleCode -messageFormat msvc
 * C:/Users/Emerson/Downloads/Projeto Carteirinhas/asnCIE.txt
 */


package asncie.pkix1explicit88;

import com.oss.asn1.*;
import com.oss.metadata.*;
import java.io.IOException;
import com.oss.coders.EncoderException;
import com.oss.coders.DecoderException;
import com.oss.util.ExceptionDescriptor;
import com.oss.asn1printer.DataPrinter;
import com.oss.asn1printer.DataPrinterException;
import com.oss.coders.ber.EncoderOutput;
import com.oss.coders.ber.DecoderInput;
import com.oss.coders.ber.DecoderInputByteBuffer;
import com.oss.coders.ber.BERDecodable;
import com.oss.coders.ber.BerCoder;
import com.oss.coders.der.DEREncodable;
import com.oss.coders.der.DerCoder;

/**
 * Define the ASN1 Type AttCertIssuer from ASN1 Module PKIX1Explicit88.
 * @see Choice
 */

public class AttCertIssuer extends Choice {
    
    /**
     * The default constructor.
     */
    public AttCertIssuer()
    {
    }
    
    public static final  int  v2Form_chosen = 1;
    
    /**
     * Return the tag of chosen component (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public int getTag() {
	switch (getChosenFlag()) {
	case 1:
	    return 0x80;
	default:
	    return 0;
	}
    }

    // Methods for field "v2Form"
    public static AttCertIssuer createAttCertIssuerWithV2Form(V2Forms v2Form)
    {
	AttCertIssuer __object = new AttCertIssuer();

	__object.setV2Form(v2Form);
	return __object;
    }
    
    public boolean hasV2Form()
    {
	return getChosenFlag() == v2Form_chosen;
    }
    
    public V2Forms getV2Form()
    {
	if (hasV2Form())
	    return (V2Forms)mChosenValue;
	else
	    return null;
    }
    
    public void setV2Form(V2Forms v2Form)
    {
	setChosenValue(v2Form);
	setChosenFlag(v2Form_chosen);
    }
    
    
    /**
     * Clone 'this' object.
     */
    public AttCertIssuer clone() {
	return (AttCertIssuer)super.clone();
    }

} // End class definition for AttCertIssuer
