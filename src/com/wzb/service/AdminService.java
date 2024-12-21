package com.wzb.service;

import com.wzb.bean.User;

import java.util.List;

public interface AdminService {
    List<User> showAllUser();

    void deleteUserById(int id);

    void banAUser(int id);

    void updateAUser(int id);

    User getById(int id);

    void showAdmin(User user);
}
