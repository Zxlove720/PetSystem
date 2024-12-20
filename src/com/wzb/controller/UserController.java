package com.wzb.controller;

import com.wzb.bean.User;
import com.wzb.service.UserService;
import com.wzb.service.impl.UserServiceImpl;
import com.wzb.utils.menu.user.UserMenu;
import com.wzb.utils.wait.Wait;

import java.util.Scanner;

public class UserController {
    private static final Scanner sc = new Scanner(System.in);

    private static final UserService userService = new UserServiceImpl();

    public static void modifyUser(User user) throws InterruptedException {
        boolean flag = true;
        while (flag) {
            UserMenu.showUserMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    userService.showUser(user);
                    break;
                }
                case 2: {
                    System.out.println("浏览宠物");
                    break;
                }
                case 3: {
                    userService.reCharge(user);
                    break;
                }
                case 4: {
                    userService.changePassword(user);
                    break;
                }
                case 5: {
                    userService.changeAddress(user);
                    break;
                }
                case 6: {
                    userService.deleteMyself(user);
                    System.out.print("账户已注销，正在回到登录界面");
                    Wait.waitMoments();
                    flag = false;
                    break;
                }
                case 0: {
                    System.out.print("退出账户" + user.getUsername());
                    Wait.waitMoments();
                    flag = false;
                }
                default: {
                    System.out.println("选择错误，请重新选择");
                }
            }
        }
    }

}
