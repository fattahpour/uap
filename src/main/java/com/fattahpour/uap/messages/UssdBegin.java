package com.fattahpour.uap.messages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fattahpour.uap.utility.StringUtility;
import java.util.Arrays;

/**
 *
 * @author peyman
 */
public class UssdBegin extends MessageBase {

    public UssdBegin(byte[] message) {
        this.Message = message;
        this.dencode();
        this.CommandID = CommandIDs.UssdBegin;
    }

    @Override
    protected boolean dencode() {
        super.dencode();
        this.UssdVersion = UssdVersions.fromInteger(Arrays.copyOfRange(this.Message, 20, 21)[0]);
        this.UssdOpType = UssdOpTypes.fromInteger(Arrays.copyOfRange(this.Message, 21, 22)[0]);
        this.MsIsdn = StringUtility.GetCOctetStringFromBytes(Arrays.copyOfRange(this.Message, 22, 43));
        this.ServiceCode =  Integer.parseInt( StringUtility.GetCOctetStringFromBytes(Arrays.copyOfRange(this.Message, 43, 47)));
        this.CodeScheme = CodeSchemes.fromInteger(Arrays.copyOfRange(this.Message, 47, 48)[0]);
        this.UssdString = StringUtility.GetCOctetStringFromBytes(Arrays.copyOfRange(this.Message, 48, this.CommandLength));
        return true;
    }

    public UssdVersions getUssdVersion() {
        return UssdVersion;
    }

    public UssdOpTypes getUssdOpType() {
        return UssdOpType;
    }

    public String getMsIsdn() {
        return MsIsdn;
    }

    public int getServiceCode() {
        return ServiceCode;
    }

    public CodeSchemes getCodeScheme() {
        return CodeScheme;
    }

    public String getUssdString() {
        return UssdString;
    }

}
