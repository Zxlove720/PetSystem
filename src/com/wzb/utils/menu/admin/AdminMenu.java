package com.wzb.utils.menu.admin;

/**
 * 管理员操作菜单
 */
public class AdminMenu {
    public static void showAdminMenu() {
        System.out.println("\t\t\t\t\tWelcome to admin system");
        System.out.println("\t\t\t************************************");
        System.out.println("\t\t\t\t\t     请输入数字选择：");
        System.out.println("\t\t\t\t\t     1.查看所有用户");
        System.out.println("\t\t\t\t\t     2.删除一个用户");
        System.out.println("\t\t\t\t\t     3.禁用一个用户");
        System.out.println("\t\t\t\t\t     4.修改一个用户");
        System.out.println("\t\t\t\t\t     5.查看一个用户");
        System.out.println("\t\t\t\t\t     6.查看管理员信息");
        System.out.println("\t\t\t\t\t     0.退出登录");

        System.out.println("输入你的选择-->");
    }
}
