package com.wzb.bean;

public class Dog extends Pet{
    public Dog(String name, Integer age, Double weight, String food, Integer price, Integer brand) {
        super(name, age, weight, food, price, brand);
    }

    public void fight() {
        System.out.println("小狗" + this.getName() + "能够看家");
    }
}
