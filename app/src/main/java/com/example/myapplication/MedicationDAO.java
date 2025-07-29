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
        public void addMedication(Medication medication);
        @Update
        public void updateFood(Medication medication);
        @Delete
        public void deleteFood(Medication medication);
        @Query("select * from medication")
        public List<Food> getAllMedication();

        @Query("select * from medication where medID = medID")
        public Food getFoodName(int medID);


}
