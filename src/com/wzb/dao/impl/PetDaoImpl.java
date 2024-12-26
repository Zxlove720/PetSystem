package com.wzb.dao.impl;

import com.wzb.bean.Cat;
import com.wzb.bean.Dog;
import com.wzb.bean.Pet;
import com.wzb.dao.BaseDao;
import com.wzb.dao.PetDao;

import java.util.ArrayList;
import java.util.Collections;

public class PetDaoImpl extends BaseDao implements PetDao {
    private static final String PET_FILE = "pets.dat";
    private ArrayList<Pet> pets;

    public int getNextId() {
        pets = loadFromFile(PET_FILE);
        if (pets.isEmpty()) {
            return 0;
        } else {
            return pets.get(pets.size() - 1).getId() + 1;
        }
    }

    public PetDaoImpl() {
        pets = loadFromFile(PET_FILE); // 每次加载最新数据
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

    @Override
    public void insert(Pet pet) {
        pets.add(pet);
        saveToFile(PET_FILE, pets);  // 每次插入后保存
    }

    @Override
    public ArrayList<Pet> getAllPet() {
        pets = loadFromFile(PET_FILE);  // 每次获取都从文件重新加载
        return pets;
    }

    @Override
    public void saveUpdatedPetById(Pet updatedPet) {
        // 查找并更新宠物
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId().equals(updatedPet.getId())) {
                pets.set(i, updatedPet);  // 替换旧宠物信息
                saveToFile(PET_FILE, pets);  // 保存更新后的数据
                return;
            }
        }
    }

    @Override
    public boolean deletePetById(int id) {
        // 删除指定ID的宠物
        pets.removeIf(pet -> pet.getId() == id);
        saveToFile(PET_FILE, pets);  // 删除后立刻保存
        return true;
    }
}
