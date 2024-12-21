package com.wzb.controller;

import com.wzb.utils.menu.MainMenu;
import com.wzb.utils.wait.Wait;

import java.util.Scanner;

/**
 * 主程序
 */
public class MainController {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            MainMenu.showMainMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    LoginController.userLogin();
                    break;
                }
                case 2: {
                    System.out.println("宠物开发中");
                    break;
                }
                case 0: {
                    System.out.println("感谢您使用本系统，欢迎再次使用");
                    Thread.sleep(500);
                    System.out.print("系统正在退出");
                    Wait.waitMoments();
                    System.exit(0);
                }
                default: {
                    System.out.println("选择错误，请再次选择");
                }
            }
        }
    }
}
