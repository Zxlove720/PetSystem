package com.wzb.controller;

import com.wzb.service.PetService;
import com.wzb.service.impl.PetServiceImpl;
import com.wzb.utils.menu.pet.PetMenu;
import com.wzb.utils.wait.Wait;

import java.util.Scanner;

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
                    petService.showAllPet();
                    break;
                }
                case 2: {
                    petService.insertPet();
                    break;
                }
                case 3: {
                    petService.deletePet();
                    break;
                }
                case 4: {
                    petService.updatePet();
                    break;
                }
                case 5: {
                    petService.getById();
                    break;
                }
                case 0: {
                    System.out.println("正在返回上一级");
                    Thread.sleep(500);
                    System.out.print("");
                    Wait.waitMoments();
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
