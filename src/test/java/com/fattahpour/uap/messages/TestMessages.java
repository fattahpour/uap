/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fattahpour.uap.messages;

import org.junit.Test;
import java.util.Arrays;
import com.fattahpour.uap.utility.IntUtility;

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

    @Test
    public void encodeBindMessage() {
        UssdBind bind = new UssdBind();
        byte[] encoded = bind.encode();

        assert(encoded != null);
        int length = IntUtility.toInt(Arrays.copyOfRange(encoded, 0, 4));
        assert(length == encoded.length);

        int command = IntUtility.toInt(Arrays.copyOfRange(encoded, 4, 8));
        assert(command == CommandIDs.UssdBind.toInt());
    }
}
