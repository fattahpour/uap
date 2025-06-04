package com.fattahpour.uap.messages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.fattahpour.uap.utility.StringUtility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Ghasem Fattahpour
 */
public class UssdContinue extends MessageBase {

    public UssdContinue() {
        this.CommandID = CommandIDs.UssdContinue;
        this.UssdOpType = UssdOpTypes.Request;
    }

    public UssdContinue(byte[] message) {
        this.Message = message;
        this.dencode();
        // After decoding we should preserve the original command type.
        // Setting this to UssdBegin prevented proper message identification.
        this.CommandID = CommandIDs.UssdContinue;
    }

    @Override
    protected boolean dencode() {
        super.dencode(); //To change body of generated methods, choose Tools | Templates.

        this.UssdVersion = UssdVersions.fromInteger(Arrays.copyOfRange(this.Message, 20, 21)[0]);
        this.UssdOpType = UssdOpTypes.fromInteger(Arrays.copyOfRange(this.Message, 21, 22)[0]);
        this.MsIsdn = StringUtility.GetCOctetStringFromBytes(Arrays.copyOfRange(this.Message, 22, 43));
        // Parse the service code from the incoming bytes instead of using a
        // hard coded value.
        this.ServiceCode = Integer.parseInt(
                StringUtility.GetCOctetStringFromBytes(
                        Arrays.copyOfRange(this.Message, 43, 47)));
        this.CodeScheme = CodeSchemes.fromInteger(Arrays.copyOfRange(this.Message, 47, 48)[0]);
        this.UssdString = StringUtility.GetCOctetStringFromBytes(Arrays.copyOfRange(this.Message, 48, this.CommandLength));

        return true;

    }

    public UssdVersions getUssdVersion() {
        return UssdVersion;
    }

    public void setUssdVersion(UssdVersions UssdVersion) {
        this.UssdVersion = UssdVersion;
    }

    public UssdOpTypes getUssdOpType() {
        return UssdOpType;
    }

    public void setUssdOpType(UssdOpTypes UssdOpType) {
        this.UssdOpType = UssdOpType;
    }

    public String getMsIsdn() {
        return MsIsdn;
    }

    public void setMsIsdn(String MsIsdn) {
        this.MsIsdn = MsIsdn;
    }

    public int getServiceCode() {
        return ServiceCode;
    }

    public void setServiceCode(int ServiceCode) {
        this.ServiceCode = ServiceCode;
    }

    public CodeSchemes getCodeScheme() {
        return CodeScheme;
    }

    public void setCodeScheme(CodeSchemes CodeScheme) {
        this.CodeScheme = CodeScheme;
    }

    public String getUssdString() {
        return UssdString;
    }

    public void setUssdString(String UssdString) {
        this.UssdString = UssdString;
    }

    @Override
    public byte[] encode() {

        byte[] byteArray = null;
        try {
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

            arrayOutputStream.write((byte) this.UssdVersion.getValue());
            arrayOutputStream.write((byte) this.UssdOpType.getValue());
            arrayOutputStream.write(StringUtility.GetBytesFromCOctetString(this.MsIsdn, 21));
            arrayOutputStream.write(StringUtility.GetBytesFromCOctetString(String.valueOf(this.ServiceCode), 4));
            arrayOutputStream.write((byte) this.CodeScheme.toInt());
            arrayOutputStream.write(this.UssdString.getBytes("UTF-16"));
            return this.generateMessage(arrayOutputStream.toByteArray());

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return byteArray;
    }

}
