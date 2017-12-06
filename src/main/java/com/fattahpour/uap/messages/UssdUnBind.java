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
public class UssdUnBind extends MessageBase {

    public UssdUnBind() {
        this.CommandID = CommandIDs.UssdUnBind;
    }

    @Override
    protected byte[] encode() {
        //super.encode(); //To change body of generated methods, choose Tools | Templates.
        return this.generateMessage();
    }
    
    

}
