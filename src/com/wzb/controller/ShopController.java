package com.wzb.controller;

import com.wzb.bean.User;
import com.wzb.service.ShopService;
import com.wzb.service.impl.ShopServiceImpl;
import com.wzb.utils.menu.shop.ShopMenu;
import com.wzb.utils.wait.Wait;

import java.util.Scanner;

public class ShopController {
    private static final Scanner sc = new Scanner(System.in);
    private static final ShopService shopService = new ShopServiceImpl();

    public static void shop(User user) throws InterruptedException {
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
                    shopService.showShopCar(user);
                    break;
                }
                case 4: {
                    if (shopService.pay(user)) {
                        System.out.println("支付成功");
                    } else {
                        System.out.println("支付失败");
                    }
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