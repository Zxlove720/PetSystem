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
    public List<Pet> getAllPet() {
        return petDao.getAllPet();
    }

    @Override
    public boolean insertPet() {
        System.out.println("请输入宠物的名字");
        String name = sc.nextLine();
        System.out.println("请输入宠物的年龄");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("请输入宠物的体重");
        double weight = Double.parseDouble(sc.nextLine());
        System.out.println("请输入宠物爱吃的食物");
        String food = sc.nextLine();
        System.out.println("请输入宠物的价格");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("请选择宠物种类是狗还是猫");
        System.out.println("1.狗             2.猫");
        int brand = Integer.parseInt(sc.nextLine());
        if (brand != 1 && brand != 2) {
            System.out.println("种类错误");
            return false;
        }
        petDao.insert(new Pet(petDao.getNextId(), name, age, weight, food, price, brand));
        return true;
    }

    @Override
    public boolean deletePet(int id) {
        return petDao.deletePetById(id);
    }

    @Override
    public boolean updatePet(int id) {
        List<Pet> petList = petDao.getAllPet();
        for (Pet pet : petList) {
            if (pet.getId().equals(id)) {
                System.out.println("当前宠物用户信息为：");
                System.out.println(pet);

                System.out.println("请输入修改后宠物的名字");
                String name = sc.nextLine();
                pet.setName(name);
                System.out.println("请输入修改后宠物的年龄");
                int age = Integer.parseInt(sc.nextLine());
                pet.setAge(age);
                System.out.println("请输入修改后宠物的体重");
                double weight = Double.parseDouble(sc.nextLine());
                pet.setWeight(weight);
                System.out.println("请输入修改后宠物爱吃的食物");
                String food = sc.nextLine();
                pet.setFood(food);
                System.out.println("请输入修改后宠物的价格");
                int price = Integer.parseInt(sc.nextLine());
                // 种类一般不改
                pet.setPrice(price);
                petDao.saveUpdatedPetById(pet);
                return true;
            }
        }
        return false;
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
