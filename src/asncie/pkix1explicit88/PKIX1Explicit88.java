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

public abstract class PKIX1Explicit88 extends ASN1Module {

    
    
    // Value references
    public static final com.oss.asn1.ObjectIdentifier id_pkix = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07
	    }
	);
    public static final com.oss.asn1.ObjectIdentifier id_pe = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07, (byte)0x01
	    }
	);
    public static final com.oss.asn1.ObjectIdentifier id_qt = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07, (byte)0x02
	    }
	);
    public static final com.oss.asn1.ObjectIdentifier id_kp = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07, (byte)0x03
	    }
	);
    public static final com.oss.asn1.ObjectIdentifier id_ad = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07, (byte)0x30
	    }
	);
    public static final com.oss.asn1.ObjectIdentifier id_qt_cps = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07, (byte)0x02, (byte)0x01
	    }
	);
    public static final com.oss.asn1.ObjectIdentifier id_qt_unotice = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07, (byte)0x02, (byte)0x02
	    }
	);
    public static final com.oss.asn1.ObjectIdentifier id_ad_ocsp = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07, (byte)0x30, (byte)0x01
	    }
	);
    public static final com.oss.asn1.ObjectIdentifier id_ad_caIssuers = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07, (byte)0x30, (byte)0x02
	    }
	);
    public static final com.oss.asn1.ObjectIdentifier id_ad_timeStamping = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07, (byte)0x30, (byte)0x03
	    }
	);
    public static final com.oss.asn1.ObjectIdentifier id_ad_caRepository = 
	new com.oss.asn1.ObjectIdentifier (
	    new byte[] { 
		(byte)0x2B, (byte)0x06, (byte)0x01, (byte)0x05, (byte)0x05, 
		(byte)0x07, (byte)0x30, (byte)0x05
	    }
	);
}
