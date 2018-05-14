package dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import pets.Pet;

@Dao
public interface IPetDAO {

    @Insert
    void insertPet(Pet... student);
    @Update
    void updatePet(Pet... student);
    @Delete
    void deletePet(Pet... student);
    @Query("SELECT * FROM Pet")
    List<Pet> loadAllPets();

}
