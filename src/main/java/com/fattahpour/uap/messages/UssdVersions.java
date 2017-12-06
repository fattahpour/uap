package com.fattahpour.uap.messages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ghasem Fattahpour
 */
public enum UssdVersions {
    PHASEI(0x10), PHASEII(0x20), PHASEIII(0x25), NONE(0);

    private final int value;

    private UssdVersions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UssdVersions fromInteger(int x) {
        switch (x) {
            case 0x10:
                return UssdVersions.PHASEI;
            case 0x20:
                return UssdVersions.PHASEII;
            case 0x25:
                return UssdVersions.PHASEIII;
            default:
                return UssdVersions.NONE;

        }
    }

}
