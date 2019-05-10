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
 * Define the ASN1 Type RelativeDistinguishedName from ASN1 Module PKIX1Explicit88.
 * @see SetOf
 */

public class RelativeDistinguishedName extends SetOf<AttributeTypeAndValue> {
    
    /**
     * The default constructor.
     */
    public RelativeDistinguishedName()
    {
    }
    
    /**
     * Construct from an array of components.
     */
    public RelativeDistinguishedName(AttributeTypeAndValue[] elements)
    {
	super(elements);
    }
    
    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((RelativeDistinguishedName)that);
    }
    
    public boolean equalTo(SetOf that)
    {
	return equalTo((RelativeDistinguishedName)that);
    }
    
    public boolean equalTo(RelativeDistinguishedName that) {
	int size = this.getSize();
	if (size != that.getSize())
	    return false;
	java.util.BitSet bset = new java.util.BitSet(size);
	for (int i = 0; i < size; i++) {
	    AttributeTypeAndValue element = this.get(i);
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
    public RelativeDistinguishedName clone() {
	RelativeDistinguishedName copy = (RelativeDistinguishedName)super.clone();
	copy.elements = new java.util.ArrayList<AttributeTypeAndValue>(elements.size());
	for (AttributeTypeAndValue element : elements) {
	    copy.elements.add(element.clone());
	}
	return copy;
    }

} // End class definition for RelativeDistinguishedName
