package com.wzb.controller;

import com.wzb.bean.User;
import com.wzb.service.ShopService;
import com.wzb.service.ShopServiceImpl;
import com.wzb.utils.menu.shop.ShopMenu;

import java.util.Scanner;

public class ShopController {
    private static final Scanner sc = new Scanner(System.in);
    private static final ShopService shopService = new ShopServiceImpl();

    public static void shop(User user) {
        boolean flag = true;
        while (flag) {
            ShopMenu.showShopMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    shopService.showAllPet();
                    break;
                }
                case 2: {
                    if (shopService.addShopCar(user)) {
                        System.out.println("添加购物车成功");
                    } else {
                        System.out.println("添加购物车失败");
                    }
                    break;
                }
                case 3: {
                    if (shopService.pay(user)) {
                        System.out.println("支付成功");
                    } else {
                        System.out.println("支付失败");
                    }
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