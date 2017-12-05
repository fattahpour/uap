package com.fattahpour.uap.messages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fattahpour.uap.utility.StringUtility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author peyman
 */
public class UssdEnd extends MessageBase {

    public UssdEnd() {
        this.CommandID = CommandIDs.UssdEnd;
        this.UssdOpType = UssdOpTypes.Response;
        //ussdContinue.setUssdOpType(UssdOpTypes.Response);
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
