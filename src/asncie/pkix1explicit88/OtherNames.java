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
 * Define the ASN1 Type OtherNames from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class OtherNames extends Sequence {
    public ObjectIdentifier type_id;
    public PrintableString values;
    
    /**
     * The default constructor.
     */
    public OtherNames()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public OtherNames(ObjectIdentifier type_id, PrintableString values)
    {
	setType_id(type_id);
	setValues(values);
    }
    
    
    // Methods for field "type_id"
    public ObjectIdentifier getType_id()
    {
	return this.type_id;
    }
    
    public void setType_id(ObjectIdentifier type_id)
    {
	this.type_id = type_id;
    }
    
    
    // Methods for field "values"
    public PrintableString getValues()
    {
	return this.values;
    }
    
    public void setValues(PrintableString values)
    {
	this.values = values;
    }
    
    
    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((OtherNames)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((OtherNames)that);
    }
    
    public boolean equalTo(OtherNames that) {
	if (!this.type_id.equalTo(that.type_id))
	    return false;
	if (!this.values.equalTo(that.values))
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public OtherNames clone() {
	OtherNames copy = (OtherNames)super.clone();
	copy.type_id = type_id.clone();
	copy.values = values.clone();
	return copy;
    }

    /**
     * Returns a hash code for 'this' object.
     */
    public int hashCode() {
	int hash = 3;
	hash = 41 * hash + (this.type_id != null ? this.type_id.hashCode() : 0);
	hash = 41 * hash + (this.values != null ? this.values.hashCode() : 0);
	return hash;
    }
} // End class definition for OtherNames
