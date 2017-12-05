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
public enum UssdOpTypes {
    Request(0x01), Notify(0x02), Response(0x03), Release(0x04), NONE(0);
    private final int value;

    private UssdOpTypes(int value) {
        this.value = value;
    }

    public static UssdOpTypes fromInteger(int x) {
        switch (x) {
            case 0x01:
                return UssdOpTypes.Request;
            case 0x02:
                return UssdOpTypes.Notify;
            case 0x03:
                return UssdOpTypes.Response;
            case 0x04:
                return UssdOpTypes.Release;
            default:
                return UssdOpTypes.NONE;

        }
    }

    public int getValue() {
        return value;
    }

}
