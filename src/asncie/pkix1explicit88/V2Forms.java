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
 * Define the ASN1 Type V2Forms from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class V2Forms extends Sequence {
    public GeneralNames issuerName;
    
    /**
     * The default constructor.
     */
    public V2Forms()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public V2Forms(GeneralNames issuerName)
    {
	setIssuerName(issuerName);
    }
    
    
    // Methods for field "issuerName"
    public GeneralNames getIssuerName()
    {
	return this.issuerName;
    }
    
    public void setIssuerName(GeneralNames issuerName)
    {
	this.issuerName = issuerName;
    }
    
    public boolean hasIssuerName()
    {
	return (issuerName != null);
    }
    
    public void deleteIssuerName()
    {
	issuerName = null;
    }
    
    
    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((V2Forms)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((V2Forms)that);
    }
    
    public boolean equalTo(V2Forms that) {
	if (this.issuerName != null) {
	    if (that.issuerName == null || !this.issuerName.equalTo(that.issuerName))
		return false;
	} else if (that.issuerName != null)
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public V2Forms clone() {
	V2Forms copy = (V2Forms)super.clone();
	if (issuerName != null) {
	    copy.issuerName = issuerName.clone();
	}
	return copy;
    }

    /**
     * Returns a hash code for 'this' object.
     */
    public int hashCode() {
	int hash = 3;
	hash = 41 * hash + (this.issuerName != null ? this.issuerName.hashCode() : 0);
	return hash;
    }
} // End class definition for V2Forms
