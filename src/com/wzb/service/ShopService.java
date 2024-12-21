package com.wzb.service;

import com.wzb.bean.User;

public interface ShopService {

    void showAllPet();

    boolean addShopCar(User user);

    boolean pay(User user);
}
