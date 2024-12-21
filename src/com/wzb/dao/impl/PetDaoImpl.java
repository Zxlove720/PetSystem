package com.wzb.dao.impl;

import com.wzb.bean.Pet;
import com.wzb.dao.BaseDao;
import com.wzb.dao.PetDao;

import java.util.ArrayList;

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
        // 如果文件为空，添加一猫一狗
        if (pets.isEmpty()) {
            Pet king = new Pet(getNextId(), "wzb-pet", 10, 70.0, "food", Integer.MAX_VALUE, 1);
            pets.add(king);
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
        // 查找并更新用户
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId().equals(updatedPet.getId())) {
                pets.set(i, updatedPet);  // 替换旧用户信息
                saveToFile(PET_FILE, pets);  // 保存更新后的数据
                return;
            }
        }
    }

    @Override
    public boolean deletePetById(int id) {
        // 删除指定 ID 的用户
        pets.removeIf(pet -> pet.getId() == id);
        saveToFile(PET_FILE, pets);  // 删除后立刻保存
        return true;
    }
}
