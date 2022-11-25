package com.example.roomdatabase.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabase.Model.StudentFamilyDetails;

import java.util.List;

@Dao
public interface DetailsDao {
    @Insert
    void insertDetais(StudentFamilyDetails studentFamilyDetails);

    @Query("SELECT * from StudentFamilyDetails")
    List<StudentFamilyDetails> fetchAllStudentDetails();




}
