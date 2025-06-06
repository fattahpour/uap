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
public class UssdChargeIndResp extends MessageBase {

    public UssdChargeIndResp() {
        this.CommandID = CommandIDs.UssdChargeIndResp;
    }
    
}
