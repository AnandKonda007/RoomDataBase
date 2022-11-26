package com.example.roomdatabase;

import static com.example.roomdatabase.Database.DataCommon.Db_Name;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabase.Database.DataBase;
import com.example.roomdatabase.Database.DetailsDao;

public class UpdateDetails extends AppCompatActivity {
    int id;
    EditText name, fathername, mothername, phonenumber;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);
        actions();

    }

    private void actions() {
        name = findViewById(R.id.student_Name3);
        fathername = findViewById(R.id.father_Name3);
        mothername = findViewById(R.id.mother_Name3);
        phonenumber = findViewById(R.id.phone_number3);
        update = findViewById(R.id.update);

        id=Integer.parseInt(getIntent().getStringExtra("id"));
        name.setText(getIntent().getStringExtra("name"));
        fathername.setText(getIntent().getStringExtra("fathername"));
        mothername.setText(getIntent().getStringExtra("mothername"));
        phonenumber.setText(getIntent().getStringExtra("phoneno"));
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase dataBase = Room.databaseBuilder(getApplicationContext(), DataBase.class, Db_Name).allowMainThreadQueries().build();
                 DetailsDao detailsDao = dataBase.detailsDao();
                detailsDao.updateDetails(id,name.getText().toString(),fathername.getText().toString(),mothername.getText().toString(),phonenumber.getText().toString());
                startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                finish();
            }
        });

    }
}