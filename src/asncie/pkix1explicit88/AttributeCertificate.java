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
 * Define the ASN1 Type AttributeCertificate from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class AttributeCertificate extends Sequence implements DEREncodable, BERDecodable {
    public AttributeCertificateInfo acinfo;
    public AlgorithmIdentifier signatureAlgorithm;
    public BitString signatureValue;
    
    /**
     * The default constructor.
     */
    public AttributeCertificate()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public AttributeCertificate(AttributeCertificateInfo acinfo, 
		    AlgorithmIdentifier signatureAlgorithm, 
		    BitString signatureValue)
    {
	setAcinfo(acinfo);
	setSignatureAlgorithm(signatureAlgorithm);
	setSignatureValue(signatureValue);
    }
    
    
    // Methods for field "acinfo"
    public AttributeCertificateInfo getAcinfo()
    {
	return this.acinfo;
    }
    
    public void setAcinfo(AttributeCertificateInfo acinfo)
    {
	this.acinfo = acinfo;
    }
    
    
    // Methods for field "signatureAlgorithm"
    public AlgorithmIdentifier getSignatureAlgorithm()
    {
	return this.signatureAlgorithm;
    }
    
    public void setSignatureAlgorithm(AlgorithmIdentifier signatureAlgorithm)
    {
	this.signatureAlgorithm = signatureAlgorithm;
    }
    
    
    // Methods for field "signatureValue"
    public BitString getSignatureValue()
    {
	return this.signatureValue;
    }
    
    public void setSignatureValue(BitString signatureValue)
    {
	this.signatureValue = signatureValue;
    }
    
    
    /**
     * Encode the PDU using DER (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public int encode(DerCoder coder, EncoderOutput sink)
	    throws EncoderException
    {
	try {
	    int len0 = 0;
	    AttributeCertificate temp0 = this;

	    try {
		int bitsToTransfer = temp0.signatureValue.getSize();
		len0 += sink.encodeLengthTag(coder.encodeBitString(temp0.signatureValue, sink, bitsToTransfer), 0x3);
	    } catch (Exception e) {
		EncoderException ee = EncoderException.wrapException(e);
		ee.appendFieldContext("signatureValue", "BIT STRING");
		throw ee;
	    }
	    try {
		len0 += sink.encodeLengthTag(temp0.signatureAlgorithm.encodeValue(coder, sink), 0x30);
	    } catch (Exception e) {
		EncoderException ee = EncoderException.wrapException(e);
		ee.appendFieldContext("signatureAlgorithm", "AlgorithmIdentifier");
		throw ee;
	    }
	    try {
		len0 += sink.encodeLengthTag(temp0.acinfo.encodeValue(coder, sink), 0x30);
	    } catch (Exception e) {
		EncoderException ee = EncoderException.wrapException(e);
		ee.appendFieldContext("acinfo", "AttributeCertificateInfo");
		throw ee;
	    }

	    return sink.encodeLengthTag(len0, 0x30);
	} catch (Exception e) {
	    EncoderException ee = EncoderException.wrapException(e);
	    ee.appendFieldContext(null, "AttributeCertificate");
	    throw ee;
	}
    }

    /**
     * Decode the PDU using BER (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public AbstractData decode(BerCoder coder, DecoderInput source, int tag)
	    throws DecoderException
    {
	try {
	    if (tag != 0x30)
	    {
		throw new DecoderException(ExceptionDescriptor._pdu_mismatch, null, source.formatTag(tag));
	    }
	    {
		int total_len0 = source.mLength;
		int end_pos0 = (total_len0 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len0);

		tag = source.decodeTagLength();
		if (tag != 0x30)
		    source.raiseTagMismatchException(tag);
		try {
		    this.acinfo = new AttributeCertificateInfo();
		    this.acinfo.decodeValue(coder, source);
		} catch (Exception e) {
		    DecoderException ee = DecoderException.wrapException(e);
		    ee.appendFieldContext("acinfo", "AttributeCertificateInfo");
		    throw ee;
		}
		tag = source.decodeTagLength();
		if (tag != 0x30)
		    source.raiseTagMismatchException(tag);
		try {
		    this.signatureAlgorithm = new AlgorithmIdentifier();
		    this.signatureAlgorithm.decodeValue(coder, source);
		} catch (Exception e) {
		    DecoderException ee = DecoderException.wrapException(e);
		    ee.appendFieldContext("signatureAlgorithm", "AlgorithmIdentifier");
		    throw ee;
		}
		tag = source.decodeTagLength();
		if (tag != 0x3 && tag != 0x23)
		    source.raiseTagMismatchException(tag);
		try {
		    this.signatureValue = new BitString();
		    byte[] b = coder.decodeBitString(source);
		    this.signatureValue.setValue(b, b.length * 8 - coder.getUnused());
		} catch (Exception e) {
		    DecoderException ee = DecoderException.wrapException(e);
		    ee.appendFieldContext("signatureValue", "BIT STRING");
		    throw ee;
		}
		if (source.position() != end_pos0) {
		    if (total_len0 >= 0)
			throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
		    tag = source.decodeTagLength();
		    if (tag != 0 || source.mLength != 0)
			throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
		}
	    }

	    return this;
	} catch (Exception e) {
	    DecoderException ee = DecoderException.wrapException(e);
	    ee.appendFieldContext(null, "AttributeCertificate");
	    throw ee;
	}
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
	    writer.print("acinfo ");
	    this.acinfo.printValue(printer, writer);
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	try {
	    writer.print(',');
	    printer.newLine(writer);
	    writer.print("signatureAlgorithm ");
	    this.signatureAlgorithm.printValue(printer, writer);
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	try {
	    writer.print(',');
	    printer.newLine(writer);
	    writer.print("signatureValue ");
	    printer.print(this.signatureValue, writer);
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	printer.undent();
	printer.newLine(writer);
	writer.print('}');
    }

    /**
     * Return the ASN.1 type name.
     */
    public String getTypeName()
    {
	return "AttributeCertificate";
    }

    /**
     * Compare 'this' object to another object to see if their contents are the same.
     */
    public boolean abstractEqualTo(AbstractData that)
    {
	return equalTo((AttributeCertificate)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((AttributeCertificate)that);
    }
    
    public boolean equalTo(AttributeCertificate that) {
	if (!this.acinfo.equalTo(that.acinfo))
	    return false;
	if (!this.signatureAlgorithm.equalTo(that.signatureAlgorithm))
	    return false;
	if (!this.signatureValue.equalTo(that.signatureValue))
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public AttributeCertificate clone() {
	AttributeCertificate copy = (AttributeCertificate)super.clone();
	copy.acinfo = acinfo.clone();
	copy.signatureAlgorithm = signatureAlgorithm.clone();
	copy.signatureValue = signatureValue.clone();
	return copy;
    }

    /**
     * Returns a hash code for 'this' object.
     */
    public int hashCode() {
	int hash = 3;
	hash = 41 * hash + (this.acinfo != null ? this.acinfo.hashCode() : 0);
	hash = 41 * hash + (this.signatureAlgorithm != null ? this.signatureAlgorithm.hashCode() : 0);
	hash = 41 * hash + (this.signatureValue != null ? this.signatureValue.hashCode() : 0);
	return hash;
    }
    /**
     * The type is a PDU.
     */
    public boolean isPDU()
    {
	return true;
    }
    
    /**
     * This member is reserved for internal use and must not be used in the application code.
     */
    public static final ASN1Type _type = new ASN1Type() {
	public AbstractData newInstance()
	{
	    return new AttributeCertificate();
	}
    };
    
    /**
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public ASN1Type get_ASN1Type()
    {
	return _type;
    }
    
} // End class definition for AttributeCertificate
