package com.example.roomdatabase;

import static com.example.roomdatabase.Database.DataCommon.Db_Name;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomdatabase.Adapter.StudentFamilyDetailsAdapter;
import com.example.roomdatabase.Database.DataBase;
import com.example.roomdatabase.Database.DetailsDao;
import com.example.roomdatabase.Model.StudentFamilyDetails;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class Home extends AppCompatActivity {
    DataBase dataBase;
    DetailsDao detailsDao;
    List<StudentFamilyDetails> studentFamilyDetails;
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        actions();

    }

    private void actions() {
        dataBase = Room.databaseBuilder(this, DataBase.class, Db_Name).allowMainThreadQueries().build();
        detailsDao = dataBase.detailsDao();
        studentFamilyDetails = detailsDao.fetchAllStudentDetails();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(Home.this));
        if (studentFamilyDetails.size() > 0) {
            StudentFamilyDetailsAdapter studentFamilyDetailsAdapter = new StudentFamilyDetailsAdapter(Home.this, studentFamilyDetails);
            recyclerView.setAdapter(studentFamilyDetailsAdapter);
        }
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Home.this,MainActivity.class));
    }
}