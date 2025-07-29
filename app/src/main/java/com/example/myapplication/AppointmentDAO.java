package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppointmentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAppointment(Appointment appointment);

    @Query("select * from appointment")
    public List<Appointment> getAllAppointments();

    @Query("select * from appointment where `Appointment Num`= `Appointment Num`")
    public Appointment getAppointmentName(int appointmentNum);





}
