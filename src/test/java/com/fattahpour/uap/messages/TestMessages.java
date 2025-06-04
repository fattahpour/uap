/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fattahpour.uap.messages;

import org.junit.Test;

/**
 *
 * @author Ghasem Fattahpour
 */
public class TestMessages {
    
    
    @Test
    public void validateCommandIds() {
        UssdBindResp bindResp = new UssdBindResp(new byte[20]);
        assert(bindResp.getCommandID() == CommandIDs.UssdBindResp);

        UssdChargeIndResp chargeResp = new UssdChargeIndResp();
        assert(chargeResp.getCommandID() == CommandIDs.UssdChargeIndResp);
    }
}
