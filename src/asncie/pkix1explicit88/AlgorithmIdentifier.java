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
 * Define the ASN1 Type AlgorithmIdentifier from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class AlgorithmIdentifier extends Sequence {
    public ObjectIdentifier algorithm;
    public OpenType parameters;
    
    /**
     * The default constructor.
     */
    public AlgorithmIdentifier()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public AlgorithmIdentifier(ObjectIdentifier algorithm, 
		    OpenType parameters)
    {
	setAlgorithm(algorithm);
	setParameters(parameters);
    }
    
    /**
     * Construct with required components.
     */
    public AlgorithmIdentifier(ObjectIdentifier algorithm)
    {
	setAlgorithm(algorithm);
    }
    
    
    // Methods for field "algorithm"
    public ObjectIdentifier getAlgorithm()
    {
	return this.algorithm;
    }
    
    public void setAlgorithm(ObjectIdentifier algorithm)
    {
	this.algorithm = algorithm;
    }
    
    
    // Methods for field "parameters"
    public OpenType getParameters()
    {
	return this.parameters;
    }
    
    public void setParameters(OpenType parameters)
    {
	this.parameters = parameters;
    }
    
    public boolean hasParameters()
    {
	return (parameters != null);
    }
    
    public void deleteParameters()
    {
	parameters = null;
    }
    
    
    /**
     * Implements BER value encoder for the type (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public int encodeValue(DerCoder coder, EncoderOutput sink)
	    throws EncoderException
    {
	int len0 = 0;
	AlgorithmIdentifier temp0 = this;

	if (temp0.parameters != null) {
	    try {
		len0 += com.oss.coders.der.DerOpenType.encode(coder, temp0.parameters, sink);
	    } catch (Exception e) {
		EncoderException ee = EncoderException.wrapException(e);
		ee.appendFieldContext("parameters", "Any");
		throw ee;
	    }
	}
	try {
	    len0 += sink.encodeLengthTag(coder.encodeObjectIdentifier(temp0.algorithm, sink), 0x6);
	} catch (Exception e) {
	    EncoderException ee = EncoderException.wrapException(e);
	    ee.appendFieldContext("algorithm", "OBJECT IDENTIFIER");
	    throw ee;
	}

	return len0;
    }

    /**
     * Implements BER value decoder for the type (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public AlgorithmIdentifier decodeValue(BerCoder coder, DecoderInput source)
	    throws DecoderException
    {
	int total_len0 = source.mLength;
	int end_pos0 = (total_len0 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len0);
	int tag;

	do {
	    tag = source.decodeTagLength();
	    if (tag != 0x6)
		source.raiseTagMismatchException(tag);
	    try {
		this.algorithm = new ObjectIdentifier(coder.decodeObjectIdentifier(source));
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendFieldContext("algorithm", "OBJECT IDENTIFIER");
		throw ee;
	    }
	    if (source.position() >= end_pos0)
		break;
	    tag = source.decodeTagLength();
	    if (tag == 0)
		break;
	    try {
		this.parameters = new OpenType();
		this.parameters.setEncodedValue(source.decodeUnknownExtension(tag));
		this.parameters.setDecodedValue(null);
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendFieldContext("parameters", "Any");
		throw ee;
	    }
	    if (source.position() >= end_pos0)
		break;
	    tag = source.decodeTagLength();
	    if (tag == 0)
		break;
	    source.raiseUnknownFieldException(tag);
	} while(false);

	if (source.position() > end_pos0)
	    throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
	if (total_len0 < 0 && source.mLength != 0)
	    throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);

	return this;
    }

    /**
     * Implements value printer for the type (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public void printValue(DataPrinter printer, java.io.PrintWriter writer)
	    throws Exception
    {
	boolean comma0;
	comma0 = false;
	writer.print('{');
	printer.indent();
	comma0 = true;
	try {
	    printer.newLine(writer);
	    writer.print("algorithm ");
	    printer.print(this.algorithm, writer);
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	if (this.parameters != null) {
	    try {
		writer.print(',');
		printer.newLine(writer);
		writer.print("parameters ");
		printer.print(this.parameters, writer);
	    } catch (Exception e) {
		printer.reportError(e, null, writer);
	    }
	}
	printer.undent();
	printer.newLine(writer);
	writer.print('}');
    }

    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((AlgorithmIdentifier)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((AlgorithmIdentifier)that);
    }
    
    public boolean equalTo(AlgorithmIdentifier that) {
	if (!this.algorithm.equalTo(that.algorithm))
	    return false;
	if (this.parameters != null) {
	    if (that.parameters == null || !this.parameters.equalTo(that.parameters))
		return false;
	} else if (that.parameters != null)
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public AlgorithmIdentifier clone() {
	AlgorithmIdentifier copy = (AlgorithmIdentifier)super.clone();
	copy.algorithm = algorithm.clone();
	if (parameters != null) {
	    copy.parameters = parameters.clone();
	}
	return copy;
    }

    /**
     * Returns a hash code for 'this' object.
     */
    public int hashCode() {
	int hash = 3;
	hash = 41 * hash + (this.algorithm != null ? this.algorithm.hashCode() : 0);
	hash = 41 * hash + (this.parameters != null ? this.parameters.hashCode() : 0);
	return hash;
    }
} // End class definition for AlgorithmIdentifier
