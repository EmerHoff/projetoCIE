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
 * Define the ASN1 Type AttributeCertificateInfo from ASN1 Module PKIX1Explicit88.
 * @see Sequence
 */

public class AttributeCertificateInfo extends Sequence {
    public AttCertVersion version;
    public Holder holder;
    public AttCertIssuer issuer;
    public AlgorithmIdentifier signature;
    public CertificateSerialNumber serialNumber;
    public AttCertValidityPeriod attrCertValidityPeriod;
    public NameAttributes attributes;
    public Extensions extensions;
    
    /**
     * The default constructor.
     */
    public AttributeCertificateInfo()
    {
    }
    
    /**
     * Construct with AbstractData components.
     */
    public AttributeCertificateInfo(AttCertVersion version, Holder holder, 
		    AttCertIssuer issuer, AlgorithmIdentifier signature, 
		    CertificateSerialNumber serialNumber, 
		    AttCertValidityPeriod attrCertValidityPeriod, 
		    NameAttributes attributes, Extensions extensions)
    {
	setVersion(version);
	setHolder(holder);
	setIssuer(issuer);
	setSignature(signature);
	setSerialNumber(serialNumber);
	setAttrCertValidityPeriod(attrCertValidityPeriod);
	setAttributes(attributes);
	setExtensions(extensions);
    }
    
    /**
     * Construct with required components.
     */
    public AttributeCertificateInfo(AttCertVersion version, Holder holder, 
		    AttCertIssuer issuer, AlgorithmIdentifier signature, 
		    CertificateSerialNumber serialNumber, 
		    AttCertValidityPeriod attrCertValidityPeriod, 
		    NameAttributes attributes)
    {
	setVersion(version);
	setHolder(holder);
	setIssuer(issuer);
	setSignature(signature);
	setSerialNumber(serialNumber);
	setAttrCertValidityPeriod(attrCertValidityPeriod);
	setAttributes(attributes);
    }
    
    
    // Methods for field "version"
    public AttCertVersion getVersion()
    {
	return this.version;
    }
    
    public void setVersion(AttCertVersion version)
    {
	this.version = version;
    }
    
    
    // Methods for field "holder"
    public Holder getHolder()
    {
	return this.holder;
    }
    
    public void setHolder(Holder holder)
    {
	this.holder = holder;
    }
    
    
    // Methods for field "issuer"
    public AttCertIssuer getIssuer()
    {
	return this.issuer;
    }
    
    public void setIssuer(AttCertIssuer issuer)
    {
	this.issuer = issuer;
    }
    
    
    // Methods for field "signature"
    public AlgorithmIdentifier getSignature()
    {
	return this.signature;
    }
    
    public void setSignature(AlgorithmIdentifier signature)
    {
	this.signature = signature;
    }
    
    
    // Methods for field "serialNumber"
    public CertificateSerialNumber getSerialNumber()
    {
	return this.serialNumber;
    }
    
    public void setSerialNumber(CertificateSerialNumber serialNumber)
    {
	this.serialNumber = serialNumber;
    }
    
    
    // Methods for field "attrCertValidityPeriod"
    public AttCertValidityPeriod getAttrCertValidityPeriod()
    {
	return this.attrCertValidityPeriod;
    }
    
    public void setAttrCertValidityPeriod(AttCertValidityPeriod attrCertValidityPeriod)
    {
	this.attrCertValidityPeriod = attrCertValidityPeriod;
    }
    
    
    // Methods for field "attributes"
    public NameAttributes getAttributes()
    {
	return this.attributes;
    }
    
    public void setAttributes(NameAttributes attributes)
    {
	this.attributes = attributes;
    }
    
    
    // Methods for field "extensions"
    public Extensions getExtensions()
    {
	return this.extensions;
    }
    
    public void setExtensions(Extensions extensions)
    {
	this.extensions = extensions;
    }
    
    public boolean hasExtensions()
    {
	return (extensions != null);
    }
    
