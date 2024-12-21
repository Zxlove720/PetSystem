package com.wzb.bean;

import java.util.ArrayList;

public class Order {
    private final Integer id;
    private final ArrayList<Integer> pets;
    private final Integer sum;

    // 自动生成自增的 id
    private static int idCounter = 0;

    public Order(Integer id, ArrayList<Integer> pets, Integer sum) {
        this.id = idCounter++;
        this.pets = pets;
        this.sum = sum;
    }

    public void showOrder() {
        System.out.println("订单编号为" + this.id + "订单内容是" + this.pets + "总金额是" + this.sum);
    }
}
