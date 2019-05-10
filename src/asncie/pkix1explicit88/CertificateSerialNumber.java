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
 * Define the ASN1 Type CertificateSerialNumber from ASN1 Module PKIX1Explicit88.
 * @see INTEGER
 */

public class CertificateSerialNumber extends INTEGER {
    
    /**
     * The default constructor.
     */
    public CertificateSerialNumber()
    {
    }
    
    public CertificateSerialNumber(short value)
    {
	super(value);
    }
    
    public CertificateSerialNumber(int value)
    {
	super(value);
    }
    
    public CertificateSerialNumber(long value)
    {
	super(value);
    }
    
    /**
     * Clone 'this' object.
     */
    public CertificateSerialNumber clone() {
	CertificateSerialNumber copy = (CertificateSerialNumber)super.clone();
	copy.setValue(this.longValue());
	return copy;
    }

} // End class definition for CertificateSerialNumber
