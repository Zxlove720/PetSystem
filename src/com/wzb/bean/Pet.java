package com.wzb.bean;

import java.io.Serializable;

public class Pet implements Serializable {
    private final Integer id;
    private String name;
    private Integer age;
    private Double weight;
    private String food;
    private Integer price;
    private Integer brand;

    // 通过构造器传入 ID，而不是通过静态初始化获取
    public Pet(Integer id, String name, Integer age, Double weight, String food, Integer price, Integer brand) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.food = food;
        this.price = price;
        this.brand = brand;
    }

    // Getter 和 Setter 方法
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", food='" + food + '\'' +
                ", price=" + price +
                '}';
    }
}
