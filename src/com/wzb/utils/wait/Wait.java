package com.wzb.utils.wait;

public class Wait {
    public static void waitMoments() throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.println();
    }
}
