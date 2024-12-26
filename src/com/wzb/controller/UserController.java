package com.wzb.controller;

import com.wzb.bean.User;
import com.wzb.service.UserService;
import com.wzb.service.impl.UserServiceImpl;
import com.wzb.utils.menu.user.UserMenu;
import com.wzb.utils.wait.WaitUtils;

import java.util.Scanner;

/**
 * 用户功能
 */
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
                    ShopController.shop(user);
                    break;
                }
                case 3: {
                    if (userService.reCharge(user)) {
                        System.out.println("充值成功");
                    } else {
                        System.out.println("充值失败");
                    }
                    break;
                }
                case 4: {
                    if (userService.changePassword(user)) {
                        System.out.println("修改密码成功");
                    } else {
                        System.out.println("修改密码失败");
                    }
                    break;
                }
                case 5: {
                    if (userService.changeAddress(user)) {
                        System.out.println("修改地址成功");
                    } else {
                        System.out.println("修改地址失败");
                    }
                    break;
                }
                case 6: {
                    if (userService.deleteMyself(user)) {
                        System.out.print("账户已注销，正在回到登录界面");
                        WaitUtils.waitMoments();
                        flag = false;
                    } else {
                        System.out.println("账户注销失败");
                    }
                    break;
                }
                case 0: {
                    System.out.print("退出账户" + user.getUsername());
                    WaitUtils.waitMoments();
                    flag = false;
                }
                default: {
                    System.out.println("选择错误，请重新选择");
                }
            }
        }
    }

}
