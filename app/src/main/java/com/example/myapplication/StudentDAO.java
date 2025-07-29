package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface StudentDAO {
        @Insert
        public void addStudent(Student student);
        @Update
        public void updateStudent(Student student);
        @Delete
        public void deleteStudent(Student student);
        @Query("select * from student")
        public List<Student> getAllStudents();

        @Query("select * from student where stuNum==:stuNum")
        public Student getStudent(int stuNum);
}
