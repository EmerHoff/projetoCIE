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
 * Define the ASN1 Type GeneralNames from ASN1 Module PKIX1Explicit88.
 * @see Choice
 */

public class GeneralNames extends Choice {
    
    /**
     * The default constructor.
     */
    public GeneralNames()
    {
    }
    
    public static final  int  otherName_chosen = 1;
    public static final  int  directoryName_chosen = 2;
    
    /**
     * Return the tag of chosen component (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public int getTag() {
	switch (getChosenFlag()) {
	case 1:
	    return 0x80;
	case 2:
	    return 0x84;
	default:
	    return 0;
	}
    }

    // Methods for field "otherName"
    public static GeneralNames createGeneralNamesWithOtherName(OtherName otherName)
    {
	GeneralNames __object = new GeneralNames();

	__object.setOtherName(otherName);
	return __object;
    }
    
    public boolean hasOtherName()
    {
	return getChosenFlag() == otherName_chosen;
    }
    
    public OtherName getOtherName()
    {
	if (hasOtherName())
	    return (OtherName)mChosenValue;
	else
	    return null;
    }
    
    public void setOtherName(OtherName otherName)
    {
	setChosenValue(otherName);
	setChosenFlag(otherName_chosen);
    }
    
    
    // Methods for field "directoryName"
    public static GeneralNames createGeneralNamesWithDirectoryName(Name directoryName)
    {
	GeneralNames __object = new GeneralNames();

	__object.setDirectoryName(directoryName);
	return __object;
    }
    
    public boolean hasDirectoryName()
    {
	return getChosenFlag() == directoryName_chosen;
    }
    
    public Name getDirectoryName()
    {
	if (hasDirectoryName())
	    return (Name)mChosenValue;
	else
	    return null;
    }
    
    public void setDirectoryName(Name directoryName)
    {
	setChosenValue(directoryName);
	setChosenFlag(directoryName_chosen);
    }
    
    
    /**
     * Implements BER value encoder for the type (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public int encodeValue(DerCoder coder, EncoderOutput sink)
	    throws EncoderException
    {
	int len0 = 0;

	switch (this.mChosenFlag) {
	case otherName_chosen:
	    try {
		int len1 = 0;
		java.util.ArrayList<OtherNames> temp1 = ((OtherName)this.mChosenValue).elements;
		int idx1 = temp1 != null ? temp1.size() : 0;

		try {
		    while(idx1-- > 0) {
			int len2 = 0;
			OtherNames temp2 = temp1.get(idx1);

			try {
			    len2 += sink.encodeLengthTag(coder.encodeString1(temp2.values, sink), 0x13);
			} catch (Exception e) {
			    EncoderException ee = EncoderException.wrapException(e);
			    ee.appendFieldContext("values", "PrintableString");
			    throw ee;
			}
			try {
			    len2 += sink.encodeLengthTag(coder.encodeObjectIdentifier(temp2.type_id, sink), 0x6);
			} catch (Exception e) {
			    EncoderException ee = EncoderException.wrapException(e);
			    ee.appendFieldContext("type-id", "OBJECT IDENTIFIER");
			    throw ee;
			}
			len1 += sink.encodeLengthTag(len2, 0x30);
		    }
		} catch (Exception e) {
		    EncoderException ee = EncoderException.wrapException(e);
		    ee.appendElementContext(null, "OtherNames", idx1);
		    throw ee;
		}
		len0 = sink.encodeLengthTag2(len1, 0x30, 0xA0);
	    } catch (Exception e) {
		EncoderException ee = EncoderException.wrapException(e);
		ee.appendElementContext("otherName", "OtherName", 0);
		throw ee;
	    }
	    break;

	case directoryName_chosen:
	    try {
		int len1 = 0;
		java.util.ArrayList<RelativeDistinguishedName> temp1 = ((Name)this.mChosenValue).elements;
		int idx1 = temp1 != null ? temp1.size() : 0;

		try {
		    while(idx1-- > 0) {
			int len2 = 0;
			java.util.ArrayList<AttributeTypeAndValue> temp2 = temp1.get(idx1).elements;
			int idx2 = temp2 != null ? temp2.size() : 0;

			com.oss.coders.der.SetOfEncodings encodings_temp2 =
			    new com.oss.coders.der.SetOfEncodings((com.oss.coders.ber.OSSRevOutputStream)sink, idx2);
			try {
			    while(idx2-- > 0) {
				int len3 = 0;
				AttributeTypeAndValue temp3 = temp2.get(idx2);

				try {
				    len3 += encodings_temp2.encodeLengthTag(coder.encodeString1(temp3.value, encodings_temp2), 0x13);
				} catch (Exception e) {
				    EncoderException ee = EncoderException.wrapException(e);
				    ee.appendFieldContext("value", "PrintableString");
				    throw ee;
				}
				try {
				    len3 += encodings_temp2.encodeLengthTag(coder.encodeObjectIdentifier(temp3.type, encodings_temp2), 0x6);
				} catch (Exception e) {
				    EncoderException ee = EncoderException.wrapException(e);
				    ee.appendFieldContext("type", "OBJECT IDENTIFIER");
				    throw ee;
				}
				len2 += encodings_temp2.encodeLengthTag(len3, 0x30);
				encodings_temp2.markElement();
			    }
			    encodings_temp2.flush();
			} catch (Exception e) {
			    EncoderException ee = EncoderException.wrapException(e);
			    ee.appendElementContext(null, "AttributeTypeAndValue", idx2);
			    throw ee;
			} finally {
			    if (encodings_temp2 != null)
				encodings_temp2.reset();
			}
			len1 += sink.encodeLengthTag(len2, 0x31);
		    }
		} catch (Exception e) {
		    EncoderException ee = EncoderException.wrapException(e);
		    ee.appendElementContext(null, "RelativeDistinguishedName", idx1);
		    throw ee;
		}
		len0 = sink.encodeLengthTag2(len1, 0x30, 0xA4);
	    } catch (Exception e) {
		EncoderException ee = EncoderException.wrapException(e);
		ee.appendElementContext("directoryName", "Name", 0);
		throw ee;
	    }
	    break;

	default:
	    throw new EncoderException(ExceptionDescriptor._bad_choice, null);
	}

	return len0;
    }

    /**
     * Implements BER value decoder for the type (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public GeneralNames decodeValue(BerCoder coder, DecoderInput source, int tag)
	    throws DecoderException
    {
	switch (tag) {
	case 0xA0:
	    try {
		this.mChosenFlag = otherName_chosen;
		this.mChosenValue = new OtherName();
		{
		    int indef_tags1 = 0;

		    if (source.mLength < 0)
			++indef_tags1;
		    tag = source.decodeTagLength();
		    if (tag != 0x30)
			source.raiseTagMismatchException(tag);
		    {
			int total_len1 = source.mLength;
			int end_pos1 = (total_len1 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len1);
			int idx1 = 0;

			((OtherName)this.mChosenValue).elements = new java.util.ArrayList<OtherNames>();

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
				OtherNames temp1 = new OtherNames();
				((OtherName)this.mChosenValue).add(temp1);
				if (tag != 0x30)
				    source.raiseTagMismatchException(tag);
				{
				    int total_len2 = source.mLength;
				    int end_pos2 = (total_len2 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len2);

				    tag = source.decodeTagLength();
				    if (tag != 0x6)
					source.raiseTagMismatchException(tag);
				    try {
					temp1.type_id = new ObjectIdentifier(coder.decodeObjectIdentifier(source));
				    } catch (Exception e) {
					DecoderException ee = DecoderException.wrapException(e);
					ee.appendFieldContext("type-id", "OBJECT IDENTIFIER");
					throw ee;
				    }
				    tag = source.decodeTagLength();
				    if (tag != 0x13 && tag != 0x33)
					source.raiseTagMismatchException(tag);
				    try {
					temp1.values = new PrintableString(coder.decodeChars(source));
				    } catch (Exception e) {
					DecoderException ee = DecoderException.wrapException(e);
					ee.appendFieldContext("values", "PrintableString");
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
			    ee.appendElementContext(null, "OtherNames", idx1);
			    throw ee;
			}
		    }
		    if (indef_tags1 > 0)
			coder.consumeEOCs(source, indef_tags1);
		}
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendElementContext("otherName", "OtherName", 0);
		throw ee;
	    }
	    break;

	case 0xA4:
	    try {
		this.mChosenFlag = directoryName_chosen;
		this.mChosenValue = new Name();
		{
		    int indef_tags1 = 0;

		    if (source.mLength < 0)
			++indef_tags1;
		    tag = source.decodeTagLength();
		    if (tag != 0x30)
			source.raiseTagMismatchException(tag);
		    {
			int total_len1 = source.mLength;
			int end_pos1 = (total_len1 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len1);
			int idx1 = 0;

			((Name)this.mChosenValue).elements = new java.util.ArrayList<RelativeDistinguishedName>();

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
				RelativeDistinguishedName temp1 = new RelativeDistinguishedName();
				((Name)this.mChosenValue).add(temp1);
				if (tag != 0x31)
				    source.raiseTagMismatchException(tag);
				{
				    int total_len2 = source.mLength;
				    int end_pos2 = (total_len2 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len2);
				    int idx2 = 0;

				    temp1.elements = new java.util.ArrayList<AttributeTypeAndValue>();

				    try {
					for (;;) {
					    if (source.position() >= end_pos2) {
						if (source.position() > end_pos2)
						    throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
						break;
					    }
					    tag = source.decodeTagLength();
					    if (tag == 0) {
						if (total_len2 < 0) {
						    if (source.mLength != 0)
							throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
						    break;
						}
						if (source.mLength == 0)
						    throw new DecoderException(ExceptionDescriptor._expect_tag, null);
					    }
					    AttributeTypeAndValue temp2 = new AttributeTypeAndValue();
					    temp1.add(temp2);
					    if (tag != 0x30)
						source.raiseTagMismatchException(tag);
					    {
						int total_len3 = source.mLength;
						int end_pos3 = (total_len3 < 0) ? java.lang.Integer.MAX_VALUE : (source.position() + total_len3);

						tag = source.decodeTagLength();
						if (tag != 0x6)
						    source.raiseTagMismatchException(tag);
						try {
						    temp2.type = new ObjectIdentifier(coder.decodeObjectIdentifier(source));
						} catch (Exception e) {
						    DecoderException ee = DecoderException.wrapException(e);
						    ee.appendFieldContext("type", "OBJECT IDENTIFIER");
						    throw ee;
						}
						tag = source.decodeTagLength();
						if (tag != 0x13 && tag != 0x33)
						    source.raiseTagMismatchException(tag);
						try {
						    temp2.value = new PrintableString(coder.decodeChars(source));
						} catch (Exception e) {
						    DecoderException ee = DecoderException.wrapException(e);
						    ee.appendFieldContext("value", "PrintableString");
						    throw ee;
						}
						if (source.position() != end_pos3) {
						    if (total_len3 >= 0)
							throw new DecoderException(ExceptionDescriptor._inconsis_len, null);
						    tag = source.decodeTagLength();
						    if (tag != 0 || source.mLength != 0)
							throw new DecoderException(ExceptionDescriptor._non_std_eoc, null);
						}
					    }
					    ++idx2;
					}
				    } catch (Exception e) {
					DecoderException ee = DecoderException.wrapException(e);
					ee.appendElementContext(null, "AttributeTypeAndValue", idx2);
					throw ee;
				    }
				}
				++idx1;
			    }
			} catch (Exception e) {
			    DecoderException ee = DecoderException.wrapException(e);
			    ee.appendElementContext(null, "RelativeDistinguishedName", idx1);
			    throw ee;
			}
		    }
		    if (indef_tags1 > 0)
			coder.consumeEOCs(source, indef_tags1);
		}
	    } catch (Exception e) {
		DecoderException ee = DecoderException.wrapException(e);
		ee.appendElementContext("directoryName", "Name", 0);
		throw ee;
	    }
	    break;

	default:
	    source.raiseUnknownFieldException(tag);
	}

	return this;
    }

    /**
     * Implements value printer for the type (reserved for internal use).
     * This method is reserved for internal use and must not be invoked from the application code.
     */
    public void printValue(DataPrinter printer, java.io.PrintWriter writer)
	    throws Exception
    {
	switch (this.mChosenFlag) {
	case otherName_chosen:
	    try {
		writer.print("otherName : ");
		{
		    java.util.ArrayList<OtherNames> temp1 = ((OtherName)this.mChosenValue).elements;
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
				writer.print("type-id ");
				printer.print(temp1.get(idx1).type_id, writer);
			    } catch (Exception e) {
				printer.reportError(e, null, writer);
			    }
			    try {
				writer.print(',');
				printer.newLine(writer);
				writer.print("values ");
				printer.print(temp1.get(idx1).values, writer);
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
	    break;

	case directoryName_chosen:
	    try {
		writer.print("directoryName : ");
		{
		    java.util.ArrayList<RelativeDistinguishedName> temp1 = ((Name)this.mChosenValue).elements;
		    int len1 = temp1 != null ? temp1.size() : 0;
		    int idx1 = 0;

		    try {
			writer.print('{');
			printer.indent();
			for (idx1 = 0; idx1 < len1; idx1++){
			    if (idx1 > 0)
				writer.print(',');
			    printer.newLine(writer);
			    {
				java.util.ArrayList<AttributeTypeAndValue> temp2 = temp1.get(idx1).elements;
				int len2 = temp2 != null ? temp2.size() : 0;
				int idx2 = 0;

				try {
				    writer.print('{');
				    printer.indent();
				    for (idx2 = 0; idx2 < len2; idx2++){
					if (idx2 > 0)
					    writer.print(',');
					printer.newLine(writer);
					boolean comma3;
					comma3 = false;
					writer.print('{');
					printer.indent();
					comma3 = true;
					try {
					    printer.newLine(writer);
					    writer.print("type ");
					    printer.print(temp2.get(idx2).type, writer);
					} catch (Exception e) {
					    printer.reportError(e, null, writer);
					}
					try {
					    writer.print(',');
					    printer.newLine(writer);
					    writer.print("value ");
					    printer.print(temp2.get(idx2).value, writer);
					} catch (Exception e) {
					    printer.reportError(e, null, writer);
					}
					printer.undent();
					printer.newLine(writer);
					writer.print('}');
				    }
				    printer.undent();
				    if (len2 > 0)
					printer.newLine(writer);
				    writer.print('}');
				} catch (Exception e) {
				    printer.reportError(e, null, writer);
				}
			    }
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
	    break;

	default:
	    writer.print("-- unknown selection --");
	}
    }

    /**
     * Clone 'this' object.
     */
    public GeneralNames clone() {
	return (GeneralNames)super.clone();
    }

} // End class definition for GeneralNames
