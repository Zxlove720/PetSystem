package com.wzb.dao;

import java.io.*;

public class BaseDao {
    // 将对象保存到文件的方法
    public static void saveObjectToFile(Object obj, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(obj); // 将对象序列化到文件
            System.out.println("save successfully file path is: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从文件读取对象的方法
    public static Object readObjectFromFile(String filePath) {
        Object obj = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            obj = in.readObject(); // 反序列化对象
            System.out.println("Object has been read from file: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
