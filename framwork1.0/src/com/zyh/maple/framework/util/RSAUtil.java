/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

public class RSAUtil {
    private final byte[] hex = "0123456789ABCDEF".getBytes();

    public static void main(String[] args) {
        try {
            RSAUtil rsaUtil = new RSAUtil();
            String msg = "\u8fd9\u662f\u54c8\u7968\u7684rsa\u52a0\u5bc6\u548c\u89e3\u5bc6\u7b97\u6cd5_\u5b89\u5168\u7f16\u7a0b\u6280\u672f";
            System.out.println("\u660e\u6587\u662f:" + msg);
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(1024);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
            RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
            byte[] srcBytes = msg.getBytes();
            byte[] resultBytes = rsaUtil.encrypt(publicKey, srcBytes);
            String result = new String(resultBytes);
            System.out.println("\u7528\u516c\u94a5\u52a0\u5bc6\u540e\u5bc6\u6587\u662f:" + rsaUtil.Bytes2HexString(resultBytes));
            byte[] decBytes = rsaUtil.decrypt(privateKey, resultBytes);
            String dec = new String(decBytes);
            System.out.println("\u7528\u79c1\u94a5\u89e3\u5bc6\u540e\u7ed3\u679c\u662f:" + dec);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected byte[] encrypt(RSAPublicKey publicKey, byte[] srcBytes) {
        if (publicKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(1, publicKey);
                byte[] resultBytes = cipher.doFinal(srcBytes);
                return resultBytes;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected byte[] decrypt(RSAPrivateKey privateKey, byte[] encBytes) {
        if (privateKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(2, privateKey);
                byte[] decBytes = cipher.doFinal(encBytes);
                return decBytes;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String Bytes2HexString(byte[] b) {
        if (b == null) {
            return "";
        }
        byte[] buff = new byte[2 * b.length];
        int i = 0;
        while (i < b.length) {
            buff[2 * i] = this.hex[b[i] >> 4 & 15];
            buff[2 * i + 1] = this.hex[b[i] & 15];
            ++i;
        }
        return new String(buff);
    }
}

