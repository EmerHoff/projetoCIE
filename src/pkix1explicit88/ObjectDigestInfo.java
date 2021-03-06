/**
 * This class file was automatically generated by jASN1 v1.11.0 (http://www.beanit.com)
 */

package pkix1explicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class ObjectDigestInfo implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	private BerEnum digestedObjectType = null;
	private BerObjectIdentifier otherObjectTypeID = null;
	private AlgorithmIdentifier digestAlgorithm = null;
	private BerBitString objectDigest = null;
	
	public ObjectDigestInfo() {
	}

	public ObjectDigestInfo(byte[] code) {
		this.code = code;
	}

	public void setDigestedObjectType(BerEnum digestedObjectType) {
		this.digestedObjectType = digestedObjectType;
	}

	public BerEnum getDigestedObjectType() {
		return digestedObjectType;
	}

	public void setOtherObjectTypeID(BerObjectIdentifier otherObjectTypeID) {
		this.otherObjectTypeID = otherObjectTypeID;
	}

	public BerObjectIdentifier getOtherObjectTypeID() {
		return otherObjectTypeID;
	}

	public void setDigestAlgorithm(AlgorithmIdentifier digestAlgorithm) {
		this.digestAlgorithm = digestAlgorithm;
	}

	public AlgorithmIdentifier getDigestAlgorithm() {
		return digestAlgorithm;
	}

	public void setObjectDigest(BerBitString objectDigest) {
		this.objectDigest = objectDigest;
	}

	public BerBitString getObjectDigest() {
		return objectDigest;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += objectDigest.encode(reverseOS, true);
		
		codeLength += digestAlgorithm.encode(reverseOS, true);
		
		if (otherObjectTypeID != null) {
			codeLength += otherObjectTypeID.encode(reverseOS, true);
		}
		
		codeLength += digestedObjectType.encode(reverseOS, true);
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(BerEnum.tag)) {
			digestedObjectType = new BerEnum();
			subCodeLength += digestedObjectType.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerObjectIdentifier.tag)) {
			otherObjectTypeID = new BerObjectIdentifier();
			subCodeLength += otherObjectTypeID.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(AlgorithmIdentifier.tag)) {
			digestAlgorithm = new AlgorithmIdentifier();
			subCodeLength += digestAlgorithm.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerBitString.tag)) {
			objectDigest = new BerBitString();
			subCodeLength += objectDigest.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (digestedObjectType != null) {
			sb.append("digestedObjectType: ").append(digestedObjectType);
		}
		else {
			sb.append("digestedObjectType: <empty-required-field>");
		}
		
		if (otherObjectTypeID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("otherObjectTypeID: ").append(otherObjectTypeID);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (digestAlgorithm != null) {
			sb.append("digestAlgorithm: ");
			digestAlgorithm.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("digestAlgorithm: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (objectDigest != null) {
			sb.append("objectDigest: ").append(objectDigest);
		}
		else {
			sb.append("objectDigest: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

