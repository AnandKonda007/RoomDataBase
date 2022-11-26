package com.example.roomdatabase;

import static com.example.roomdatabase.Database.DataCommon.Db_Name;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.example.roomdatabase.Adapter.StudentFamilyDetailsAdapter;
import com.example.roomdatabase.Database.DataBase;
import com.example.roomdatabase.Database.DetailsDao;
import com.example.roomdatabase.Model.StudentFamilyDetails;

import java.util.List;


public class MainActivity2 extends AppCompatActivity {
    DataBase dataBase;
    DetailsDao detailsDao;
    List<StudentFamilyDetails> studentFamilyDetails;
    RecyclerView recyclerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        actions();

    }

    private void actions() {
        dataBase = Room.databaseBuilder(this, DataBase.class, Db_Name).allowMainThreadQueries().build();
        detailsDao = dataBase.detailsDao();
        studentFamilyDetails = detailsDao.fetchAllStudentDetails();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
        if (studentFamilyDetails.size() > 0) {
            StudentFamilyDetailsAdapter studentFamilyDetailsAdapter = new StudentFamilyDetailsAdapter(MainActivity2.this, studentFamilyDetails);
            recyclerView.setAdapter(studentFamilyDetailsAdapter);
        }
    }
}