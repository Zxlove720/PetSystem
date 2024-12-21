package com.wzb.dao;

import com.wzb.bean.Pet;

import java.util.ArrayList;

public interface PetDao {
    int getNextId();

    void insert(Pet pet);

    ArrayList<Pet> getAllPet();

    public void saveUpdatedPetById(Pet updatedPet);

    public boolean deletePetById(int id);
}
