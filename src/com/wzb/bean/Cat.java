package com.wzb.bean;

public class Cat extends Pet{

    public Cat(String name, Integer age, Double weight, String food, Integer price, Integer brand) {
        super(name, age, weight, food, price, brand);
    }

    public void catchMouse() {
        System.out.println("小猫" + this.getName() + "能够抓老鼠");
    }
}
