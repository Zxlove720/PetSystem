package com.wzb.dao.impl;

import com.wzb.bean.User;
import com.wzb.dao.BaseDao;
import com.wzb.dao.UserDao;
import com.wzb.utils.md5.MD5Util;

import java.util.ArrayList;

public class UserDaoImpl extends BaseDao implements UserDao {
    // 预先定义的文件路径常量
    private static final String USER_FILE = "users.dat";
    // 用户对象集合
    private ArrayList<User> users;

    /**
     * 通过从文件中读取的最后一个对象的id，计算出新对象的id
     * @return 新对象的id
     */
    public Integer getNextId() {
        users = loadFromFile(USER_FILE);
        if (users.isEmpty()) {
            return 0;  // 如果没有宠物，ID 从 1 开始
        } else {
            return users.get(users.size() - 1).getId() + 1;
        }
    }

    /**
     * 构造方法，如果文件刚刚创建为空，那么添加初始的管理员用户
     */
    public UserDaoImpl() {
        users = loadFromFile(USER_FILE);
        // 如果文件为空，添加管理员账户
        if (users.isEmpty()) {
            User admin = new User(getNextId(), "wzb", MD5Util.md5("123456"), "123456", Integer.MAX_VALUE);
            users.add(admin);
            // 保存管理员账户到文件
            saveToFile(USER_FILE, users);
        }
    }

    /**
     * 插入一个新的用户
     * @param user 插入新的用户对象
     */
    @Override
    public void insert(User user) {
        users.add(user);
        // 每次插入后保存
        saveToFile(USER_FILE, users);
    }

    /**
     * 从文件中获取所有的用户对象集合
     * @return 用户对象集合
     */
    @Override
    public ArrayList<User> getAllUser() {
        // 每次获取都从文件重新加载
        users = loadFromFile(USER_FILE);
        return users;
    }

    /**
     * 根据id更新用户信息
     * @param updatedUser 更新后的用户对象
     */
    @Override
    public void saveUpdatedUserById(User updatedUser) {
        // 查找并更新用户
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(updatedUser.getId())) {
                // 替换旧用户信息
                users.set(i, updatedUser);
                saveToFile(USER_FILE, users);
                return;
            }
        }
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    public void deleteUserById(int id) {
        // 删除指定 ID 的用户
        users.removeIf(user -> user.getId() == id);
        saveToFile(USER_FILE, users);  // 删除后立刻保存
    }
}
