package com.wzb.service;

import com.wzb.bean.User;

/**
 * 用户服务
 */
public interface UserService {
    User userLogin();

    boolean userRegister();

    void showUser(User user);

    void reCharge(User user);

    void changePassword(User user);

    void changeAddress(User user);

    void deleteMyself(User user);
}
