/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fattahpour.uap.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peyman
 */
public class StringUtility {

    public static byte[] GetBytesFromCOctetString(String message, int length) {
        Charset encoding = StandardCharsets.US_ASCII;
        return GetBytesFromCOctetString(message, length, encoding);
    }

    public static byte[] GetBytesFromCOctetString(String message, int length, Charset encoding) {
        if (message != null && message.length() >= length) {

            //throw new ArgumentOutOfRangeException("message", "长度必须小于" + length);
        }
        byte[] buff = new byte[length];
        if (message == null) {
            return buff;
        }

        byte[] msgbuff = message.getBytes(encoding);
        for (int i = 0; i < msgbuff.length; i++) {
            buff[i] = msgbuff[i];
        }
        return buff;
        //List<byte> buff = new List<byte>();
        //byte[] msgbuff = Encoding.ASCII.GetBytes(message);
        //buff.AddRange(msgbuff);
        //buff.Add((byte)0);
        //for (int i = message.Length; i < length; i++)
        //{
        //    buff.Add((byte)0);
        //}
    }

    public static String GetCOctetStringFromBytes(byte[] buff) {
        int startIndex = 0;
        int length = buff.length;
        return GetCOctetStringFromBytes(buff, startIndex, length);
    }

    public static String GetCOctetStringFromBytes(byte[] buff, int startIndex, int length) {
        Charset encoding = StandardCharsets.US_ASCII;
        return GetCOctetStringFromBytes(buff, startIndex, length, encoding);
    }

    public static String GetCOctetStringFromBytes(byte[] buff, int startIndex, int length, Charset encoding) {
        if (buff == null) {
            //throw new ArgumentNullException("buff", "不能为空！");
        } else if (startIndex < 0) {
            //throw new ArgumentOutOfRangeException("startIndex", "不能小于零！");
        } else if (length <= 0) {
            //throw new ArgumentOutOfRangeException("length", "不能小于等于零！");
        } else if (buff.length < startIndex + length) {
            //throw new ArgumentOutOfRangeException("buff", "待解析目标长度小于预定长度！");
            return null;
        }
        
        ByteArrayOutputStream tempbuff = new ByteArrayOutputStream();
        
        for (int i = 0; i < length; i++) {
            if ('\0' == buff[startIndex + i]) {
                break;
            }
            tempbuff.write(buff[startIndex + i]);
        }
        if (tempbuff.size() == 0) {
            return null;
        }
        return new String(tempbuff.toByteArray() , encoding);
        //List<byte> buff = new List<byte>();
        //byte[] msgbuff = Encoding.ASCII.GetBytes(message);
        //buff.AddRange(msgbuff);
        //buff.Add((byte)0);
        //for (int i = message.Length; i < length; i++)
        //{
        //    buff.Add((byte)0);
        //}
    }
    
    public static byte[] GetBytesFromOctetString(String p) throws IOException {
        //Encoding encoding = Encoding.GetEncoding(936);
        Charset encoding = StandardCharsets.UTF_8;
        return StringUtility.GetBytesFromOctetString(p, encoding);
    }

    public static byte[] GetBytesFromOctetString(String p, Charset encoding) throws IOException {
        ByteArrayOutputStream tempbuff = new ByteArrayOutputStream();
        //buff.AddRange(BitConverter.GetBytes(p.Length));
        tempbuff.write(p.getBytes(encoding));
        
        //buff.AddRange(encoding.GetBytes(p));
        return tempbuff.toByteArray();
    }


    public static String GetOctetStringFromBytes(byte[] _packetBytes, int pos) {
        //Encoding encoding = Encoding.GetEncoding(936);
        Charset encoding = StandardCharsets.US_ASCII;
        return StringUtility.GetOctetStringFromBytes(_packetBytes, pos, encoding);
    }

    public static String GetOctetStringFromBytes(byte[] _packetBytes, int pos, Charset encoding) {
        if (_packetBytes == null) {
            //throw new ArgumentNullException("_packetBytes", "不能为空！");
        } else if (pos < 0) {
            //throw new ArgumentOutOfRangeException("pos", "不能小于零！");
        } else if (_packetBytes.length < pos) {
            //throw new ArgumentOutOfRangeException("buff", "待解析目标长度小于预定长度！");
            return null;
        }
        ByteArrayOutputStream tempbuff = new ByteArrayOutputStream();
        int i = pos;
        while (i < _packetBytes.length) {
            tempbuff.write(_packetBytes[i++]);
        }
        return new String(tempbuff.toByteArray(),encoding);
    }
}
