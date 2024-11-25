package com.juggle.im.util;

import java.util.Random;

public class RandomUtil {

    private static final String CHARS = "ABCDEFGHIJKMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789";

    /**
     * 根据len随机生成字符串。去除Lli1,oO0,
     * @param length 生成长度
     * @return
     */
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char randomChar = CHARS.charAt(random.nextInt(CHARS.length()));
            sb.append(randomChar);
        }

        return sb.toString();
    }


}
