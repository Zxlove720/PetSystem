package com.wzb.service.impl;

import com.wzb.bean.User;
import com.wzb.dao.UserDao;
import com.wzb.dao.impl.UserDaoImpl;
import com.wzb.service.LoginService;
import com.wzb.service.UserService;
import com.wzb.utils.captcha.CaptchaUtils;
import com.wzb.utils.md5.MD5Util;

import java.util.Scanner;

public class UserServiceImpl implements UserService {
    private final LoginService login = new LoginServiceImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public User userLogin() {
        return login.login();
    }

    @Override
    public boolean userRegister() {
        return login.register();
    }

    @Override
    public void showUser(User user) {
        System.out.println("当前登录用户信息为：");
        System.out.println("用户名：" + user.getUsername());
        System.out.println("账户余额为：" + user.getMoney());
        System.out.println("地址为：" + user.getAddress());
        System.out.println();
    }

    @Override
    public boolean reCharge(User user) {
        System.out.println(user.getUsername() + "的账户余额是" + user.getMoney());
        System.out.println("请输入想要充值的金额-->");
        int money = Integer.parseInt(sc.nextLine());
        user.addMoney(money);
        System.out.println("充值成功");
        System.out.println(user.getUsername() + "的账户余额是" + user.getMoney());
        userDao.saveUpdatedUserById(user);  // 更新后立刻保存
        return true;
    }

    @Override
    public boolean changePassword(User user) {
        System.out.println("修改密码，若非本人操作，请立即冻结账号");
        System.out.println("请输入手机号码");
        String phoneNumber = sc.nextLine();
        if (phoneNumber.equals(user.getPhoneNumber())) {
            String captcha = CaptchaUtils.generateCode(6);
            System.out.println("验证码是：" + captcha);
            System.out.println("请输入验证码");
            String s = sc.nextLine();
            if (s.equalsIgnoreCase(captcha)) {
                System.out.println("请输入新密码");
                String password = sc.nextLine();
                System.out.println("请确认密码");
                String p = sc.nextLine();
                if (p.equals(password)) {
                    String realPassword = MD5Util.md5(password);
                    user.setPassword(realPassword);
                    userDao.saveUpdatedUserById(user);  // 更新后立刻保存
                    return true;

                } else {
                    System.out.println("两次密码不一致，修改失败");
                    return false;
                }
            } else {
                System.out.println("验证码不一致，修改密码失败");
                return false;
            }
        } else {
            System.out.println("电话不匹配，修改密码失败");
            return false;
        }
    }

    @Override
    public boolean changeAddress(User user) {
        System.out.println("请输入用户的地址");
        String address = sc.nextLine();
        user.setAddress(address);
        System.out.println("用户" + user.getUsername() + "的地址是" + user.getAddress());
        userDao.saveUpdatedUserById(user);  // 更新后立刻保存
        return true;
    }

    @Override
    public boolean deleteMyself(User user) {
        System.out.println("你确定要注销本账户吗？");
        System.out.println("该操作无法复原!");
        System.out.println("请输入“我想注销 + 用户名”继续");
        String answer = "我想注销" + user.getUsername();
        String input = sc.nextLine();
        if (answer.equals(input)) {
            userDao.deleteUserById(user.getId());  // 删除后立刻保存
            return true;
        } else {
            return false;
        }
    }
}
