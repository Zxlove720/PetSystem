package com.wzb.controller;

import com.wzb.bean.User;
import com.wzb.utils.menu.shop.ShopMenu;

import java.util.Scanner;

public class ShopController {
    private static final Scanner sc = new Scanner(System.in);

    public static void shop(User user) {
        boolean flag = true;
        while (flag) {
            ShopMenu.showShopMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {

                    break;
                }
                case 2: {

                    break;
                }
                case 3: {

                    break;
                }
                case 0: {

                    break;
                }
                default: {

                }
            }
        }
    }
}