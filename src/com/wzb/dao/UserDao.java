package com.wzb.dao;

import com.wzb.bean.User;

import java.util.ArrayList;

public interface UserDao {
    public Integer getNextId();

    void insert(User user);

    ArrayList<User> getAllUser();

    public void saveUpdatedUserById(User updatedUser);

    public void deleteUserById(int id);
}
