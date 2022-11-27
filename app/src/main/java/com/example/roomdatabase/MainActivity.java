package com.example.roomdatabase;
import static com.example.roomdatabase.Database.DataCommon.Db_Name;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.Database.DataBase;
import com.example.roomdatabase.Database.DetailsDao;
import com.example.roomdatabase.Model.StudentFamilyDetails;



public class MainActivity extends AppCompatActivity {
    DataBase dataBase;
    EditText name, fatherName, motherName, phoneNumber;
    Button submit,viewUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actions();

    }

    private void actions() {
        dataBase = Room.databaseBuilder(this, DataBase.class,Db_Name).allowMainThreadQueries().build();
        name = findViewById(R.id.student_Name);
        fatherName = findViewById(R.id.father_Name);
        motherName = findViewById(R.id.mother_Name);
        phoneNumber = findViewById(R.id.phone_number);
        submit = findViewById(R.id.submit);
        viewUsers=findViewById(R.id.viewusers);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()) {
                    name.setError("This Field  is required");
                    Toast.makeText(MainActivity.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                } else if (fatherName.getText().toString().isEmpty()) {
                    fatherName.setError("This Field  is required");
                    Toast.makeText(MainActivity.this, "Please Enter Your Father's Name", Toast.LENGTH_SHORT).show();
                } else if (motherName.getText().toString().isEmpty()) {
                    motherName.setError("This Field  is required");
                    Toast.makeText(MainActivity.this, "Please Enter Your Mother Name", Toast.LENGTH_SHORT).show();
                } else if (phoneNumber.getText().toString().isEmpty()) {
                    phoneNumber.setError("This Field  is required");
                    Toast.makeText(MainActivity.this, "Please Enter Your Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    DetailsDao detailsDao=dataBase.detailsDao();
                    StudentFamilyDetails studentFamilyDetails=new StudentFamilyDetails();
                    studentFamilyDetails.setName(name.getText().toString());
                    studentFamilyDetails.setFatherName(fatherName.getText().toString());
                    studentFamilyDetails.setMotherName(motherName.getText().toString());
                    studentFamilyDetails.setPhoneNumber(phoneNumber.getText().toString());
                    detailsDao.insertDetails(studentFamilyDetails);
                    name.getText().clear();
                    fatherName.getText().clear();
                    motherName.getText().clear();
                    phoneNumber.getText().clear();
                    Toast.makeText(MainActivity.this, "saved Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,MainActivity2.class));




                }
            }
        });
        viewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));

            }
        });

    }
}