package com.wzb.controller;

import com.wzb.utils.menu.MainMenu;
import com.wzb.utils.wait.WaitUtils;

import java.util.Scanner;

/**
 * 主系统
 */
public class MainController {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("please use UTF-8 or idea open this project");
        System.out.println("if you have any question please call 15123044540 or go 'gezhilou' A311 to find wzb");
        while (true) {
            MainMenu.showMainMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    LoginController.userLogin();
                    break;
                }
                case 2: {
                    PetController.modifyPet();
                    break;
                }
                case 0: {
                    System.out.println("感谢您使用本系统，欢迎再次使用");
                    Thread.sleep(500);
                    System.out.print("系统正在退出");
                    WaitUtils.waitMoments();
                    System.exit(0);
                }
                default: {
                    System.out.println("选择错误，请再次选择");
                }
            }
        }
    }
}
