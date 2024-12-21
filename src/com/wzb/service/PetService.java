package com.wzb.service;

import com.wzb.bean.Pet;

import java.util.List;

public interface PetService {
    List<Pet> showAllPet();

    void insertPet();

    void deletePet(int id);

    void updatePet(int id);

    Pet getById(int id);

}
