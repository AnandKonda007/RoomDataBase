package com.example.roomdatabase.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.Model.StudentFamilyDetails;

@Database(entities = {StudentFamilyDetails.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {
    public abstract DetailsDao detailsDao();


}
