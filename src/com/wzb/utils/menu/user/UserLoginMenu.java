package com.wzb.utils.menu.user;

/**
 * 用户登录菜单
 */
public class UserLoginMenu {
    public static void showUserLoginMenu() {
        System.out.println("\t\t\t\t\tWelcome to user login system");
        System.out.println("\t\t\t*******************************************");
        System.out.println("\t\t\t\t\t     请输入数字选择：");
        System.out.println("\t\t\t\t\t     1.登录");
        System.out.println("\t\t\t\t\t     2.注册");
        System.out.println("\t\t\t\t\t     0.返回上级");
        System.out.println("(默认有且仅有一个管理员账户：wzb；密码：123456)");
        System.out.println("必须要使用管理员账户：wzb，才可以使用管理员功能管理用户");
        System.out.println("您可以使用注册功能注册一个普通用户使用其他用户的功能");
        System.out.println("输入你的选择-->");
    }
}
