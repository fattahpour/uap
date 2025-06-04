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
        // Charge indication responses should use the UssdChargeIndResp ID.
        // It was previously set to UssdBindResp, which was incorrect.
        this.CommandID = CommandIDs.UssdChargeIndResp;
    }
    
}
