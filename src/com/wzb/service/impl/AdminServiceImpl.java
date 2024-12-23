package com.wzb.service.impl;

import com.wzb.bean.User;
import com.wzb.dao.UserDao;
import com.wzb.dao.impl.UserDaoImpl;
import com.wzb.service.AdminService;
import com.wzb.utils.md5.MD5Util;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {

    private final UserDao userDao = new UserDaoImpl();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public List<User> showAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public boolean deleteUserById(int id) {
        userDao.deleteUserById(id);  // 删除后立刻保存到文件
        return true;
    }

    @Override
    public boolean changeUserStatus(int id) {
        List<User> userList = userDao.getAllUser();
        for (User user : userList) {
            if (user.getId().equals(id)) {
                // 用户若不可用，则改为可用，可用则改为不可用
                user.setStatus(!user.getStatus());
                user.setUpdateTime(LocalDateTime.now());
                userDao.saveUpdatedUserById(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateAUser(int id) {
        List<User> userList = userDao.getAllUser();
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
                user.setUpdateTime(LocalDateTime.now());
                userDao.saveUpdatedUserById(user);  // 更新后立刻保存
                return true;
            }
        }
        return false;
    }

    @Override
    public User getById(int id) {
        List<User> userList = userDao.getAllUser();
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void showAdmin(User user) {
        System.out.println(user);
    }
}
