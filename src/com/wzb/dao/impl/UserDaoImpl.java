package com.wzb.dao.impl;

import com.wzb.bean.User;
import com.wzb.dao.BaseDao;
import com.wzb.dao.UserDao;

import java.io.*;
import java.util.ArrayList;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public void insert(User user) {
        String fileName = "C:\\Users\\wzb\\Desktop\\User.dat";
        saveObjectToFile(user, fileName);

    }

    @Override
    public ArrayList<User> getAllUser() {
        ArrayList<User> userList = new ArrayList<>();
        try (
                ObjectInputStream in = new ObjectInputStream
                        (new FileInputStream("C:\\Users\\wzb\\Desktop\\User.dat"))) {
            while (true) {  // 持续读取文件中的对象
                try {
                    User user = (User) in.readObject();  // 每次读取一个 User 对象
                    userList.add(user);  // 将 User 对象添加到 List 中
                } catch (EOFException e) {
                    // 读取到文件结尾时退出循环
                    break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("All User have been read from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void saveUpdatedUserById(User updatedUser) {
        ArrayList<User> userList = getAllUser();
        boolean userFound = false;
        // 创建临时文件用于保存更新后的用户数据
        File tempFile = new File("C:\\Users\\wzb\\Desktop\\User_temp.dat");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            // 遍历用户列表，找到需要修改的用户并更新
            for (User user : userList) {
                if (user.getId().equals(updatedUser.getId())) {
                    out.writeObject(updatedUser);  // 写入更新后的用户
                    userFound = true;
                } else {
                    out.writeObject(user);  // 写入其他未修改的用户
                }
            }

            if (userFound) {
                // 删除原文件
                File originalFile = new File("C:\\Users\\wzb\\Desktop\\User.dat");
                if (originalFile.exists() && originalFile.delete()) {
                    System.out.println("原文件已删除！");
                } else {
                    System.out.println("删除原文件失败！");
                }

                // 将临时文件的内容复制到原文件
                try (InputStream in = new FileInputStream(tempFile);
                     OutputStream outputStream = new FileOutputStream(originalFile)) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    System.out.println("用户信息已成功更新！");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // 删除临时文件
                if (tempFile.exists() && tempFile.delete()) {
                    System.out.println("临时文件已删除！");
                } else {
                    System.out.println("临时文件删除失败！");
                }
            } else {
                System.out.println("未找到该用户，更新失败！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteUserById(User deleteUser) {
        ArrayList<User> userList = getAllUser();
        boolean userFound = false;

        // 创建临时文件用于保存删除后的用户数据
        File tempFile = new File("C:\\Users\\wzb\\Desktop\\User_temp.dat");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            // 遍历用户列表，找到需要删除的用户并排除
            for (User user : userList) {
                if (user.getId().equals(deleteUser.getId())) {
                    userFound = true;  // 标记找到了要删除的用户
                    continue;  // 跳过要删除的用户
                }
                out.writeObject(user);  // 将未删除的用户写入临时文件
            }

            if (userFound) {
                // 删除原文件
                File originalFile = new File("C:\\Users\\wzb\\Desktop\\User.dat");
                if (originalFile.exists() && originalFile.delete()) {
                    System.out.println("原文件已删除！");
                } else {
                    System.out.println("删除原文件失败！");
                }

                // 将临时文件的内容复制到原文件
                try (InputStream in = new FileInputStream(tempFile);
                     OutputStream outputStream = new FileOutputStream(originalFile)) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    System.out.println("用户已成功删除！");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // 删除临时文件
                if (tempFile.exists() && tempFile.delete()) {
                    System.out.println("临时文件已删除！");
                } else {
                    System.out.println("临时文件删除失败！");
                }
            } else {
                System.out.println("未找到该用户，删除失败！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