    public void deleteExtensions()
    {
	extensions = null;
    }
    
    
    /**
     * Implements BER value encoder for the type (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public int encodeValue(DerCoder coder, EncoderOutput sink)
	    throws EncoderException
    {
	int len0 = 0;
	AttributeCertificateInfo temp0 = this;

	if (temp0.extensions != null) {
	    try {
		int len1 = 0;
		java.util.ArrayList<Extension> temp1 = temp0.extensions.elements;
		int idx1 = temp1 != null ? temp1.size() : 0;

		try {
		    while(idx1-- > 0) {
			int len2 = 0;
			Extension temp2 = temp1.get(idx1);

			try {
			    len2 += sink.encodeLengthTag(sink.write(temp2.extnValue.byteArrayValue()), 0x4);
			} catch (Exception e) {
			    EncoderException ee = EncoderException.wrapException(e);
			    ee.appendFieldContext("extnValue", "OCTET STRING");
			    throw ee;
			}
			if (temp2.critical != null) {
			    if (!temp2.critical__default.abstractEqualTo(temp2.critical)) {
				try {
				    len2 += sink.encodeLengthTag(coder.encodeBoolean(temp2.critical, sink), 0x1);
				} catch (Exception e) {
				    EncoderException ee = EncoderException.wrapException(e);
				    ee.appendFieldContext("critical", "BOOLEAN");
				    throw ee;
				}
			    }
			}
			try {
			    len2 += sink.encodeLengthTag(coder.encodeObjectIdentifier(temp2.extnID, sink), 0x6);
			} catch (Exception e) {
			    EncoderException ee = EncoderException.wrapException(e);
			    ee.appendFieldContext("extnID", "OBJECT IDENTIFIER");
			    throw ee;
			}
			len1 += sink.encodeLengthTag(len2, 0x30);
		    }
		} catch (Exception e) {
		    EncoderException ee = EncoderException.wrapException(e);
		    ee.appendElementContext(null, "Extension", idx1);
		    throw ee;
		}
		len0 += sink.encodeLengthTag(len1, 0x30);
	    } catch (Exception e) {
		EncoderException ee = EncoderException.wrapException(e);
		ee.appendFieldContext("extensions", "Extensions");
		throw ee;
	    }
	}
	try {
	    int len1 = 0;
	    java.util.ArrayList<OtherAttribute> temp1 = temp0.attributes.elements;
	    int idx1 = temp1 != null ? temp1.size() : 0;

	    try {
		while(idx1-- > 0) {
		    int len2 = 0;
		    OtherAttribute temp2 = temp1.get(idx1);

		    try {
			int len3 = 0;
			java.util.ArrayList<AttributeValue> temp3 = temp2.value.elements;
			int idx3 = temp3 != null ? temp3.size() : 0;

			com.oss.coders.der.SetOfEncodings encodings_temp3 =
			    new com.oss.coders.der.SetOfEncodings((com.oss.coders.ber.OSSRevOutputStream)sink, idx3);
			try {
			    while(idx3-- > 0) {
				len3 += encodings_temp3.encodeLengthTag(coder.encodeString1(temp3.get(idx3), encodings_temp3), 0x13);
				encodings_temp3.markElement();
			    }
			    encodings_temp3.flush();
			} catch (Exception e) {
			    EncoderException ee = EncoderException.wrapException(e);
			    ee.appendElementContext(null, "AttributeValue", idx3);
			    throw ee;
			} finally {
			    if (encodings_temp3 != null)
				encodings_temp3.reset();
			}
			len2 += sink.encodeLengthTag(len3, 0x31);
		    } catch (Exception e) {
			EncoderException ee = EncoderException.wrapException(e);
			ee.appendFieldContext("value", "SET OF");
			throw ee;
		    }
		    try {
			len2 += sink.encodeLengthTag(coder.encodeObjectIdentifier(temp2.type, sink), 0x6);
		    } catch (Exception e) {
			EncoderException ee = EncoderException.wrapException(e);
			ee.appendFieldContext("type", "OBJECT IDENTIFIER");
			throw ee;
		    }
		    len1 += sink.encodeLengthTag(len2, 0x30);
		}
	    } catch (Exception e) {
		EncoderException ee = EncoderException.wrapException(e);
		ee.appendElementContext(null, "OtherAttribute", idx1);
		throw ee;
	    }
	    len0 += sink.encodeLengthTag(len1, 0x30);
	} catch (Exception e) {
	    EncoderException ee = EncoderException.wrapException(e);
	    ee.appendFieldContext("attributes", "NameAttributes");
	    throw ee;
	}
	try {
	    int len1 = 0;
	    AttCertValidityPeriod temp1 = temp0.attrCertValidityPeriod;

	    try {
		len1 += sink.encodeLengthTag(coder.encodeTime_Def(temp1.notAfterTime, sink), 0x18);
	    } catch (Exception e) {
		EncoderException ee = EncoderException.wrapException(e);
		ee.appendFieldContext("notAfterTime", "GeneralizedTime");
		throw ee;
	    }
	    try {
		len1 += sink.encodeLengthTag(coder.encodeTime_Def(temp1.notBeforeTime, sink), 0x18);
	    } catch (Exception e) {
		EncoderException ee = EncoderException.wrapException(e);
		ee.appendFieldContext("notBeforeTime", "GeneralizedTime");
		throw ee;
	    }
	    len0 += sink.encodeLengthTag(len1, 0x30);
	} catch (Exception e) {
	    EncoderException ee = EncoderException.wrapException(e);
	    ee.appendFieldContext("attrCertValidityPeriod", "AttCertValidityPeriod");
	    throw ee;
	}
	try {
	    len0 += sink.encodeLengthTag(coder.encodeInteger(temp0.serialNumber, sink), 0x2);
	} catch (Exception e) {
	    EncoderException ee = EncoderException.wrapException(e);
	    ee.appendFieldContext("serialNumber", "CertificateSerialNumber");
	    throw ee;
	}
	try {
	    len0 += sink.encodeLengthTag(temp0.signature.encodeValue(coder, sink), 0x30);
	} catch (Exception e) {
	    EncoderException ee = EncoderException.wrapException(e);
	    ee.appendFieldContext("signature", "AlgorithmIdentifier");
	    throw ee;
	}
	try {
	    int len1 = 0;

	    switch (temp0.issuer.getChosenFlag()) {
	    case AttCertIssuer.v2Form_chosen:
		try {
		    int len2 = 0;
		    V2Forms temp2 = ((V2Forms)temp0.issuer.getChosenValue());

		    if (temp2.issuerName != null) {
			try {
			    len2 += temp2.issuerName.encodeValue(coder, sink);
			} catch (Exception e) {
			    EncoderException ee = EncoderException.wrapException(e);
			    ee.appendFieldContext("issuerName", "GeneralNames");
			    throw ee;
			}
		    }
		    len1 = sink.encodeLengthTag2(len2, 0x30, 0xA0);
		} catch (Exception e) {
		    EncoderException ee = EncoderException.wrapException(e);
		    ee.appendElementContext("v2Form", "V2Forms", 0);
		    throw ee;
		}
		break;

	    default:
		throw new EncoderException(ExceptionDescriptor._bad_choice, null);
	    }
	    len0 += len1;
	} catch (Exception e) {
	    EncoderException ee = EncoderException.wrapException(e);
	    ee.appendFieldContext("issuer", "AttCertIssuer");
	    throw ee;
	}
	try {
	    int len1 = 0;
	    Holder temp1 = temp0.holder;

	    if (temp1.objectDigestInfo != null) {
		try {
		    int len2 = 0;
		    ObjectDigestInfo temp2 = temp1.objectDigestInfo;

		    try {
			int bitsToTransfer = temp2.objectDigest.getSize();
			len2 += sink.encodeLengthTag(coder.encodeBitString(temp2.objectDigest, sink, bitsToTransfer), 0x3);
		    } catch (Exception e) {
			EncoderException ee = EncoderException.wrapException(e);
			ee.appendFieldContext("objectDigest", "BIT STRING");
			throw ee;
		    }
		    try {
			len2 += sink.encodeLengthTag(temp2.digestAlgorithm.encodeValue(coder, sink), 0x30);
		    } catch (Exception e) {
			EncoderException ee = EncoderException.wrapException(e);
			ee.appendFieldContext("digestAlgorithm", "AlgorithmIdentifier");
			throw ee;
		    }
		    if (temp2.otherObjectTypeID != null) {
			try {
			    len2 += sink.encodeLengthTag(coder.encodeObjectIdentifier(temp2.otherObjectTypeID, sink), 0x6);
			} catch (Exception e) {
			    EncoderException ee = EncoderException.wrapException(e);
			    ee.appendFieldContext("otherObjectTypeID", "OBJECT IDENTIFIER");
			    throw ee;
			}
		    }
		    try {
			len2 += sink.encodeLengthTag(coder.encodeEnumerated(temp2.digestedObjectType, sink), 0xA);
		    } catch (Exception e) {
			EncoderException ee = EncoderException.wrapException(e);
			ee.appendFieldContext("digestedObjectType", "ENUMERATED");
			throw ee;
		    }
		    len1 += sink.encodeLengthTag2(len2, 0x30, 0xA2);
		} catch (Exception e) {
		    EncoderException ee = EncoderException.wrapException(e);
		    ee.appendFieldContext("objectDigestInfo", "ObjectDigestInfo");
		    throw ee;
		}
	    }
	    if (temp1.entityName != null) {
		try {
		    len1 += sink.encodeLengthTag(temp1.entityName.encodeValue(coder, sink), 0xA1);
		} catch (Exception e) {
		    EncoderException ee = EncoderException.wrapException(e);
		    ee.appendFieldContext("entityName", "GeneralNames");
		    throw ee;
		}
	    }
	    if (temp1.baseCertificateID != null) {
		try {
		    int len2 = 0;
		    IssuerSerial temp2 = temp1.baseCertificateID;

		    if (temp2.serial != null) {
			try {
			    len2 += sink.encodeLengthTag(coder.encodeInteger(temp2.serial, sink), 0x2);
			} catch (Exception e) {
			    EncoderException ee = EncoderException.wrapException(e);
			    ee.appendFieldContext("serial", "CertificateSerialNumber");
			    throw ee;
			}
		    }
		    try {
			len2 += temp2.issuer.encodeValue(coder, sink);
		    } catch (Exception e) {
			EncoderException ee = EncoderException.wrapException(e);
			ee.appendFieldContext("issuer", "GeneralNames");
			throw ee;
		    }
		    len1 += sink.encodeLengthTag2(len2, 0x30, 0xA0);
		} catch (Exception e) {
		    EncoderException ee = EncoderException.wrapException(e);
		    ee.appendFieldContext("baseCertificateID", "IssuerSerial");
		    throw ee;
		}
	    }
	    len0 += sink.encodeLengthTag(len1, 0x30);
	} catch (Exception e) {
	    EncoderException ee = EncoderException.wrapException(e);
	    ee.appendFieldContext("holder", "Holder");
	    throw ee;
	}
	try {
	    len0 += sink.encodeLengthTag(coder.encodeInteger(temp0.version, sink), 0x2);
	} catch (Exception e) {
	    EncoderException ee = EncoderException.wrapException(e);
	    ee.appendFieldContext("version", "AttCertVersion");
	    throw ee;
	}

	return len0;
    }

    /**
     * Implements BER value decoder for the type (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public AttributeCertificateInfo decodeValue(BerCoder coder, DecoderInput source)
	    throws DecoderException
    {
	int total_len0 = source.mLength;
	int end_pos0 = (total_len0 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len0);
	int tag;

	do {
	    tag = source.decodeTagLength();
	    if (tag != 0x2)
		source.raiseTagMismatchException(tag);
	    try {
		this.version = new AttCertVersion(source.decodeLong());
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendFieldContext("version", "AttCertVersion");
		throw ee;
	    }
	    tag = source.decodeTagLength();
	    if (tag != 0x30)
		source.raiseTagMismatchException(tag);
	    try {
		this.holder = new Holder();
		{
		    int total_len1 = source.mLength;
		    int end_pos1 = (total_len1 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len1);

		    do {
			if (source.position() >= end_pos1)
			    break;
			tag = source.decodeTagLength();
			if (tag == 0)
			    break;
			if (tag == 0xA0) {
			    try {
				this.holder.baseCertificateID = new IssuerSerial();
				{
				    int indef_tags2 = 0;

				    if (source.mLength < 0)
					++indef_tags2;
				    tag = source.decodeTagLength();
				    if (tag != 0x30)
					source.raiseTagMismatchException(tag);
				    {
					int total_len2 = source.mLength;
					int end_pos2 = (total_len2 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len2);

					do {
					    tag = source.decodeTagLength();
					    if (tag != 0xA0 && tag != 0xA4)
						source.raiseTagMismatchException(tag);
					    try {
						this.holder.baseCertificateID.issuer = new GeneralNames();
						this.holder.baseCertificateID.issuer.decodeValue(coder, source, tag);
					    } catch (Exception e) {
						DecoderException ee = DecoderException.wrapException(e);
						ee.appendFieldContext("issuer", "GeneralNames");
						throw ee;
					    }
					    if (source.position() >= end_pos2)
						break;
					    tag = source.decodeTagLength();
					    if (tag == 0)
						break;
					    if (tag == 0x2) {
						try {
						    this.holder.baseCertificateID.serial = new CertificateSerialNumber(source.decodeLong());
						} catch (Exception e) {
						    DecoderException ee = DecoderException.wrapException(e);
						    ee.appendFieldContext("serial", "CertificateSerialNumber");
						    throw ee;
						}
						if (source.position() >= end_pos2)
						    break;
						tag = source.decodeTagLength();
						if (tag == 0)
						    break;
					    }
					    source.raiseUnknownFieldException(tag);
					} while(false);

					if (source.position() > end_pos2)
					    throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
					if (total_len2 < 0 && source.mLength != 0)
					    throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
				    }
				    if (indef_tags2 > 0)
					coder.consumeEOCs(source, indef_tags2);
				}
			    } catch (Exception e) {
				DecoderException ee = DecoderException.wrapException(e);
				ee.appendFieldContext("baseCertificateID", "IssuerSerial");
				throw ee;
			    }
			    if (source.position() >= end_pos1)
				break;
			    tag = source.decodeTagLength();
			    if (tag == 0)
				break;
			}
			if (tag == 0xA1) {
			    try {
				this.holder.entityName = new GeneralNames();
				{
				    int indef_tags2 = 0;

				    if (source.mLength < 0)
					++indef_tags2;
				    this.holder.entityName.decodeValue(coder, source, source.decodeTagLength());
				    if (indef_tags2 > 0)
					coder.consumeEOCs(source, indef_tags2);
				}
			    } catch (Exception e) {
				DecoderException ee = DecoderException.wrapException(e);
				ee.appendFieldContext("entityName", "GeneralNames");
				throw ee;
			    }
			    if (source.position() >= end_pos1)
				break;
			    tag = source.decodeTagLength();
			    if (tag == 0)
				break;
			}
			if (tag == 0xA2) {
			    try {
				this.holder.objectDigestInfo = new ObjectDigestInfo();
				{
				    int indef_tags2 = 0;

				    if (source.mLength < 0)
					++indef_tags2;
				    tag = source.decodeTagLength();
				    if (tag != 0x30)
					source.raiseTagMismatchException(tag);
				    {
					int total_len2 = source.mLength;
					int end_pos2 = (total_len2 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len2);

					tag = source.decodeTagLength();
					if (tag != 0xA)
					    source.raiseTagMismatchException(tag);
					try {
					    int idx3 = asncie.pkix1explicit88.ObjectDigestInfo.DigestedObjectType.indexOfValue(source.decodeInt());
					    if (idx3 < 0)
						throw new DecoderException(ExceptionDescriptor._not_enumerated, null);
					    this.holder.objectDigestInfo.digestedObjectType = asncie.pkix1explicit88.ObjectDigestInfo.DigestedObjectType.cNamedNumbers[idx3];
					} catch (Exception e) {
					    DecoderException ee = DecoderException.wrapException(e);
					    ee.appendFieldContext("digestedObjectType", "ENUMERATED");
					    throw ee;
					}
					tag = source.decodeTagLength();
					if (tag == 0x6) {
					    try {
						this.holder.objectDigestInfo.otherObjectTypeID = new ObjectIdentifier(coder.decodeObjectIdentifier(source));
					    } catch (Exception e) {
						DecoderException ee = DecoderException.wrapException(e);
						ee.appendFieldContext("otherObjectTypeID", "OBJECT IDENTIFIER");
						throw ee;
					    }
					    tag = source.decodeTagLength();
					}
					if (tag != 0x30)
					    source.raiseTagMismatchException(tag);
					try {
					    this.holder.objectDigestInfo.digestAlgorithm = new AlgorithmIdentifier();
					    this.holder.objectDigestInfo.digestAlgorithm.decodeValue(coder, source);
					} catch (Exception e) {
					    DecoderException ee = DecoderException.wrapException(e);
					    ee.appendFieldContext("digestAlgorithm", "AlgorithmIdentifier");
					    throw ee;
					}
					tag = source.decodeTagLength();
					if (tag != 0x3 && tag != 0x23)
					    source.raiseTagMismatchException(tag);
					try {
					    this.holder.objectDigestInfo.objectDigest = new BitString();
					    byte[] b = coder.decodeBitString(source);
					    this.holder.objectDigestInfo.objectDigest.setValue(b, b.length * 8 - coder.getUnused());
					} catch (Exception e) {
					    DecoderException ee = DecoderException.wrapException(e);
					    ee.appendFieldContext("objectDigest", "BIT STRING");
					    throw ee;
					}
					if (source.position() != end_pos2) {
					    if (total_len2 >= 0)
						throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
					    tag = source.decodeTagLength();
					    if (tag != 0 || source.mLength != 0)
						throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
					}
				    }
				    if (indef_tags2 > 0)
					coder.consumeEOCs(source, indef_tags2);
				}
			    } catch (Exception e) {
				DecoderException ee = DecoderException.wrapException(e);
				ee.appendFieldContext("objectDigestInfo", "ObjectDigestInfo");
				throw ee;
			    }
			    if (source.position() >= end_pos1)
				break;
			    tag = source.decodeTagLength();
			    if (tag == 0)
				break;
			}
			source.raiseUnknownFieldException(tag);
		    } while(false);

		    if (source.position() > end_pos1)
			throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
		    if (total_len1 < 0 && source.mLength != 0)
			throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
		}
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendFieldContext("holder", "Holder");
		throw ee;
	    }
	    tag = source.decodeTagLength();
	    if (tag != 0xA0)
		source.raiseTagMismatchException(tag);
	    try {
		this.issuer = new AttCertIssuer();
		switch (tag) {
		case 0xA0:
		    try {
			this.issuer.setChosenFlag(AttCertIssuer.v2Form_chosen);
			this.issuer.setChosenValue(new V2Forms());
			{
			    int indef_tags2 = 0;

			    if (source.mLength < 0)
				++indef_tags2;
			    tag = source.decodeTagLength();
			    if (tag != 0x30)
				source.raiseTagMismatchException(tag);
			    {
				int total_len2 = source.mLength;
				int end_pos2 = (total_len2 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len2);
				V2Forms temp2 = ((V2Forms)this.issuer.getChosenValue());

				do {
				    if (source.position() >= end_pos2)
					break;
				    tag = source.decodeTagLength();
				    if (tag == 0)
					break;
				    if (tag == 0xA0 || tag == 0xA4) {
					try {
					    temp2.issuerName = new GeneralNames();
					    temp2.issuerName.decodeValue(coder, source, tag);
					} catch (Exception e) {
					    DecoderException ee = DecoderException.wrapException(e);
					    ee.appendFieldContext("issuerName", "GeneralNames");
					    throw ee;
					}
					if (source.position() >= end_pos2)
					    break;
					tag = source.decodeTagLength();
					if (tag == 0)
					    break;
				    }
				    source.raiseUnknownFieldException(tag);
				} while(false);

				if (source.position() > end_pos2)
				    throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
				if (total_len2 < 0 && source.mLength != 0)
				    throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
			    }
			    if (indef_tags2 > 0)
				coder.consumeEOCs(source, indef_tags2);
			}
		    } catch (Exception e) {
			DecoderException ee = DecoderException.wrapException(e);
			ee.appendElementContext("v2Form", "V2Forms", 0);
			throw ee;
		    }
		    break;

		default:
		    source.raiseUnknownFieldException(tag);
		}
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendFieldContext("issuer", "AttCertIssuer");
		throw ee;
	    }
	    tag = source.decodeTagLength();
	    if (tag != 0x30)
		source.raiseTagMismatchException(tag);
	    try {
		this.signature = new AlgorithmIdentifier();
		this.signature.decodeValue(coder, source);
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendFieldContext("signature", "AlgorithmIdentifier");
		throw ee;
	    }
	    tag = source.decodeTagLength();
	    if (tag != 0x2)
		source.raiseTagMismatchException(tag);
	    try {
		this.serialNumber = new CertificateSerialNumber(source.decodeLong());
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendFieldContext("serialNumber", "CertificateSerialNumber");
		throw ee;
	    }
	    tag = source.decodeTagLength();
	    if (tag != 0x30)
		source.raiseTagMismatchException(tag);
	    try {
		this.attrCertValidityPeriod = new AttCertValidityPeriod();
		{
		    int total_len1 = source.mLength;
		    int end_pos1 = (total_len1 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len1);

		    tag = source.decodeTagLength();
		    if (tag != 0x18)
			source.raiseTagMismatchException(tag);
		    try {
			this.attrCertValidityPeriod.notBeforeTime = new GeneralizedTime();
			coder.decodeTime(this.attrCertValidityPeriod.notBeforeTime, source);
		    } catch (Exception e) {
			DecoderException ee = DecoderException.wrapException(e);
			ee.appendFieldContext("notBeforeTime", "GeneralizedTime");
			throw ee;
		    }
		    tag = source.decodeTagLength();
		    if (tag != 0x18)
			source.raiseTagMismatchException(tag);
		    try {
			this.attrCertValidityPeriod.notAfterTime = new GeneralizedTime();
			coder.decodeTime(this.attrCertValidityPeriod.notAfterTime, source);
		    } catch (Exception e) {
			DecoderException ee = DecoderException.wrapException(e);
			ee.appendFieldContext("notAfterTime", "GeneralizedTime");
			throw ee;
		    }
		    if (source.position() != end_pos1) {
			if (total_len1 >= 0)
			    throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
			tag = source.decodeTagLength();
			if (tag != 0 || source.mLength != 0)
			    throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
		    }
		}
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendFieldContext("attrCertValidityPeriod", "AttCertValidityPeriod");
		throw ee;
	    }
	    tag = source.decodeTagLength();
	    if (tag != 0x30)
		source.raiseTagMismatchException(tag);
	    try {
		this.attributes = new NameAttributes();
		{
		    int total_len1 = source.mLength;
		    int end_pos1 = (total_len1 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len1);
		    int idx1 = 0;

		    this.attributes.elements = new java.util.ArrayList<OtherAttribute>();

		    try {
			for (;;) {
			    if (source.position() >= end_pos1) {
				if (source.position() > end_pos1)
				    throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
				break;
			    }
			    tag = source.decodeTagLength();
			    if (tag == 0) {
				if (total_len1 < 0) {
				    if (source.mLength != 0)
					throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
				    break;
				}
				if (source.mLength == 0)
				    throw new DecoderException(ExceptionDescriptor._expect_tag, null);
			    }
			    OtherAttribute temp1 = new OtherAttribute();
			    this.attributes.add(temp1);
			    if (tag != 0x30)
				source.raiseTagMismatchException(tag);
			    {
				int total_len2 = source.mLength;
				int end_pos2 = (total_len2 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len2);

				tag = source.decodeTagLength();
				if (tag != 0x6)
				    source.raiseTagMismatchException(tag);
				try {
				    temp1.type = new ObjectIdentifier(coder.decodeObjectIdentifier(source));
				} catch (Exception e) {
				    DecoderException ee = DecoderException.wrapException(e);
				    ee.appendFieldContext("type", "OBJECT IDENTIFIER");
				    throw ee;
				}
				tag = source.decodeTagLength();
				if (tag != 0x31)
				    source.raiseTagMismatchException(tag);
				try {
				    temp1.value = new asncie.pkix1explicit88.OtherAttribute.Value();
				    {
					int total_len3 = source.mLength;
					int end_pos3 = (total_len3 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len3);
					int idx3 = 0;

					temp1.value.elements = new java.util.ArrayList<AttributeValue>();

					try {
					    for (;;) {
						if (source.position() >= end_pos3) {
						    if (source.position() > end_pos3)
							throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
						    break;
						}
						tag = source.decodeTagLength();
						if (tag == 0) {
						    if (total_len3 < 0) {
							if (source.mLength != 0)
							    throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
							break;
						    }
						    if (source.mLength == 0)
							throw new DecoderException(ExceptionDescriptor._expect_tag, null);
						}
						AttributeValue temp3;
						if (tag != 0x13 && tag != 0x33)
						    source.raiseTagMismatchException(tag);
						temp3 = new AttributeValue(coder.decodeChars(source));
						temp1.value.add(temp3);
						++idx3;
					    }
					} catch (Exception e) {
					    DecoderException ee = DecoderException.wrapException(e);
					    ee.appendElementContext(null, "AttributeValue", idx3);
					    throw ee;
					}
				    }
				} catch (Exception e) {
				    DecoderException ee = DecoderException.wrapException(e);
				    ee.appendFieldContext("value", "SET OF");
				    throw ee;
				}
				if (source.position() != end_pos2) {
				    if (total_len2 >= 0)
					throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
				    tag = source.decodeTagLength();
				    if (tag != 0 || source.mLength != 0)
					throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
				}
			    }
			    ++idx1;
			}
		    } catch (Exception e) {
			DecoderException ee = DecoderException.wrapException(e);
			ee.appendElementContext(null, "OtherAttribute", idx1);
			throw ee;
		    }
		}
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendFieldContext("attributes", "NameAttributes");
		throw ee;
	    }
	    if (source.position() >= end_pos0)
		break;
	    tag = source.decodeTagLength();
	    if (tag == 0)
		break;
	    if (tag == 0x30) {
		try {
		    this.extensions = new Extensions();
		    {
			int total_len1 = source.mLength;
			int end_pos1 = (total_len1 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len1);
			int idx1 = 0;

			this.extensions.elements = new java.util.ArrayList<Extension>();

			try {
			    for (;;) {
				if (source.position() >= end_pos1) {
				    if (source.position() > end_pos1)
					throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
				    break;
				}
				tag = source.decodeTagLength();
				if (tag == 0) {
				    if (total_len1 < 0) {
					if (source.mLength != 0)
					    throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
					break;
				    }
				    if (source.mLength == 0)
					throw new DecoderException(ExceptionDescriptor._expect_tag, null);
				}
				Extension temp1 = new Extension();
				this.extensions.add(temp1);
				if (tag != 0x30)
				    source.raiseTagMismatchException(tag);
				{
				    int total_len2 = source.mLength;
				    int end_pos2 = (total_len2 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len2);

				    tag = source.decodeTagLength();
				    if (tag != 0x6)
					source.raiseTagMismatchException(tag);
				    try {
					temp1.extnID = new ObjectIdentifier(coder.decodeObjectIdentifier(source));
				    } catch (Exception e) {
					DecoderException ee = DecoderException.wrapException(e);
					ee.appendFieldContext("extnID", "OBJECT IDENTIFIER");
					throw ee;
				    }
				    tag = source.decodeTagLength();
				    if (tag == 0x1) {
					try {
					    temp1.critical = new BOOLEAN(source.decodeBoolean());
					} catch (Exception e) {
					    DecoderException ee = DecoderException.wrapException(e);
					    ee.appendFieldContext("critical", "BOOLEAN");
					    throw ee;
					}
					tag = source.decodeTagLength();
				    }
				    if (tag != 0x4 && tag != 0x24)
					source.raiseTagMismatchException(tag);
				    try {
					temp1.extnValue = new OctetString(coder.decodeOctetString(source));
				    } catch (Exception e) {
					DecoderException ee = DecoderException.wrapException(e);
					ee.appendFieldContext("extnValue", "OCTET STRING");
					throw ee;
				    }
				    if (source.position() != end_pos2) {
					if (total_len2 >= 0)
					    throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
					tag = source.decodeTagLength();
					if (tag != 0 || source.mLength != 0)
					    throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
				    }
				}
				++idx1;
			    }
			} catch (Exception e) {
			    DecoderException ee = DecoderException.wrapException(e);
			    ee.appendElementContext(null, "Extension", idx1);
			    throw ee;
			}
		    }
		} catch (Exception e) {
		    DecoderException ee = DecoderException.wrapException(e);
		    ee.appendFieldContext("extensions", "Extensions");
		    throw ee;
		}
		if (source.position() >= end_pos0)
		    break;
		tag = source.decodeTagLength();
		if (tag == 0)
		    break;
	    }
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
	    writer.print("version ");
	    printer.print(this.version, writer, this.version.cConstantNameList);
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	try {
	    writer.print(',');
	    printer.newLine(writer);
	    writer.print("holder ");
	    boolean comma1;
	    comma1 = false;
	    writer.print('{');
	    printer.indent();
	    if (this.holder.baseCertificateID != null) {
		try {
		    comma1 = true;
		    printer.newLine(writer);
		    writer.print("baseCertificateID ");
		    boolean comma2;
		    comma2 = false;
		    writer.print('{');
		    printer.indent();
		    comma2 = true;
		    try {
			printer.newLine(writer);
			writer.print("issuer ");
			this.holder.baseCertificateID.issuer.printValue(printer, writer);
		    } catch (Exception e) {
			printer.reportError(e, null, writer);
		    }
		    if (this.holder.baseCertificateID.serial != null) {
			try {
			    writer.print(',');
			    printer.newLine(writer);
			    writer.print("serial ");
			    writer.print(this.holder.baseCertificateID.serial.longValue());
			} catch (Exception e) {
			    printer.reportError(e, null, writer);
			}
		    }
		    printer.undent();
		    printer.newLine(writer);
		    writer.print('}');
		} catch (Exception e) {
		    printer.reportError(e, null, writer);
		}
	    }
	    if (this.holder.entityName != null) {
		try {
		    if (comma1)
			writer.print(',');
		    comma1 = true;
		    printer.newLine(writer);
		    writer.print("entityName ");
		    this.holder.entityName.printValue(printer, writer);
		} catch (Exception e) {
		    printer.reportError(e, null, writer);
		}
	    }
	    if (this.holder.objectDigestInfo != null) {
		try {
		    if (comma1)
			writer.print(',');
		    comma1 = true;
		    printer.newLine(writer);
		    writer.print("objectDigestInfo ");
		    boolean comma2;
		    comma2 = false;
		    writer.print('{');
		    printer.indent();
		    comma2 = true;
		    try {
			printer.newLine(writer);
			writer.print("digestedObjectType ");
			printer.print(this.holder.objectDigestInfo.digestedObjectType, writer, this.holder.objectDigestInfo.digestedObjectType.cConstantNameList);
		    } catch (Exception e) {
			printer.reportError(e, null, writer);
		    }
		    if (this.holder.objectDigestInfo.otherObjectTypeID != null) {
			try {
			    writer.print(',');
			    printer.newLine(writer);
			    writer.print("otherObjectTypeID ");
			    printer.print(this.holder.objectDigestInfo.otherObjectTypeID, writer);
			} catch (Exception e) {
			    printer.reportError(e, null, writer);
			}
		    }
		    try {
			writer.print(',');
			printer.newLine(writer);
			writer.print("digestAlgorithm ");
			this.holder.objectDigestInfo.digestAlgorithm.printValue(printer, writer);
		    } catch (Exception e) {
			printer.reportError(e, null, writer);
		    }
		    try {
			writer.print(',');
			printer.newLine(writer);
			writer.print("objectDigest ");
			printer.print(this.holder.objectDigestInfo.objectDigest, writer);
		    } catch (Exception e) {
			printer.reportError(e, null, writer);
		    }
		    printer.undent();
		    printer.newLine(writer);
		    writer.print('}');
		} catch (Exception e) {
		    printer.reportError(e, null, writer);
		}
	    }
	    printer.undent();
	    if (comma1)
		printer.newLine(writer);
	    writer.print('}');
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	try {
	    writer.print(',');
	    printer.newLine(writer);
	    writer.print("issuer ");
	    {
		switch (this.issuer.getChosenFlag()) {
		case AttCertIssuer.v2Form_chosen:
		    try {
			writer.print("v2Form : ");
			boolean comma2;
			comma2 = false;
			writer.print('{');
			printer.indent();
			if (((V2Forms)this.issuer.getChosenValue()).issuerName != null) {
			    try {
				comma2 = true;
				printer.newLine(writer);
				writer.print("issuerName ");
				((V2Forms)this.issuer.getChosenValue()).issuerName.printValue(printer, writer);
			    } catch (Exception e) {
				printer.reportError(e, null, writer);
			    }
			}
			printer.undent();
			if (comma2)
			    printer.newLine(writer);
			writer.print('}');
		    } catch (Exception e) {
			printer.reportError(e, null, writer);
		    }
		    break;

		default:
		    writer.print("-- unknown selection --");
		}
	    }
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	try {
	    writer.print(',');
	    printer.newLine(writer);
	    writer.print("signature ");
	    this.signature.printValue(printer, writer);
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	try {
	    writer.print(',');
	    printer.newLine(writer);
	    writer.print("serialNumber ");
	    writer.print(this.serialNumber.longValue());
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	try {
	    writer.print(',');
	    printer.newLine(writer);
	    writer.print("attrCertValidityPeriod ");
	    boolean comma1;
	    comma1 = false;
	    writer.print('{');
	    printer.indent();
	    comma1 = true;
	    try {
		printer.newLine(writer);
		writer.print("notBeforeTime ");
		printer.print(this.attrCertValidityPeriod.notBeforeTime, writer);
	    } catch (Exception e) {
		printer.reportError(e, null, writer);
	    }
	    try {
		writer.print(',');
		printer.newLine(writer);
		writer.print("notAfterTime ");
		printer.print(this.attrCertValidityPeriod.notAfterTime, writer);
	    } catch (Exception e) {
		printer.reportError(e, null, writer);
	    }
	    printer.undent();
	    printer.newLine(writer);
	    writer.print('}');
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	try {
	    writer.print(',');
	    printer.newLine(writer);
	    writer.print("attributes ");
	    {
		java.util.ArrayList<OtherAttribute> temp1 = this.attributes.elements;
		int len1 = temp1 != null ? temp1.size() : 0;
		int idx1 = 0;

		try {
		    writer.print('{');
		    printer.indent();
		    for (idx1 = 0; idx1 < len1; idx1++){
			if (idx1 > 0)
			    writer.print(',');
			printer.newLine(writer);
			boolean comma2;
			comma2 = false;
			writer.print('{');
			printer.indent();
			comma2 = true;
			try {
			    printer.newLine(writer);
			    writer.print("type ");
			    printer.print(temp1.get(idx1).type, writer);
			} catch (Exception e) {
			    printer.reportError(e, null, writer);
			}
			try {
			    writer.print(',');
			    printer.newLine(writer);
			    writer.print("value ");
			    {
				java.util.ArrayList<AttributeValue> temp3 = temp1.get(idx1).value.elements;
				int len3 = temp3 != null ? temp3.size() : 0;
				int idx3 = 0;

				try {
				    writer.print('{');
				    printer.indent();
				    for (idx3 = 0; idx3 < len3; idx3++){
					if (idx3 > 0)
					    writer.print(',');
					printer.newLine(writer);
					printer.print(temp3.get(idx3), writer);
				    }
				    printer.undent();
				    if (len3 > 0)
					printer.newLine(writer);
				    writer.print('}');
				} catch (Exception e) {
				    printer.reportError(e, null, writer);
				}
			    }
			} catch (Exception e) {
			    printer.reportError(e, null, writer);
			}
			printer.undent();
			printer.newLine(writer);
			writer.print('}');
		    }
		    printer.undent();
		    if (len1 > 0)
			printer.newLine(writer);
		    writer.print('}');
		} catch (Exception e) {
		    printer.reportError(e, null, writer);
		}
	    }
	} catch (Exception e) {
	    printer.reportError(e, null, writer);
	}
	if (this.extensions != null) {
	    try {
		writer.print(',');
		printer.newLine(writer);
		writer.print("extensions ");
		{
		    java.util.ArrayList<Extension> temp1 = this.extensions.elements;
		    int len1 = temp1 != null ? temp1.size() : 0;
		    int idx1 = 0;

		    try {
			writer.print('{');
			printer.indent();
			for (idx1 = 0; idx1 < len1; idx1++){
			    if (idx1 > 0)
				writer.print(',');
			    printer.newLine(writer);
			    boolean comma2;
			    comma2 = false;
			    writer.print('{');
			    printer.indent();
			    comma2 = true;
			    try {
				printer.newLine(writer);
				writer.print("extnID ");
				printer.print(temp1.get(idx1).extnID, writer);
			    } catch (Exception e) {
				printer.reportError(e, null, writer);
			    }
			    if (temp1.get(idx1).critical != null || printer.isPrintingOfImpliedValuesEnabled()) {
				try {
				    writer.print(',');
				    printer.newLine(writer);
				    writer.print("critical ");
				    if (temp1.get(idx1).critical == null)
				    {
					printer.print(Extension.critical__default, writer);
				    } else
				    {
					printer.print(temp1.get(idx1).critical, writer);
				    }
				} catch (Exception e) {
				    printer.reportError(e, null, writer);
				}
			    }
			    try {
				writer.print(',');
				printer.newLine(writer);
				writer.print("extnValue ");
				printer.print(temp1.get(idx1).extnValue, writer);
			    } catch (Exception e) {
				printer.reportError(e, null, writer);
			    }
			    printer.undent();
			    printer.newLine(writer);
			    writer.print('}');
			}
			printer.undent();
			if (len1 > 0)
			    printer.newLine(writer);
			writer.print('}');
		    } catch (Exception e) {
			printer.reportError(e, null, writer);
		    }
		}
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
	return equalTo((AttributeCertificateInfo)that);
    }
    
    public boolean equalTo(Sequence that)
    {
	return equalTo((AttributeCertificateInfo)that);
    }
    
    public boolean equalTo(AttributeCertificateInfo that) {
	if (!this.version.equalTo(that.version))
	    return false;
	if (!this.holder.equalTo(that.holder))
	    return false;
	if (!this.issuer.equalTo(that.issuer))
	    return false;
	if (!this.signature.equalTo(that.signature))
	    return false;
	if (!this.serialNumber.equalTo(that.serialNumber))
	    return false;
	if (!this.attrCertValidityPeriod.equalTo(that.attrCertValidityPeriod))
	    return false;
	if (!this.attributes.equalTo(that.attributes))
	    return false;
	if (this.extensions != null) {
	    if (that.extensions == null || !this.extensions.equalTo(that.extensions))
		return false;
	} else if (that.extensions != null)
	    return false;
	return true;
    }

    /**
     * Clone 'this' object.
     */
    public AttributeCertificateInfo clone() {
	AttributeCertificateInfo copy = (AttributeCertificateInfo)super.clone();
	copy.version = version.clone();
	copy.holder = holder.clone();
	copy.issuer = issuer.clone();
	copy.signature = signature.clone();
	copy.serialNumber = serialNumber.clone();
	copy.attrCertValidityPeriod = attrCertValidityPeriod.clone();
	copy.attributes = attributes.clone();
	if (extensions != null) {
	    copy.extensions = extensions.clone();
	}
	return copy;
    }

    /**
     * Returns a hash code for 'this' object.
     */
    public int hashCode() {
	int hash = 3;
	hash = 41 * hash + (this.version != null ? this.version.hashCode() : 0);
	hash = 41 * hash + (this.holder != null ? this.holder.hashCode() : 0);
	hash = 41 * hash + (this.issuer != null ? this.issuer.hashCode() : 0);
	hash = 41 * hash + (this.signature != null ? this.signature.hashCode() : 0);
	hash = 41 * hash + (this.serialNumber != null ? this.serialNumber.hashCode() : 0);
	hash = 41 * hash + (this.attrCertValidityPeriod != null ? this.attrCertValidityPeriod.hashCode() : 0);
	hash = 41 * hash + (this.attributes != null ? this.attributes.hashCode() : 0);
	hash = 41 * hash + (this.extensions != null ? this.extensions.hashCode() : 0);
	return hash;
    }
} // End class definition for AttributeCertificateInfo
