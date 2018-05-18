package com.example.oguzhan.petodex.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import com.example.oguzhan.petodex.pets.Pet;

@Dao
public interface IPetDAO {

    @Insert
    void insertPet(Pet pet);

    @Update
    void updatePet(Pet pet);

    @Delete
    void deletePet(Pet pet);

    @Query("SELECT * FROM Pet")
    List<Pet> loadAllPets();

    @Query("SELECT * FROM Pet WHERE id=:id")
    Pet loadPetById(int id);

    @Query("SELECT * FROM Pet WHERE id=:id")
    boolean existsPet(int id);

}
