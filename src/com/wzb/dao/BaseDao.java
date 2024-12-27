package com.wzb.dao;

import java.io.*;
import java.util.ArrayList;

public class BaseDao {

    /**
     * 将对象保存到文件中
     * @param filename 文件路径
     * @param list 更新后的对象list
     * @param <T> 泛型，一切bean
     */
    public <T> void saveToFile(String filename, ArrayList<T> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
            oos.flush();
            System.out.println("file save completely wzb 202358234044");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中读取对象
     * @param filename 文件路径
     * @return 从文件中读取的对象组成的集合
     * @param <T> 泛型
     */
    public <T> ArrayList<T> loadFromFile(String filename) {
        ArrayList<T> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            list = (ArrayList<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            // 文件不存在，返回空列表
            System.out.println("file is not exist wzb 202358234044");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("file load completely wzb 202358234044");
        return list;
    }
}
