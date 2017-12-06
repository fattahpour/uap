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
public enum CodeSchemes {
    sevenDigit(0x0F), sixteenDigit(0x48), eightDigit(0x44), NONE(0);

    private final int value;

    private CodeSchemes(int value) {
        this.value = value;
    }

    public int toInt() {
        return this.value;
    }

    public static CodeSchemes fromInteger(int x) {
        switch (x) {
            case 0x0F:
                return CodeSchemes.sevenDigit;
            case 0x48:
                return CodeSchemes.sixteenDigit;
            case 0x44:
                return CodeSchemes.eightDigit;
            default:
                return CodeSchemes.NONE;
        }

    }

}
