package com.example.roomdatabase.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase.Model.StudentFamilyDetails;

import java.util.List;

@Dao
public interface DetailsDao {


    @Insert
    void insertDetails(StudentFamilyDetails studentFamilyDetails);

    @Delete
    void deleteDetails(StudentFamilyDetails studentFamilyDetails);

    @Update
    void updateDetails(StudentFamilyDetails studentFamilyDetails);



    @Query("SELECT * from StudentFamilyDetails")
    List<StudentFamilyDetails> fetchAllStudentDetails();


}
