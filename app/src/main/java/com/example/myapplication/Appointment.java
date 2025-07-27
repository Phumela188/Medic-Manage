package com.example.myapplication;


import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "Appointment")
public class Appointment {
    @ColumnInfo(name = "Appointment Num")

    int appointmentNum, stuNum, empNum, foodID;
    String dateTime;

}
