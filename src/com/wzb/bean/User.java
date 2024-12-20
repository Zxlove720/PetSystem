package com.wzb.bean;

import java.io.Serializable;

public class User implements Serializable {
    // id作为用户的唯一标识符
    private final Integer id;
    private final String username;
    private String password;
    private String phoneNumber;
    // 用户的账户余额
    private Integer money;

    private String address;

    // 自动生成自增的 id
    private static int idCounter = 0;

    // 用户注册凭证：手机号注册
    public User(String username, String password, String phoneNumber) {
        this.id = idCounter++; // 自增 id
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.money = 0;
    }

    public boolean addMoney(Integer money) {
        this.money += money;
        return true;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", money=" + money +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
