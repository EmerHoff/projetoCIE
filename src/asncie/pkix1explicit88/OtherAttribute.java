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
 * Define the ASN1 Type OtherAttribute from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class OtherAttribute extends Sequence {
    public ObjectIdentifier type;
    public Value value;
    
    /**
     * The default constructor.
     */
    public OtherAttribute()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public OtherAttribute(ObjectIdentifier type, Value value)
    {
	setType(type);
	setValue(value);
    }
    
    
    // Methods for field "type"
    public ObjectIdentifier getType()
    {
	return this.type;
    }
    
    public void setType(ObjectIdentifier type)
    {
	this.type = type;
    }
    
    
    // Methods for field "value"
    public Value getValue()
    {
	return this.value;
    }
    
    public void setValue(Value value)
    {
	this.value = value;
    }
    
    
    
    /**
     * Define the ASN1 Type Value from ASN1 Module PKIX1Explicit88.
     * @see SetOf
     */
    public static class Value extends SetOf<AttributeValue> {
	
	/**
	 * The default constructor.
	 */
	public Value()
	{
	}
	
	/**
	 * Construct from an array of components.
	 */
	public Value(AttributeValue[] elements)
	{
	    super(elements);
	}
	
	/**
	 * Compare 'this' object to another object to see if their contents are the same.
	 */
	public boolean abstractEqualTo(AbstractData that)
	{
	    return equalTo((Value)that);
	}
	
	public boolean equalTo(SetOf that)
	{
	    return equalTo((Value)that);
	}
	
	public boolean equalTo(Value that) {
	    int size = this.getSize();
	    if (size != that.getSize())
		return false;
	    java.util.BitSet bset = new java.util.BitSet(size);
	    for (int i = 0; i < size; i++) {
		AttributeValue element = this.get(i);
		boolean found = false;
		for (int j = 0; j < size; j++) {
		    if (bset.get(j))
			continue;
		    if (element.equalTo(that.get(j))) {
			found = true;
			bset.set(j);
			break;
		    }
		}
		if (!found)
		    return false;
	    }
	    return true;
	}

	/**
	 * Clone 'this' object.
	 */
	public Value clone() {
	    Value copy = (Value)super.clone();
	    copy.elements = new java.util.ArrayList<AttributeValue>(elements.size());
	    for (AttributeValue element : elements) {
		copy.elements.add(element.clone());
	    }
	    return copy;
	}

    } // End class definition for Value

    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((OtherAttribute)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((OtherAttribute)that);
    }
    
    public boolean equalTo(OtherAttribute that) {
	if (!this.type.equalTo(that.type))
	    return false;
	if (!this.value.equalTo(that.value))
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public OtherAttribute clone() {
	OtherAttribute copy = (OtherAttribute)super.clone();
	copy.type = type.clone();
	copy.value = value.clone();
	return copy;
    }

    /**
     * Returns a hash code for 'this' object.
     */
    public int hashCode() {
	int hash = 3;
	hash = 41 * hash + (this.type != null ? this.type.hashCode() : 0);
	hash = 41 * hash + (this.value != null ? this.value.hashCode() : 0);
	return hash;
    }
} // End class definition for OtherAttribute
