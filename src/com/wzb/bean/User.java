package com.wzb.bean;

import com.wzb.service.PetService;
import com.wzb.service.impl.PetServiceImpl;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class User implements Serializable {
    private final PetService petService = new PetServiceImpl();

    // id作为用户的唯一标识符
    private final Integer id;
    // 用户名
    private final String username;
    // 密码
    private String password;
    // 手机号
    private String phoneNumber;
    // 用户的账户余额
    private Integer money;
    // 用户的地址
    private String address;
    // 用户状态
    private Boolean status;
    // 用户持有的宠物
    private ArrayList<Integer> petList;
    // 用户的购物车
    private ArrayList<Integer> shopCar;
    // 用户的订单表
    private ArrayList<Order> orderList;
    // 注册时间
    private LocalDate registerDate;
    // 修改时间
    private LocalDateTime updateTime;


    // 用户注册凭证：手机号注册
    public User(Integer id, String username, String password, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;

        // 用户账户默认没钱
        this.money = 0;
        // 用户状态默认可用
        this.status = true;
        // 用户默认无宠物
        this.petList = new ArrayList<>();
        // 用户购物车
        this.shopCar = new ArrayList<>();
        // 用户订单表
        this.orderList = new ArrayList<>();
        // 注册时间
        this.registerDate = LocalDate.now();
        // 修改时间
        this.updateTime = LocalDateTime.now();
    }

    // 创建管理员用户
    public User(Integer id, String username, String password, String phoneNumber, int money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.money = money;
        this.address = "重庆文理学院wzb";

        this.status = true;
        this.petList = new ArrayList<>();
        petList.add(0);
        // 用户购物车
        this.shopCar = new ArrayList<>();
        // 用户订单表
        this.orderList = new ArrayList<>();
        // 注册时间
        this.registerDate = LocalDate.now();
        // 修改时间
        this.updateTime = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<Integer> getPetList() {
        return petList;
    }

    public void setPetList(ArrayList<Integer> petList) {
        this.petList = petList;
    }

    public ArrayList<Integer> getShopCar() {
        return shopCar;
    }

    public void setShopCar(ArrayList<Integer> shopCar) {
        this.shopCar = shopCar;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void addMoney(Integer money) {
        this.money += money;
    }

    @Override
    public String toString() {
        ArrayList<Pet> pets = new ArrayList<>();
        for (Integer id : petList) {
            pets.add(petService.getById(id));
        }

        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", money=" + money +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", petList=" + pets +
                ", shopCar=" + shopCar +
                ", orderList=" + orderList +
                ", registerDate=" + registerDate +
                ", updateTime=" + updateTime +
                '}';
    }

    public void showOrders() {
        System.out.println("当前用户" + username + "的订单内容为");
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println("这是第" + (i + 1) + "张订单");
            System.out.println(orderList.get(i));
        }
    }

}
