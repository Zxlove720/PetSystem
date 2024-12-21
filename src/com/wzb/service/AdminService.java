package com.wzb.service;

import com.wzb.bean.User;

import java.util.List;

public interface AdminService {
    List<User> showAllUser();

    boolean deleteUserById(int id);

    boolean changeUserStatus(int id);

    boolean updateAUser(int id);

    User getById(int id);

    void showAdmin(User user);
}
