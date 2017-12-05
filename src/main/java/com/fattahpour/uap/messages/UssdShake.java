/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fattahpour.uap.messages;


/**
 *
 * @author peyman
 */
public class UssdShake extends MessageBase {

    public UssdShake() {
        this.CommandID = CommandIDs.UssdShake;
    }

    @Override
    public byte[] encode() {
        return this.generateMessage();
    }



}
