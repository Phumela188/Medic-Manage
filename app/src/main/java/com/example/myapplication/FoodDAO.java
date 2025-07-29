package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

import java.util.List;
@Dao
public interface FoodDAO {

        @Insert
        public void addFood(Food food);
        @Update
        public void updateFood(Food food );
        @Delete
        public void deleteFood(Food food);
        @Query("select * from food")
        public List<Food> getAllFood();

        @Query("select * from food where foodID = foodID")
        public Food getFoodName(int foodID);

    }


