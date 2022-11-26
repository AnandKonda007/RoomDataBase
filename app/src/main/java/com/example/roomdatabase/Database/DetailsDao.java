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


    @Query("Update Studentfamilydetails SET Name=:name,FatherName=:fathername,MotherName=:mothername,PhoneNumber=:phoneno WHERE id=:id")
    void updateDetails(int id,String name,String fathername,String mothername,String phoneno);




    @Query("SELECT * from StudentFamilyDetails")
    List<StudentFamilyDetails> fetchAllStudentDetails();


}
