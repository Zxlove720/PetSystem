package com.wzb.service.impl;

import com.wzb.bean.User;
import com.wzb.dao.UserDao;
import com.wzb.dao.impl.UserDaoImpl;
import com.wzb.service.LoginService;
import com.wzb.utils.captcha.CaptchaUtils;
import com.wzb.utils.md5.MD5Util;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginServiceImpl implements LoginService {
    private final Scanner sc = new Scanner(System.in);
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User login() {
        ArrayList<User> userList = userDao.getAllUser();
        if (userList.isEmpty()) {
            System.out.println("user is not exist");
            return null;
        }
        System.out.println("Welcome login!");
        System.out.println("please input username");
        String username = sc.nextLine();
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                System.out.println("please input password");
                String password = sc.nextLine();
                String realPassword = MD5Util.md5(password);
                if (realPassword.equals(user.getPassword())) {
                    String captcha = CaptchaUtils.generateCode(6);
                    System.out.println("captcha is: " + captcha);
                    System.out.println("please input captcha: ");
                    String s = sc.nextLine();
                    if (s.equalsIgnoreCase(captcha)) {
                        System.out.println("login successfully");
                        return user;
                    } else {
                        System.out.println("error captcha");
                        return null;
                    }
                } else {
                    System.out.println("error password");
                    return null;
                }
            }
        }
        System.out.println("username not found");
        return null;
    }

    public boolean register() {
        System.out.println("Welcome to register");
        //TODO 日后需要检查用户名和密码的合法性
        System.out.println("please input your username");
        String username = sc.nextLine();
        System.out.println("please input your password");
        String password = sc.nextLine();
        String realPassword = MD5Util.md5(password);
        System.out.println("please input your phoneNumber");
        String phoneNumber = sc.nextLine();
        User user = new User(username, realPassword, phoneNumber);
        userDao.insert(user);
        return true;
    }
}
