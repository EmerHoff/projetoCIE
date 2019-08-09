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


public class GeneralNames implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	private OtherName otherName = null;
	private Name directoryName = null;
	
	public GeneralNames() {
	}

	public GeneralNames(byte[] code) {
		this.code = code;
	}

	public void setOtherName(OtherName otherName) {
		this.otherName = otherName;
	}

	public OtherName getOtherName() {
		return otherName;
	}

	public void setDirectoryName(Name directoryName) {
		this.directoryName = directoryName;
	}

	public Name getDirectoryName() {
		return directoryName;
	}

	public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		int sublength;

		if (directoryName != null) {
			sublength = directoryName.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
			reverseOS.write(0xA4);
			codeLength += 1;
			return codeLength;
		}
		
		if (otherName != null) {
			sublength = otherName.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			reverseOS.write(0xA0);
			codeLength += 1;
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int codeLength = 0;
		BerTag passedTag = berTag;

		if (berTag == null) {
			berTag = new BerTag();
			codeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			codeLength += BerLength.skip(is);
			otherName = new OtherName();
			codeLength += otherName.decode(is, true);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
			codeLength += BerLength.skip(is);
			directoryName = new Name();
			codeLength += directoryName.decode(is, true);
			return codeLength;
		}

		if (passedTag != null) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (otherName != null) {
			sb.append("otherName: ");
			otherName.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (directoryName != null) {
			sb.append("directoryName: ");
			directoryName.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}

