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
 * Define the ASN1 Type AttCertVersion from ASN1 Module PKIX1Explicit88.
 * @see INTEGER
 */

public class AttCertVersion extends INTEGER {
    
    /**
     * The default constructor.
     */
    public AttCertVersion()
    {
    }
    
    public AttCertVersion(short value)
    {
	super(value);
    }
    
    public AttCertVersion(int value)
    {
	super(value);
    }
    
    public AttCertVersion(long value)
    {
	super(value);
    }
    
    public static final class Value {
	public static final long v2 = 1;
    }
    // Named list definitions.
    
    /**
     * List of named numbers (reserved for internal use).
     * This member is reserved for internal use and must not be used in the application code.
     */
    public final static AttCertVersion cNamedNumbers[] = {
	new AttCertVersion(1)
    };
    public static final AttCertVersion v2 = cNamedNumbers[0];
    
    /**
     * Constant name list definition (reserved for internal use).
     * This member is reserved for internal use and must not be used in the application code.
     */
    public final static String cConstantNameList[] = {
	"v2"
    };
    
    
    protected final static long cFirstNumber = 1;
    protected final static boolean cLinearNumbers = false;
    
    public INTEGER[] getNamedNumbers()
    {
	return cNamedNumbers;
    }
    
    public boolean hasLinearNumbers()
    {
	return cLinearNumbers;
    }
    
    public long getFirstNumber()
    {
	return cFirstNumber;
    }
    
    /**
     * Clone 'this' object.
     */
    public AttCertVersion clone() {
	AttCertVersion copy = (AttCertVersion)super.clone();
	copy.setValue(this.longValue());
	return copy;
    }

} // End class definition for AttCertVersion
