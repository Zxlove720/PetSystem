package com.wzb.service.impl;

import com.wzb.bean.Pet;
import com.wzb.dao.PetDao;
import com.wzb.dao.impl.PetDaoImpl;
import com.wzb.service.PetService;

import java.util.List;
import java.util.Scanner;

public class PetServiceImpl implements PetService {
    private final PetDao petDao = new PetDaoImpl();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public List<Pet> showAllPet() {
        List<Pet> petList = petDao.getAllPet();
        for (Pet pet : petList) {
            System.out.println(pet);
        }
        return petList;
    }

    @Override
    public void insertPet() {

    }

    @Override
    public void deletePet(int id) {
        if (petDao.deletePetById(id)) {
            System.out.println("删除" + getById(id).getName() + "成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void updatePet(int id) {

    }

    @Override
    public Pet getById(int id) {
        List<Pet> petList = petDao.getAllPet();
        for (Pet pet : petList) {
            if (pet.getId().equals(id)) {
                return pet;
            }
        }
        return null;
    }
}
