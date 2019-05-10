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
 * Define the ASN1 Type IssuerSerial from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class IssuerSerial extends Sequence {
    public GeneralNames issuer;
    public CertificateSerialNumber serial;
    
    /**
     * The default constructor.
     */
    public IssuerSerial()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public IssuerSerial(GeneralNames issuer, CertificateSerialNumber serial)
    {
	setIssuer(issuer);
	setSerial(serial);
    }
    
    /**
     * Construct with required components.
     */
    public IssuerSerial(GeneralNames issuer)
    {
	setIssuer(issuer);
    }
    
    
    // Methods for field "issuer"
    public GeneralNames getIssuer()
    {
	return this.issuer;
    }
    
    public void setIssuer(GeneralNames issuer)
    {
	this.issuer = issuer;
    }
    
    
    // Methods for field "serial"
    public CertificateSerialNumber getSerial()
    {
	return this.serial;
    }
    
    public void setSerial(CertificateSerialNumber serial)
    {
	this.serial = serial;
    }
    
    public boolean hasSerial()
    {
	return (serial != null);
    }
    
    public void deleteSerial()
    {
	serial = null;
    }
    
    
    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((IssuerSerial)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((IssuerSerial)that);
    }
    
    public boolean equalTo(IssuerSerial that) {
	if (!this.issuer.equalTo(that.issuer))
	    return false;
	if (this.serial != null) {
	    if (that.serial == null || !this.serial.equalTo(that.serial))
		return false;
	} else if (that.serial != null)
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public IssuerSerial clone() {
	IssuerSerial copy = (IssuerSerial)super.clone();
	copy.issuer = issuer.clone();
	if (serial != null) {
	    copy.serial = serial.clone();
	}
	return copy;
    }

    /**
     * Returns a hash code for 'this' object.
     */
    public int hashCode() {
	int hash = 3;
	hash = 41 * hash + (this.issuer != null ? this.issuer.hashCode() : 0);
	hash = 41 * hash + (this.serial != null ? this.serial.hashCode() : 0);
	return hash;
    }
} // End class definition for IssuerSerial
