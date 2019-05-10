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


package asncie;

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

public class Asncie extends ASN1Project {

    /**
     * Initialize the pdu decoder.
     */
    private static final ProjectInfo c_projectInfo = new ProjectInfo (
	null,
	new byte[] {
	    (byte)0x0b, (byte)0x23, (byte)0x0f, (byte)0xea, (byte)0xb5,
	    (byte)0x6b, (byte)0xe6, (byte)0xc4, (byte)0x9a, (byte)0x6b,
	    (byte)0x58, (byte)0x73, (byte)0xc6, (byte)0x52, (byte)0x52,
	    (byte)0xa9, (byte)0x8f, (byte)0xfc, (byte)0x31, (byte)0xac,
	    (byte)0x4e, (byte)0x46, (byte)0xac, (byte)0xa9, (byte)0x9f,
	    (byte)0xe6, (byte)0x4c, (byte)0xe4, (byte)0x7f, (byte)0x8d,
	    (byte)0xd1, (byte)0x09, (byte)0xc9, (byte)0x7b, (byte)0xea,
	    (byte)0x41, (byte)0x7d, (byte)0xcc, (byte)0x42, (byte)0x41,
	    (byte)0xda, (byte)0x57, (byte)0x60, (byte)0xd9, (byte)0x68,
	    (byte)0xfb, (byte)0xd7, (byte)0x22, (byte)0x9a, (byte)0xb8,
	    (byte)0x9d, (byte)0x86, (byte)0x5b, (byte)0x32, (byte)0x6d,
	    (byte)0x0a, (byte)0x89, (byte)0x8d, (byte)0x8d, (byte)0x7f,
	    (byte)0x5a, (byte)0xfb, (byte)0xba, (byte)0x9f, (byte)0xa9,
	    (byte)0xac, (byte)0x46, (byte)0x46, (byte)0xe4, (byte)0x94,
	    (byte)0xd2, (byte)0x2a, (byte)0x40, (byte)0xf7, (byte)0x7d,
	    (byte)0x68, (byte)0x10, (byte)0x8b, (byte)0x9e, (byte)0xa2,
	    (byte)0x13, (byte)0xc7, (byte)0xb3
	},
	"2019/04/17"
    );
    
    /**
     * Get the project descriptor of 'this' object.
     */
    public ProjectInfo getProjectInfo()
    {
	return c_projectInfo;
    }
    
    private static final ASN1Project c_project = new Asncie();

    /**
     * Methods for accessing Coders.
     */
    public static Coder getDefaultCoder()
    {
	return createDERCoder(c_project);
    }
    
    public static DERCoder getDERCoder()
    {
	return createDERCoder(c_project);
    }
    
}
