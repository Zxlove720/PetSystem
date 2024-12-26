package com.wzb.controller;

import com.wzb.bean.Pet;
import com.wzb.service.PetService;
import com.wzb.service.impl.PetServiceImpl;
import com.wzb.utils.menu.pet.PetMenu;
import com.wzb.utils.wait.WaitUtils;

import java.util.List;
import java.util.Scanner;

/**
 * 宠物管理
 */
public class PetController {
    private static final Scanner sc = new Scanner(System.in);
    private static final PetService petService = new PetServiceImpl();

    public static void modifyPet() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            PetMenu.showPetMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    List<Pet> petList = petService.getAllPet();
                    for (Pet pet : petList) {
                        System.out.println(pet);
                    }
                    break;
                }
                case 2: {
                    if (petService.insertPet()) {
                        System.out.println("插入成功");
                    } else {
                        System.out.println("插入失败");
                    }
                    break;
                }
                case 3: {
                    System.out.println("请输入想要删除的宠物id");
                    int id = Integer.parseInt(sc.nextLine());
                    if (petService.deletePet(id)) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                    break;
                }
                case 4: {
                    System.out.println("请输入想要更新的宠物id");
                    int id = Integer.parseInt(sc.nextLine());
                    if (petService.updatePet(id)) {
                        System.out.println("更新成功");
                    } else {
                        System.out.println("更新失败");
                    }
                    break;
                }
                case 5: {
                    System.out.println("请输入想要查看的宠物id");
                    int id = Integer.parseInt(sc.nextLine());
                    Pet pet = petService.getById(id);
                    System.out.println(pet);
                    break;
                }
                case 0: {
                    System.out.println("正在返回上一级");
                    Thread.sleep(500);
                    System.out.print("");
                    WaitUtils.waitMoments();
                    System.out.println("成功返回");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("选择错误，请重新选择");
                }
            }
        }
    }
}
