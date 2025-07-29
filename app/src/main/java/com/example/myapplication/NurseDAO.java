package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface NurseDAO {
    @Insert
    public void addNurse(Nurse nurse);
    @Update
    public void updatePerson(Nurse nurse);
    @Delete
    public void deletePerson(Nurse nurse);
    @Query("select * from nurse")
    public List<Nurse> getAllNurses();

    @Query("select * from nurse where empNum==:empNum")
    public Nurse getNurse(int empNum);

}
