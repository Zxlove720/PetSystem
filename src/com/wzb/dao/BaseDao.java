package com.wzb.dao;

import java.io.*;
import java.util.ArrayList;

public class BaseDao {

    // 保存数据到文件
    public <T> void saveToFile(String filename, ArrayList<T> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从文件加载数据
    public <T> ArrayList<T> loadFromFile(String filename) {
        ArrayList<T> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            list = (ArrayList<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            // 文件不存在，返回空列表
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
