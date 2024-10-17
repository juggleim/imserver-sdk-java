package com.juggle.im.util;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex;

public class Util {
    public static String Sha1(String value){
        try{
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(value.getBytes("utf-8"));
        byte[] digest = md.digest();
        return String.valueOf(Hex.encodeHex(digest));
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
