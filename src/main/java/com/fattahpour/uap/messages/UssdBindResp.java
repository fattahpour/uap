package com.fattahpour.uap.messages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fattahpour.uap.utility.StringUtility;

/**
 *
 * @author Ghasem Fattahpour
 */
public class UssdBindResp extends MessageBase {

    public UssdBindResp(byte[] message) {
        this.Message = message;
        this.decode();
        // The response to a bind operation should carry the UssdBindResp ID.
        // Previously this was incorrectly set to UssdUnBindResp.
        this.CommandID = CommandIDs.UssdBindResp;
    }

    @Override
    protected boolean decode() {
        super.decode(); //To change body of generated methods, choose Tools | Templates.
        this.AccountName = StringUtility.GetCOctetStringFromBytes(this.Message, 20, 11);
        return true;
        
    }

    public String getAccountName() {
        return AccountName;
    }
    
    

}
