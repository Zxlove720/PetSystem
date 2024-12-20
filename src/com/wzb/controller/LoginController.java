package com.wzb.controller;

import com.wzb.bean.User;
import com.wzb.service.UserService;
import com.wzb.service.impl.UserServiceImpl;
import com.wzb.utils.menu.user.UserLoginMenu;
import com.wzb.utils.wait.Wait;

import java.util.Scanner;

public class LoginController {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserService userService = new UserServiceImpl();

    public static void userLogin() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            UserLoginMenu.showUserLoginMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    User user = userService.userLogin();
                    if (user != null) {
                        UserController.modifyUser(user);
                    } else {
                        System.out.println("请重新登录");
                    }
                    break;
                }
                case 2: {
                    if (userService.userRegister()) {
                        System.out.println("注册成功");
                    } else {
                        System.out.println("请重新注册");
                    }
                    break;
                }
                case 0: {
                    System.out.println("正在返回上一级");
                    Thread.sleep(500);
                    System.out.print("");
                    Wait.waitMoments();
                    System.out.println("成功返回");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("选择错误，请再次选择");
                }
            }
        }

    }
}
