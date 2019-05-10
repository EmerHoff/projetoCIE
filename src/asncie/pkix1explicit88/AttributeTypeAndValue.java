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
 * Define the ASN1 Type AttributeTypeAndValue from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class AttributeTypeAndValue extends Sequence {
    public ObjectIdentifier type;
    public PrintableString value;
    
    /**
     * The default constructor.
     */
    public AttributeTypeAndValue()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public AttributeTypeAndValue(ObjectIdentifier type, PrintableString value)
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
    public PrintableString getValue()
    {
	return this.value;
    }
    
    public void setValue(PrintableString value)
    {
	this.value = value;
    }
    
    
    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((AttributeTypeAndValue)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((AttributeTypeAndValue)that);
    }
    
    public boolean equalTo(AttributeTypeAndValue that) {
	if (!this.type.equalTo(that.type))
	    return false;
	if (!this.value.equalTo(that.value))
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public AttributeTypeAndValue clone() {
	AttributeTypeAndValue copy = (AttributeTypeAndValue)super.clone();
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
} // End class definition for AttributeTypeAndValue
