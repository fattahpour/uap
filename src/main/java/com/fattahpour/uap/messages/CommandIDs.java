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
public enum CommandIDs {
    UssdBind(0x00000065), UssdUnBind(0x00000066), UssdBindResp(0x00000067), UssdUnBindResp(0x00000068),
    UssdBegin(0x0000006F), UssdContinue(0x00000070), UssdEnd(0x00000071), UssdAbort(0x00000072),
    UssdSwitch(0x00000074), UssdChargeInd(0x00000075), UssdChargeIndResp(0x00000076), UssdShake(0x00000083),
    UssdShakeResp(0x00000084), NONE(0);

    private final int value;

    private CommandIDs(int value) {
        this.value = value;
    }

    public int toInt() {
        return this.value;
    }

    public static CommandIDs fromInteger(int x) {
        switch (x) {
            case 0x00000065:
                return CommandIDs.UssdBind;
            case 0x00000066:
                return CommandIDs.UssdUnBind;
            case 0x00000067:
                return CommandIDs.UssdBindResp;
            case 0x00000068:
                return CommandIDs.UssdUnBindResp;
            case 0x0000006F:
                return CommandIDs.UssdBegin;
            case 0x00000070:
                return CommandIDs.UssdContinue;
            case 0x00000071:
                return CommandIDs.UssdEnd;
            case 0x00000072:
                return CommandIDs.UssdAbort;
            case 0x00000074:
                return CommandIDs.UssdSwitch;
            case 0x00000075:
                return CommandIDs.UssdChargeInd;
            case 0x00000076:
                return CommandIDs.UssdChargeIndResp;
            case 0x00000083:
                return CommandIDs.UssdShake;
            case 0x00000084:
                return CommandIDs.UssdShakeResp;
            default:
                return CommandIDs.NONE;
        }
    }
}
