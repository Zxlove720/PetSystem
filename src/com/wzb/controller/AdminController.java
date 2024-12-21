package com.wzb.controller;

import com.wzb.bean.User;
import com.wzb.service.AdminService;
import com.wzb.service.impl.AdminServiceImpl;
import com.wzb.utils.menu.admin.AdminMenu;
import com.wzb.utils.wait.Wait;

import java.util.List;
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
                    List<User> userList = adminService.showAllUser();
                    for (User u : userList) {
                        System.out.println(u);
                    }
                    break;
                }
                case 2: {
                    System.out.println("请输入想要删除的用户id");
                    int id = Integer.parseInt(sc.nextLine());
                    if (adminService.deleteUserById(id)) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                    break;
                }
                case 3: {
                    System.out.println("请输入想要更改状态的用户id");
                    int id = Integer.parseInt(sc.nextLine());
                    if (adminService.changeUserStatus(id)) {
                        System.out.println("更改状态成功");
                    } else {
                        System.out.println("更改状态失败");
                    }
                    break;
                }
                case 4: {
                    System.out.println("请输入想要更新的用户id");
                    int id = Integer.parseInt(sc.nextLine());
                    if (adminService.updateAUser(id)) {
                        System.out.println("用户更新成功");
                    } else {
                        System.out.println("用户更新失败");
                    }
                    break;
                }
                case 5: {
                    System.out.println("请输入想要查看的用户id");
                    int id = Integer.parseInt(sc.nextLine());
                    User u = adminService.getById(id);
                    System.out.println(u);
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


