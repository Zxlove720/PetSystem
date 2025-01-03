package com.wzb.service.impl;

import com.wzb.bean.Order;
import com.wzb.bean.Pet;
import com.wzb.bean.User;
import com.wzb.dao.PetDao;
import com.wzb.dao.UserDao;
import com.wzb.dao.impl.PetDaoImpl;
import com.wzb.dao.impl.UserDaoImpl;
import com.wzb.service.PetService;
import com.wzb.service.ShopService;
import com.wzb.utils.md5.MD5Util;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 购物服务
 */
public class ShopServiceImpl implements ShopService {

    private final PetDao petDao = new PetDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final PetService petService = new PetServiceImpl();
    private final Scanner sc = new Scanner(System.in);

    /**
     * 展示所有宠物
     */
    @Override
    public void showAllPet() {
        ArrayList<Pet> petList = petDao.getAllPet();
        for (Pet pet : petList) {
            if (pet.getStatus()) {
                System.out.println(pet);
            }
        }
    }

    /**
     * 展示用户的购物车
     * @param user 登录的用户
     */
    @Override
    public void showShopCar(User user) {
        ArrayList<Integer> shopCar = user.getShopCar();
        System.out.println(user.getUsername() + "的购物车的内容是");
        for (Integer id : shopCar) {
            System.out.println(petService.getById(id));
        }
    }

    /**
     * 添加购物车
     * @param user 登录的用户
     * @return 添加购物车是否成功
     */
    @Override
    public boolean addShopCar(User user) {
        System.out.println("目前有的宠物如下：");
        showAllPet();
        System.out.println("请输入想要添加到购物车的宠物的id");
        Integer id = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> shopCar = user.getShopCar();
        shopCar.add(id);
        Pet pet = petService.getById(id);
        pet.setStatus(false);
        petDao.saveUpdatedPetById(pet);
        user.setShopCar(shopCar);
        userDao.saveUpdatedUserById(user);
        System.out.println("现在购物车中有：");
        for (Integer i : shopCar) {
            petService.getById(i);
        }
        return true;
    }

    /**
     * 支付
     * @param user 登录的用户
     * @return 支付结果
     */
    @Override
    public boolean pay(User user) {
        // 逻辑：
        // 用户清空购物车，然后算出总金额，和内容，构造一张订单，将订单加入orderList，将订单内容加入OrderList
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
                    Pet pet = petService.getById(id);
                    pet.setStatus(false);
                    petList.add(id);
                    petDao.saveUpdatedPetById(pet);
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
