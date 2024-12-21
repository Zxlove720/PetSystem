package com.wzb.bean;

public class Pet {
    private Integer id;
    private String name;
    private Integer age;
    private Double weight;
    private String Food;
    private Integer price;

    private static Integer idCounter = 0;

    public Pet(String name, Integer age, Double weight, String food, Integer price) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.weight = weight;
        Food = food;
        this.price = price;
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
        return Food;
    }

    public void setFood(String food) {
        Food = food;
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

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", Food='" + Food + '\'' +
                ", price=" + price +
                '}';
    }
}
