package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface MedicationDAO {

        @Insert
        void addMedication(Medication medication);
        @Update
        void updateFood(Medication medication);
        @Delete
        void deleteFood(Medication medication);
        @Query("select * from medication")
        List<Food> getAllMedication();

        @Query("select * from medication where medID = medID")
        Food getFoodName(int medID);


}
