package com.wzb.utils.wait;

/**
 * 用于创建等待动画的工具类
 */
public class WaitUtils {
    public static void waitMoments() throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.println();
    }
}
