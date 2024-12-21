package com.wzb.bean;

public class Pet {
    private final Integer id;
    private String name;
    private Integer age;
    private Double weight;
    private String food;
    private Integer price;
    // 用于标识宠物的种类，1是狗、2是猫  后期扩展可以将其变为String类型
    private Integer brand;

    private static Integer idCounter = 0;

    public Pet(String name, Integer age, Double weight, String food, Integer price, Integer brand) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.food = food;
        this.price = price;
        this.brand = brand;
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

    public Integer getId() {
        return id;
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
