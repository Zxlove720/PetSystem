package com.wzb.service;

import com.wzb.bean.Pet;

import java.util.List;

public interface PetService {
    List<Pet> showAllPet();

    boolean insertPet();

    boolean deletePet(int id);

    boolean updatePet(int id);

    Pet getById(int id);

}
