/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fattahpour.uap.messages;

/**
 *
 * @author Ghasem Fattahpour
 */
public class UssdShakeResp extends MessageBase {

    public UssdShakeResp(byte[] message) {
        this.Message = message;
        this.decode();
        this.CommandID = CommandIDs.UssdShakeResp;
    }

    @Override
    protected boolean decode() {
        super.decode();
        return true;
    }

    
}
