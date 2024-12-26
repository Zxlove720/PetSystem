package com.wzb.utils.captcha;

import java.util.Random;

/**
 * 用于生成指定位数的验证码的工具类
 */
public class CaptchaUtils {
    // 定义包含数字和大小写字母的字符集
    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // 生成指定长度的验证码
    public static String generateCode(int length) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        // 从字符池中随机选取字符
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            code.append(CHAR_POOL.charAt(index));
        }

        return code.toString();
    }
}
