package com.wzb.dao.impl;

import com.wzb.bean.User;
import com.wzb.dao.BaseDao;
import com.wzb.dao.UserDao;
import com.wzb.utils.md5.MD5Util;

import java.util.ArrayList;

public class UserDaoImpl extends BaseDao implements UserDao {

    private static final String USER_FILE = "users.dat";
    private ArrayList<User> users;

    // 构造函数：初始化用户数据
    public UserDaoImpl() {
        users = loadFromFile(USER_FILE); // 每次加载最新数据
        // 如果文件为空，添加管理员账户
        if (users.isEmpty()) {
            User admin = new User("wzb", MD5Util.md5("123456"), "123456", Integer.MAX_VALUE);
            users.add(admin);
            saveToFile(USER_FILE, users);  // 保存管理员账户到文件
        }
    }

    @Override
    public void insert(User user) {
        users.add(user);
        saveToFile(USER_FILE, users);  // 每次插入后保存
    }

    @Override
    public ArrayList<User> getAllUser() {
        users = loadFromFile(USER_FILE);  // 每次获取都从文件重新加载
        return users;
    }

    @Override
    public void saveUpdatedUserById(User updatedUser) {
        // 查找并更新用户
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(updatedUser.getId())) {
                users.set(i, updatedUser);  // 替换旧用户信息
                saveToFile(USER_FILE, users);  // 保存更新后的数据
                return;
            }
        }
    }

    @Override
    public void deleteUserById(int id) {
        // 删除指定 ID 的用户
        users.removeIf(user -> user.getId() == id);
        saveToFile(USER_FILE, users);  // 删除后立刻保存
    }
}
