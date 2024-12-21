package com.wzb.service;

import com.wzb.bean.User;

public interface AdminService {
    void showAllUser();

    void deleteUser();

    void banAUser();

    void updateAUser();

    void getById();

    void showAdmin(User user);
}
