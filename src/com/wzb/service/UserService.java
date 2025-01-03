package com.wzb.service;

import com.wzb.bean.User;

public interface UserService {
    User userLogin();

    boolean userRegister();

    void showUser(User user);

    boolean reCharge(User user);

    boolean changePassword(User user);

    boolean changeAddress(User user);

    boolean deleteMyself(User user);
}
