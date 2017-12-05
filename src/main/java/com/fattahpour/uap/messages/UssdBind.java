package com.fattahpour.uap.messages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fattahpour.uap.utility.IntUtility;
import com.fattahpour.uap.utility.StringUtility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author peyman
 */
public class UssdBind extends MessageBase {

    public UssdBind() {
        this.CommandID = CommandIDs.UssdBind;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public byte[] encode() {
        byte[] byteArray = null;
        try {
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

            arrayOutputStream.write(StringUtility.GetBytesFromCOctetString(this.AccountName, 11));
            arrayOutputStream.write(StringUtility.GetBytesFromCOctetString(this.Password, 9));
            arrayOutputStream.write(StringUtility.GetBytesFromCOctetString(this.SystemType, 13));
            arrayOutputStream.write(IntUtility.toByte(this.InterfaceVersion));
            
            return this.generateMessage( arrayOutputStream.toByteArray());
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            System.out.println(ex);
            //Logger.getLogger(UssdBind.class.getName()).log(Level.SEVERE, null, ex);
        }
        return byteArray;
    }



}
