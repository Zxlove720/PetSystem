package com.wzb.bean;

import com.wzb.service.PetService;
import com.wzb.service.impl.PetServiceImpl;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private static final PetService petService = new PetServiceImpl();

    private final ArrayList<Integer> pets;
    private final Integer sum;

    public Order(ArrayList<Integer> pets, Integer sum) {
        this.pets = pets;
        this.sum = sum;
    }

    public ArrayList<Integer> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        String result = "{Order: Pets{";
        for (Integer id : pets) {
            result = result + "{";
            result += petService.getById(id);
            result += "}";
        }
        result += "}, ";
        result += "Sum{" + sum + "}}";
        return result;
    }
}
