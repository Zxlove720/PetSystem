package com.wzb.bean;

public class Cat extends Pet{

    public Cat(String name, Integer age, Double weight, String food, Integer price) {
        super(name, age, weight, food, price);
    }

    public void catchMouse() {
        System.out.println("小猫" + this.getName() + "能够抓老鼠");
    }
}
