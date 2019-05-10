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
 * Define the ASN1 Type ObjectDigestInfo from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class ObjectDigestInfo extends Sequence {
    public DigestedObjectType digestedObjectType;
    public ObjectIdentifier otherObjectTypeID;
    public AlgorithmIdentifier digestAlgorithm;
    public BitString objectDigest;
    
    /**
     * The default constructor.
     */
    public ObjectDigestInfo()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public ObjectDigestInfo(DigestedObjectType digestedObjectType, 
		    ObjectIdentifier otherObjectTypeID, 
		    AlgorithmIdentifier digestAlgorithm, 
		    BitString objectDigest)
    {
	setDigestedObjectType(digestedObjectType);
	setOtherObjectTypeID(otherObjectTypeID);
	setDigestAlgorithm(digestAlgorithm);
	setObjectDigest(objectDigest);
    }
    
    /**
     * Construct with required components.
     */
    public ObjectDigestInfo(DigestedObjectType digestedObjectType, 
		    AlgorithmIdentifier digestAlgorithm, 
		    BitString objectDigest)
    {
	setDigestedObjectType(digestedObjectType);
	setDigestAlgorithm(digestAlgorithm);
	setObjectDigest(objectDigest);
    }
    
    
    // Methods for field "digestedObjectType"
    public DigestedObjectType getDigestedObjectType()
    {
	return this.digestedObjectType;
    }
    
    public void setDigestedObjectType(DigestedObjectType digestedObjectType)
    {
	this.digestedObjectType = digestedObjectType;
    }
    
    
    
    /**
     * Define the ASN1 Type DigestedObjectType from ASN1 Module PKIX1Explicit88.
     * @see Enumerated
     */
    public static final class DigestedObjectType extends Enumerated {
	
	/**
	 * The default constructor.
	 */
	private DigestedObjectType()
	{
	    super(0);
	}
	
	private DigestedObjectType(long value)
	{
	    super(value);
	}
	
	public static final class Value {
	    public static final long publicKey = 0;
	    public static final long publicKeyCert = 1;
	    public static final long otherObjectTypes = 2;
	}
	// Named list definitions.
	
	/**
	 * List of enumerators (reserved for internal use).
	 * This member is reserved for internal use and must not be used in the application code.
	 */
	public final static DigestedObjectType cNamedNumbers[] = {
	    new DigestedObjectType(), 
	    new DigestedObjectType(1), 
	    new DigestedObjectType(2)
	};
	public static final DigestedObjectType publicKey = cNamedNumbers[0];
	public static final DigestedObjectType publicKeyCert = cNamedNumbers[1];
	public static final DigestedObjectType otherObjectTypes = cNamedNumbers[2];
	
	/**
	 * Constant name list definition (reserved for internal use).
	 * This member is reserved for internal use and must not be used in the application code.
	 */
	public final static String cConstantNameList[] = {
	    "publicKey",
	    "publicKeyCert",
	    "otherObjectTypes"
	};
	
	
	/**
	 * Returns the array of enumerators (reserved for internal use).
	 * This method is reserved for internal use and must not be invoked from the application code.
	 */
	public Enumerated[] getNamedNumbers()
	{
	    return cNamedNumbers;
	}
	
	/**
	 * Returns the name of this enumerator.
	 */
	public String name()
	{
	    int index = indexOf();
	    return (index < 0 || index >= 3 || cConstantNameList == null) ? null : cConstantNameList[index];
	}
	
	/**
	 * This method is reserved for internal use and must not be invoked from the application code.
	 */
	public static int indexOfValue(long value)
	{
	    if (value >= 0 && value <= 2)
		return (int)value;
	    else
		return -1;
	}
	
	/**
	 * Returns the enumerator with the specified value or null if the value
	 * is not associated with any enumerator.
	 *  @param value The value of the enumerator to return.
	 *  @return The enumerator with the specified value.
	 */
	
	public static DigestedObjectType valueOf(long value)
	{
	    int inx = indexOfValue(value);
	    
	    if (inx < 0)
		return null;
	    else
		return cNamedNumbers[inx];
	}
	
	/**
	 * This method is reserved for internal use and must not be invoked from the application code.
	 */
	public static DigestedObjectType valueAt(int index)
	{
	    if (index < 0 || index >= 3)
		throw new IndexOutOfBoundsException();
	    
	    return cNamedNumbers[index];
	}
	
	/**
	 * This method is reserved for internal use and must not be invoked from the application code.
	 */
	public int indexOf()
	{
	    return indexOfValue(mValue);
	}
	
	/**
	 * Clone 'this' object.
	 */
	public DigestedObjectType clone() {
	    return (DigestedObjectType)super.clone();
	}

    } // End class definition for DigestedObjectType

    // Methods for field "otherObjectTypeID"
    public ObjectIdentifier getOtherObjectTypeID()
    {
	return this.otherObjectTypeID;
    }
    
    public void setOtherObjectTypeID(ObjectIdentifier otherObjectTypeID)
    {
	this.otherObjectTypeID = otherObjectTypeID;
    }
    
    public boolean hasOtherObjectTypeID()
    {
	return (otherObjectTypeID != null);
    }
    
    public void deleteOtherObjectTypeID()
    {
	otherObjectTypeID = null;
    }
    
    
    // Methods for field "digestAlgorithm"
    public AlgorithmIdentifier getDigestAlgorithm()
    {
	return this.digestAlgorithm;
    }
    
    public void setDigestAlgorithm(AlgorithmIdentifier digestAlgorithm)
    {
	this.digestAlgorithm = digestAlgorithm;
    }
    
    
    // Methods for field "objectDigest"
    public BitString getObjectDigest()
    {
	return this.objectDigest;
    }
    
    public void setObjectDigest(BitString objectDigest)
    {
	this.objectDigest = objectDigest;
    }
    
    
    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((ObjectDigestInfo)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((ObjectDigestInfo)that);
    }
    
    public boolean equalTo(ObjectDigestInfo that) {
	if (!this.digestedObjectType.equalTo(that.digestedObjectType))
	    return false;
	if (this.otherObjectTypeID != null) {
	    if (that.otherObjectTypeID == null || !this.otherObjectTypeID.equalTo(that.otherObjectTypeID))
		return false;
	} else if (that.otherObjectTypeID != null)
	    return false;
	if (!this.digestAlgorithm.equalTo(that.digestAlgorithm))
	    return false;
	if (!this.objectDigest.equalTo(that.objectDigest))
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public ObjectDigestInfo clone() {
	ObjectDigestInfo copy = (ObjectDigestInfo)super.clone();
	copy.digestedObjectType = digestedObjectType.clone();
	if (otherObjectTypeID != null) {
	    copy.otherObjectTypeID = otherObjectTypeID.clone();
	}
	copy.digestAlgorithm = digestAlgorithm.clone();
	copy.objectDigest = objectDigest.clone();
	return copy;
    }

    /**
     * Returns a hash code for 'this' object.
     */
    public int hashCode() {
	int hash = 3;
	hash = 41 * hash + (this.digestedObjectType != null ? this.digestedObjectType.hashCode() : 0);
	hash = 41 * hash + (this.otherObjectTypeID != null ? this.otherObjectTypeID.hashCode() : 0);
	hash = 41 * hash + (this.digestAlgorithm != null ? this.digestAlgorithm.hashCode() : 0);
	hash = 41 * hash + (this.objectDigest != null ? this.objectDigest.hashCode() : 0);
	return hash;
    }
} // End class definition for ObjectDigestInfo
