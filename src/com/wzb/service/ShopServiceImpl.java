package com.wzb.service;

import com.wzb.bean.Order;
import com.wzb.bean.Pet;
import com.wzb.bean.User;
import com.wzb.dao.PetDao;
import com.wzb.dao.UserDao;
import com.wzb.dao.impl.PetDaoImpl;
import com.wzb.dao.impl.UserDaoImpl;
import com.wzb.service.impl.PetServiceImpl;
import com.wzb.utils.md5.MD5Util;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopServiceImpl implements ShopService {

    private final PetDao petDao = new PetDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final PetService petService = new PetServiceImpl();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void showAllPet() {
        ArrayList<Pet> petList = petDao.getAllPet();
        for (Pet pet : petList) {
            System.out.println(pet);
        }
    }

    @Override
    public boolean addShopCar(User user) {
        System.out.println("目前有的宠物如下：");
        showAllPet();
        System.out.println("请输入想要添加到购物车的宠物的id");
        Integer id = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> shopCar = user.getShopCar();
        shopCar.add(id);
        user.setShopCar(shopCar);
        userDao.saveUpdatedUserById(user);
        System.out.println("现在购物车中有：");
        for (Integer i : shopCar) {
            petService.getById(i);
        }
        return true;
    }

    @Override
    public boolean pay(User user) {
        // 逻辑：
        // 用户清空购物车，然后算出总金额，和内容，构造一张订单，将订单加入orderList，将订单内容加入petList
        ArrayList<Integer> shopCar = user.getShopCar();
        int sum = 0;
        for (Integer id : shopCar) {
            sum += petService.getById(id).getPrice();
        }
        if (user.getMoney() > sum) {
            System.out.println("账户余额充足(" + user.getMoney() + ")，请输入登录密码确认支付");
            String password = sc.nextLine();
            if (MD5Util.md5(password).equals(user.getPassword())) {
                ArrayList<Order> orderList = user.getOrderList();
                ArrayList<Integer> petList = new ArrayList<>();
                for (Integer id : shopCar) {
                    petService.deletePet(id);
                    petList.add(id);
                }
                Order order = new Order(petList, sum);
                orderList.add(order);
                shopCar.clear();
                user.setShopCar(shopCar);
                user.setOrderList(orderList);
                user.setPetList(petList);
                user.setMoney(user.getMoney() - sum);
                userDao.saveUpdatedUserById(user);
                return true;
            } else {
                System.out.println("登录密码错误");
                return false;
            }
        } else {
            System.out.println("账户余额不足，请先充值");
            return false;
        }
    }
}
