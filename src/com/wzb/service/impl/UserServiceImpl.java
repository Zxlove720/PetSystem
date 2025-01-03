package com.wzb.service.impl;

import com.wzb.bean.Pet;
import com.wzb.bean.User;
import com.wzb.dao.UserDao;
import com.wzb.dao.impl.UserDaoImpl;
import com.wzb.service.LoginService;
import com.wzb.service.PetService;
import com.wzb.service.UserService;
import com.wzb.utils.captcha.CaptchaUtils;
import com.wzb.utils.md5.MD5Util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 用户相关服务
 */
public class UserServiceImpl implements UserService {
    private final LoginService login = new LoginServiceImpl();
    private final PetService petService = new PetServiceImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final Scanner sc = new Scanner(System.in);

    /**
     * 用户登录
     * @return 登录成功之后的用户对象
     */
    @Override
    public User userLogin() {
        return login.login();
    }

    /**
     * 用户注册
     * @return 用户是否注册成功
     */
    @Override
    public boolean userRegister() {
        return login.register();
    }

    /**
     * 用户个人信息展示
     * @param user 当前登录的用户
     */
    @Override
    public void showUser(User user) {
        System.out.println("当前登录用户信息为：");
        System.out.println("用户名：" + user.getUsername());
        System.out.println("账户余额为：" + user.getMoney());
        System.out.println("地址为：" + user.getAddress());
        ArrayList<Pet> petList = new ArrayList<>();
        ArrayList<Integer> petIdList = user.getPetList();
        for (Integer id : petIdList) {
            petList.add(petService.getById(id));
        }
        System.out.println("该用户的宠物有：" + petList);
        System.out.println("该用户的订单有：" + user.getOrderList());
    }

    /**
     * 用户充值
     * @param user 当前登录的用户
     * @return 用户充值的结果
     */
    @Override
    public boolean reCharge(User user) {
        System.out.println(user.getUsername() + "的账户余额是" + user.getMoney());
        System.out.println("请输入想要充值的金额-->");
        int money = Integer.parseInt(sc.nextLine());
        user.addMoney(money);
        System.out.println("充值成功");
        user.setUpdateTime(LocalDateTime.now());
        // 只要用户信息发生变动，文件中的用户信息必须马上修改
        userDao.saveUpdatedUserById(user);
        System.out.println(user.getUsername() + "现在的账户余额是" + user.getMoney());
        return true;
    }

    /**
     * 修改用户密码
     * @param user 当前登录的用户
     * @return 修改密码是否成功
     */
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
                    user.setUpdateTime(LocalDateTime.now());
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

    /**
     * 修改地址
     * @param user 当前登录的用户
     * @return 修改地址是否成功
     */
    @Override
    public boolean changeAddress(User user) {
        System.out.println("请输入用户的地址");
        String address = sc.nextLine();
        user.setAddress(address);
        user.setUpdateTime(LocalDateTime.now());
        System.out.println("用户" + user.getUsername() + "的地址是" + user.getAddress());
        userDao.saveUpdatedUserById(user);  // 更新后立刻保存
        return true;
    }

    /**
     * 注销用户
     * @param user 当前登录的用户
     * @return 注销用户是否成功
     */
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
