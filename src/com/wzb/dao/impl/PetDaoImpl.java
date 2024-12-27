package com.wzb.dao.impl;

import com.wzb.bean.Cat;
import com.wzb.bean.Dog;
import com.wzb.bean.Pet;
import com.wzb.dao.BaseDao;
import com.wzb.dao.PetDao;

import java.util.ArrayList;
import java.util.Collections;

public class PetDaoImpl extends BaseDao implements PetDao {
    // 预先定义的文件路径常量
    private static final String PET_FILE = "pets.dat";
    // 宠物集合
    private ArrayList<Pet> pets;

    /**
     * 通过从文件中读取的最后一个对象的id，计算出新对象的id
     * @return 新对象的id
     */
    public int getNextId() {
        pets = loadFromFile(PET_FILE);
        if (pets.isEmpty()) {
            return 0;
        } else {
            return pets.get(pets.size() - 1).getId() + 1;
        }
    }

    /**
     * 构造方法，如果文件刚刚创建为空，那么添加一些初始的宠物
     */
    public PetDaoImpl() {
        // 每次加载最新数据
        pets = loadFromFile(PET_FILE);
        // 如果文件为空，添加一些初始的宠物
        if (pets.isEmpty()) {
            Pet king = new Dog(0, "wzb-pet", 10, 70.0, "food", Integer.MAX_VALUE, 1);
            Pet dog = new Dog(1, "旺财", 2, 20.0, "bone", 500, 1);
            Pet dog1 = new Dog(2, "小黑", 3, 25.0, "bone", 500, 1);
            Pet cat = new Cat(3, "哈基米", 1, 15.0, "fish", 500, 2);
            Pet cat1 = new Cat(4, "咪咪", 2, 17.0, "fish", 500, 2);
            Collections.addAll(pets, king, dog, dog1, cat, cat1);
            saveToFile(PET_FILE, pets);
        }
    }

    /**
     * 插入一个宠物
     * @param pet 宠物对象
     */
    @Override
    public void insert(Pet pet) {
        pets.add(pet);
        saveToFile(PET_FILE, pets);
    }

    /**
     * 得到文件中所有的宠物对象
     * @return 宠物对象集合
     */
    @Override
    public ArrayList<Pet> getAllPet() {
        pets = loadFromFile(PET_FILE);
        return pets;
    }

    /**
     * 根据id更新宠物信息
     * @param updatedPet 更新后的宠物对象
     */
    @Override
    public void saveUpdatedPetById(Pet updatedPet) {
        // 查找并更新宠物
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId().equals(updatedPet.getId())) {
                // 替换旧宠物信息
                pets.set(i, updatedPet);
                saveToFile(PET_FILE, pets);
                return;
            }
        }
    }

    /**
     * 根据id删除宠物对象
     * @param id 要删除的宠物id
     * @return 删除宠物是否成功
     */
    @Override
    public boolean deletePetById(int id) {
        // 删除指定ID的宠物
        pets.removeIf(pet -> pet.getId() == id);
        saveToFile(PET_FILE, pets);  // 删除后立刻保存
        return true;
    }
}
