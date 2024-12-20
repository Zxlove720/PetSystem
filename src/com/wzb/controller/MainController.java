package com.wzb.controller;

import com.wzb.bean.User;
import com.wzb.dao.UserDao;
import com.wzb.dao.impl.UserDaoImpl;
import com.wzb.utils.md5.MD5Util;
import com.wzb.utils.menu.MainMenu;
import com.wzb.utils.wait.Wait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 主程序
 */
public class MainController {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        createRoot();
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

    public static void createRoot() {
        UserDao userDao = new UserDaoImpl();
        ArrayList<User> userList = userDao.getAllUser();
        boolean notRoot = true;
        for (User user : userList) {
            if (user.getUsername().equals("root")) {
                notRoot = false;
            }
        }
        if (notRoot) {
            userDao.insert(new User("wzb", MD5Util.md5("123456"), "123456", Integer.MAX_VALUE));
        }
    }
}
