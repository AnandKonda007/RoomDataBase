package com.example.roomdatabase.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StudentFamilyDetails")
public class StudentFamilyDetails {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Name;
    private String FatherName;
    private String MotherName;
    private String PhoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
