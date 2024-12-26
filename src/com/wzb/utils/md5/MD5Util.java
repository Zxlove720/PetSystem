package com.wzb.utils.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用于将密码加密的MD5加密工具类
 */
public class MD5Util {

    // MD5加密方法
    public static String md5(String input) {
        try {
            // 创建 MessageDigest 实例，指定 MD5 算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 更新 MessageDigest 实例，提供待加密的数据
            md.update(input.getBytes());
            // 进行加密，得到字节数组
            byte[] digest = md.digest();
            // 转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                // 将每个字节转为两位的十六进制数
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            // 返回加密后的结果
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null; // 如果出现异常，返回 null
        }
    }
}
