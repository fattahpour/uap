/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fattahpour.uap.messages;

import org.junit.Test;
import java.util.Arrays;
import com.fattahpour.uap.utility.IntUtility;
import static org.junit.Assert.*;

/**
 *
 * @author Ghasem Fattahpour
 */
public class TestMessages {
    
    
    @Test
    public void validateCommandIds() {
        UssdBindResp bindResp = new UssdBindResp(new byte[20]);
        assertEquals(CommandIDs.UssdBindResp, bindResp.getCommandID());

        UssdChargeIndResp chargeResp = new UssdChargeIndResp();
        assertEquals(CommandIDs.UssdChargeIndResp, chargeResp.getCommandID());
    }

    @Test
    public void encodeBindMessage() {
        UssdBind bind = new UssdBind();
        byte[] encoded = bind.encode();

        assertNotNull("Encoded bind message should not be null", encoded);
        int length = IntUtility.toInt(Arrays.copyOfRange(encoded, 0, 4));
        assertEquals("Message length field", encoded.length, length);

        int command = IntUtility.toInt(Arrays.copyOfRange(encoded, 4, 8));
        assertEquals(CommandIDs.UssdBind.toInt(), command);

        // Decode header back using a simple MessageBase subclass
        DummyMessage decoded = new DummyMessage(encoded);
        assertTrue(decoded.decode());
        assertEquals(CommandIDs.UssdBind, decoded.getCommandID());
    }

    private static class DummyMessage extends MessageBase {
        DummyMessage(byte[] message) { this.Message = message; }
        public boolean decode() { return super.decode(); }
    }
}
