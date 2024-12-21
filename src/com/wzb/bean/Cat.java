package com.wzb.bean;

public class Cat extends Pet{

    public Cat(Integer id, String name, Integer age, Double weight, String food, Integer price, Integer brand) {
        super(id, name, age, weight, food, price, brand);
    }

    public void catchMouse() {
        System.out.println("小猫" + this.getName() + "能够抓老鼠");
    }
}
