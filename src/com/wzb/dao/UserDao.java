package com.wzb.dao;

import com.wzb.bean.User;

import java.util.ArrayList;

public interface UserDao {
    Integer getNextId();

    void insert(User user);

    ArrayList<User> getAllUser();

    void saveUpdatedUserById(User updatedUser);

    void deleteUserById(int id);
}
