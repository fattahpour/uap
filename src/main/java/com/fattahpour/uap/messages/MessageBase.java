package com.fattahpour.uap.messages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fattahpour.uap.utility.IntUtility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ghasem Fattahpour
 */
public abstract class MessageBase {

    protected int CommandLength;
    protected CommandIDs CommandID = CommandIDs.NONE;
    protected int CommandStatus = 0;
    protected int SenderCB = 0xFFFFFFFF;
    protected int ReceiverCB = 0xFFFFFFFF;
    protected String AccountName = "AccountName";
    protected String Password = "Password";
    protected final String SystemType = "USSD";
    protected final int InterfaceVersion = 0x10;
    protected UssdVersions UssdVersion;
    protected UssdOpTypes UssdOpType;
    protected String MsIsdn;
    protected int ServiceCode;
    protected CodeSchemes CodeScheme;
    protected String UssdString;
    protected int SwitchMode;
    protected int ChargeRatio;
    protected int ChargeType;
    protected String ChargeSource;
    protected int ChargeLocation;
    protected byte[] Message;

    public int getCommandLength() {
        return CommandLength;
    }

    public CommandIDs getCommandID() {
        return CommandID;
    }

    public int getCommandStatus() {
        return CommandStatus;
    }

    public int getSenderCB() {
        return SenderCB;
    }

    public int getReceiverCB() {
        return ReceiverCB;
    }

    public void setSenderCB(int SenderCB) {
        this.SenderCB = SenderCB;
    }

    public void setReceiverCB(int ReceiverCB) {
        this.ReceiverCB = ReceiverCB;
    }

    
    
    public int getInterfaceVersion() {
        return InterfaceVersion;
    }

    public String getSystemType() {
        return SystemType;
    }

    protected byte[] generateMessage() {
        return this.generateMessage(new byte[0]);
    }

    protected byte[] generateMessage(byte[] body) {
        ByteArrayOutputStream header = new ByteArrayOutputStream();
        try {

            header.write(IntUtility.toByte(this.getCommandID().toInt()));
            header.write(IntUtility.toByte(this.getCommandStatus()));
            header.write(IntUtility.toByte(this.getSenderCB()));
            header.write(IntUtility.toByte(this.getReceiverCB()));

            ByteArrayOutputStream message = new ByteArrayOutputStream();
            this.CommandLength = header.toByteArray().length + body.length + 4;
            message.write(IntUtility.toByte(header.toByteArray().length + body.length + 4));
            //System.out.println(header.toByteArray().length + body.length + 4);
            message.write(header.toByteArray());
            message.write(body);
            return message.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(MessageBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return header.toByteArray();
    }

    protected byte[] encode() {
        return null;
    }

    protected boolean headerDecode() {
        try {
            
            this.CommandLength = IntUtility.toInt(Arrays.copyOfRange(this.Message, 0, 4));
            this.CommandID = CommandIDs.fromInteger(IntUtility.toInt(Arrays.copyOfRange(this.Message, 4, 8)));
            this.CommandStatus = IntUtility.toInt(Arrays.copyOfRange(this.Message, 8, 12));
            this.SenderCB = IntUtility.toInt(Arrays.copyOfRange(this.Message, 12, 16));
            this.ReceiverCB = IntUtility.toInt(Arrays.copyOfRange(this.Message, 16, 20));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Decode the raw message bytes and populate the object's fields.
     *
     * @return {@code true} if decoding succeeds, otherwise {@code false}.
     */
    protected boolean decode() {
        if (this.headerDecode()) {
            return true;
        } else {
            return false;
        }
    }

    public void setCommandID(CommandIDs CommandID) {
        this.CommandID = CommandID;
    }

    
    
    @Override
    public String toString() {
        return "MessageBase{" + "CommandLength=" + CommandLength + ", CommandID=" + CommandID + ", CommandStatus=" + CommandStatus + ", SenderCB=" + SenderCB + ", ReceiverCB=" + ReceiverCB + ", AccountName=" + AccountName + ", Password=" + Password + ", SystemType=" + SystemType + ", InterfaceVersion=" + InterfaceVersion + ", UssdVersion=" + UssdVersion + ", UssdOpType=" + UssdOpType + ", MsIsdn=" + MsIsdn + ", ServiceCode=" + ServiceCode + ", CodeScheme=" + CodeScheme + ", UssdString=" + UssdString + ", SwitchMode=" + SwitchMode + ", ChargeRatio=" + ChargeRatio + ", ChargeType=" + ChargeType + ", ChargeSource=" + ChargeSource + ", ChargeLocation=" + ChargeLocation + ", Message=" + Message + '}';
    }
    
    
}
