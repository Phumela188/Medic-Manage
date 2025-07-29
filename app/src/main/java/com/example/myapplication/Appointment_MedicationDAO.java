package com.example.myapplication;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

public interface Appointment_MedicationDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Appointment_Medication appointmentMedication);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAll(List<Appointment_Medication> entries);

    @Query("select * from `appointment medication` where appointmentNum = appointmentNum")
    public List<Appointment_Medication> getMedicationForAppointment(int appointmentNum);
}
