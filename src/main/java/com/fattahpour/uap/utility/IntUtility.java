/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fattahpour.uap.utility;

import com.google.common.primitives.Ints;

/**
 *
 * @author peyman
 */
public class IntUtility {

    public static byte[] toByte(int value) {
        //byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
        //return bytes;
        return new byte[]{
            (byte) value,
            (byte) (value >>> 24),
            (byte) (value >>> 16),
            (byte) (value >>> 8)
        };
    }

    public static int toInt(byte[] value) {
        //byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
        //return bytes;
        return Ints.fromByteArray(new byte[]{
            value[1], value[2], value[3], value[0],});
    }
    public static int toRealInt(byte[] value) {
        //byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
        //return bytes;
        return Ints.fromByteArray(new byte[]{
            value[0],value[1], value[2], value[3]});
    }

}
