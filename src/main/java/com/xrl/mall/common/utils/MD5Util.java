package com.xrl.mall.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/***
 *@title MD5Util
 *@description MD5加密工具类
 *@author xrl
 *@version 1.0.0
 *@create 2025/3/26 21:04
 **/
public class MD5Util {

    /**
     * MD5加密
     * @param input
     * @return
     */
    public static String md5(String input) {
            StringBuffer sb = new StringBuffer();
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                byte[] digest = instance.digest(input.getBytes());
                for (byte b : digest) {
                    String string = Integer.toHexString(b & 0xff);
                    if(string.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(string);
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            return sb.toString();
        }
}
