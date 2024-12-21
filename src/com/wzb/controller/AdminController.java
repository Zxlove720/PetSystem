package com.wzb.controller;

import com.wzb.bean.User;
import com.wzb.service.AdminService;
import com.wzb.service.impl.AdminServiceImpl;
import com.wzb.utils.menu.admin.AdminMenu;
import com.wzb.utils.wait.Wait;

import java.util.Scanner;

public class AdminController {
    private static final Scanner sc = new Scanner(System.in);
    private static final AdminService adminService = new AdminServiceImpl();

    public static void modifyUser(User user) throws InterruptedException {
        boolean flag = true;
        while (flag) {
            AdminMenu.showAdminMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    adminService.showAllUser();
                    break;
                }
                case 2: {
                    adminService.deleteUser();
                    break;
                }
                case 3: {
                    adminService.banAUser();
                    break;
                }
                case 4: {
                    adminService.updateAUser();
                    break;
                }
                case 5: {
                    adminService.getById();
                    break;
                }
                case 6: {
                    adminService.showAdmin(user);
                    break;
                }
                case 0: {
                    System.out.print("退出管理员账户" + user.getUsername());
                    Wait.waitMoments();
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("选择错误，请重新选择");
                }
            }
        }
    }
}


