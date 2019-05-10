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
 * Define the ASN1 Type Holder from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class Holder extends Sequence {
    public IssuerSerial baseCertificateID;
    public GeneralNames entityName;
    public ObjectDigestInfo objectDigestInfo;
    
    /**
     * The default constructor.
     */
    public Holder()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public Holder(IssuerSerial baseCertificateID, GeneralNames entityName, 
		    ObjectDigestInfo objectDigestInfo)
    {
	setBaseCertificateID(baseCertificateID);
	setEntityName(entityName);
	setObjectDigestInfo(objectDigestInfo);
    }
    
    
    // Methods for field "baseCertificateID"
    public IssuerSerial getBaseCertificateID()
    {
	return this.baseCertificateID;
    }
    
    public void setBaseCertificateID(IssuerSerial baseCertificateID)
    {
	this.baseCertificateID = baseCertificateID;
    }
    
    public boolean hasBaseCertificateID()
    {
	return (baseCertificateID != null);
    }
    
    public void deleteBaseCertificateID()
    {
	baseCertificateID = null;
    }
    
    
    // Methods for field "entityName"
    public GeneralNames getEntityName()
    {
	return this.entityName;
    }
    
    public void setEntityName(GeneralNames entityName)
    {
	this.entityName = entityName;
    }
    
    public boolean hasEntityName()
    {
	return (entityName != null);
    }
    
    public void deleteEntityName()
    {
	entityName = null;
    }
    
    
    // Methods for field "objectDigestInfo"
    public ObjectDigestInfo getObjectDigestInfo()
    {
	return this.objectDigestInfo;
    }
    
    public void setObjectDigestInfo(ObjectDigestInfo objectDigestInfo)
    {
	this.objectDigestInfo = objectDigestInfo;
    }
    
    public boolean hasObjectDigestInfo()
    {
	return (objectDigestInfo != null);
    }
    
    public void deleteObjectDigestInfo()
    {
	objectDigestInfo = null;
    }
    
    
    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((Holder)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((Holder)that);
    }
    
    public boolean equalTo(Holder that) {
	if (this.baseCertificateID != null) {
	    if (that.baseCertificateID == null || !this.baseCertificateID.equalTo(that.baseCertificateID))
		return false;
	} else if (that.baseCertificateID != null)
	    return false;
	if (this.entityName != null) {
	    if (that.entityName == null || !this.entityName.equalTo(that.entityName))
		return false;
	} else if (that.entityName != null)
	    return false;
	if (this.objectDigestInfo != null) {
	    if (that.objectDigestInfo == null || !this.objectDigestInfo.equalTo(that.objectDigestInfo))
		return false;
	} else if (that.objectDigestInfo != null)
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public Holder clone() {
	Holder copy = (Holder)super.clone();
	if (baseCertificateID != null) {
	    copy.baseCertificateID = baseCertificateID.clone();
	}
	if (entityName != null) {
	    copy.entityName = entityName.clone();
	}
	if (objectDigestInfo != null) {
	    copy.objectDigestInfo = objectDigestInfo.clone();
	}
	return copy;
    }

    /**
     * Returns a hash code for 'this' object.
     */
    public int hashCode() {
	int hash = 3;
	hash = 41 * hash + (this.baseCertificateID != null ? this.baseCertificateID.hashCode() : 0);
	hash = 41 * hash + (this.entityName != null ? this.entityName.hashCode() : 0);
	hash = 41 * hash + (this.objectDigestInfo != null ? this.objectDigestInfo.hashCode() : 0);
	return hash;
    }
} // End class definition for Holder
