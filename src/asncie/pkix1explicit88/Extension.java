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
 * Define the ASN1 Type Extension from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class Extension extends Sequence {
    public ObjectIdentifier extnID;
    public BOOLEAN critical;
    public OctetString extnValue;
    
    /**
     * The default constructor.
     */
    public Extension()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public Extension(ObjectIdentifier extnID, BOOLEAN critical, 
		    OctetString extnValue)
    {
	setExtnID(extnID);
	setCritical(critical);
	setExtnValue(extnValue);
    }
    
    /**
     * Construct with components.
     */
    public Extension(ObjectIdentifier extnID, boolean critical, 
		    OctetString extnValue)
    {
	this(extnID, new BOOLEAN(critical), extnValue);
    }
    
    /**
     * Construct with required components.
     */
    public Extension(ObjectIdentifier extnID, OctetString extnValue)
    {
	setExtnID(extnID);
	setExtnValue(extnValue);
    }
    
    // Default Values
    public static final com.oss.asn1.BOOLEAN critical__default = 
	new com.oss.asn1.BOOLEAN(false);
    
    // Methods for field "extnID"
    public ObjectIdentifier getExtnID()
    {
	return this.extnID;
    }
    
    public void setExtnID(ObjectIdentifier extnID)
    {
	this.extnID = extnID;
    }
    
    
    // Methods for field "critical"
    public boolean getCritical()
    {
	if (hasCritical())
	    return (this.critical).booleanValue();
	else
	    return critical__default.booleanValue();
    }
    
    public void setCritical(boolean critical)
    {
	setCritical(new BOOLEAN(critical));
    }
    
    public void setCritical(BOOLEAN critical)
    {
	this.critical = critical;
    }
    
    public void setCriticalToDefault()
    {
	setCritical(critical__default);
    }
    
    public boolean hasDefaultCritical()
    {
	return true;
    }
    
    public boolean hasCritical()
    {
	return (critical != null);
    }
    
    public void deleteCritical()
    {
	critical = null;
    }
    
    
    // Methods for field "extnValue"
    public OctetString getExtnValue()
    {
	return this.extnValue;
    }
    
    public void setExtnValue(OctetString extnValue)
    {
	this.extnValue = extnValue;
    }
    
    
    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((Extension)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((Extension)that);
    }
    
    public boolean equalTo(Extension that) {
	if (!this.extnID.equalTo(that.extnID))
	    return false;
	if (this.critical != null && that.critical != null) {
	    if (!this.critical.equalTo(that.critical))
		return false;
	}
	else if (this.critical != null) {
	    if (!this.critical.equalTo(critical__default))
		return false;
	} else if (that.critical != null) {
	    if (!critical__default.equalTo(that.critical))
		return false;
	}
	if (!this.extnValue.equalTo(that.extnValue))
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public Extension clone() {
	Extension copy = (Extension)super.clone();
	copy.extnID = extnID.clone();
	if (critical != null) {
	    copy.critical = critical.clone();
	}
	copy.extnValue = extnValue.clone();
	return copy;
    }

    /**
     * Returns a hash code for 'this' object.
     */
    public int hashCode() {
	int hash = 3;
	hash = 41 * hash + (this.extnID != null ? this.extnID.hashCode() : 0);
	hash = 41 * hash + (this.critical != null ? this.critical.hashCode() : 0);
	hash = 41 * hash + (this.extnValue != null ? this.extnValue.hashCode() : 0);
	return hash;
    }
} // End class definition for Extension
