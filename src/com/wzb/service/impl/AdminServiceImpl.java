package com.wzb.service.impl;

import com.wzb.bean.User;
import com.wzb.dao.UserDao;
import com.wzb.dao.impl.UserDaoImpl;
import com.wzb.service.AdminService;
import com.wzb.utils.md5.MD5Util;

import java.util.List;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {

    private final UserDao userDao = new UserDaoImpl();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void showAllUser() {
        List<User> userList = userDao.getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Override
    public void deleteUser() {
        System.out.println("请输入想要查看的用户id");
        Integer id = Integer.parseInt(sc.nextLine());
        userDao.deleteUserById(id);
        System.out.println("删除成功");
    }

    @Override
    public void banAUser() {

    }

    @Override
    public void updateAUser() {
        List<User> userList = userDao.getAllUser();
        System.out.println("请输入想要更新的用户id");
        Integer id = Integer.parseInt(sc.nextLine());
        for (User user : userList) {
            if (user.getId().equals(id)) {
                System.out.println("当前用户信息为：");
                System.out.println(user);
                System.out.println("请输入修改后的密码");
                String password = sc.nextLine();
                user.setPassword(MD5Util.md5(password));
                System.out.println("请输入修改后的手机号");
                String phoneNumber = sc.nextLine();
                user.setPhoneNumber(phoneNumber);
                System.out.println("请输入修改后的账户余额");
                int money = Integer.parseInt(sc.nextLine());
                user.setMoney(money);
                System.out.println("请输入修改后的用户地址");
                String address = sc.nextLine();
                user.setAddress(address);
                userDao.saveUpdatedUserById(user);
                System.out.println("修改成功");
                break;
            }
        }
    }

    @Override
    public void getById() {
        List<User> userList = userDao.getAllUser();
        System.out.println("请输入想要查看的用户id");
        Integer id = Integer.parseInt(sc.nextLine());
        for (User user : userList) {
            if (user.getId().equals(id)) {
                System.out.println(user);
                break;
            }
        }
    }

    @Override
    public void showAdmin(User user) {
        System.out.println(user);
    }
}
