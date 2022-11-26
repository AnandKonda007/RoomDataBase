package com.example.roomdatabase.Adapter;

import static com.example.roomdatabase.Database.DataCommon.Db_Name;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.roomdatabase.Database.DataBase;
import com.example.roomdatabase.Database.DetailsDao;
import com.example.roomdatabase.MainActivity;
import com.example.roomdatabase.MainActivity2;
import com.example.roomdatabase.Model.StudentFamilyDetails;
import com.example.roomdatabase.R;
import com.example.roomdatabase.UpdateDetails;

import java.util.List;

public class StudentFamilyDetailsAdapter extends RecyclerView.Adapter<StudentFamilyDetailsAdapter.ViewHolder> {
    DataBase dataBase;
    DetailsDao detailsDao;
    List<StudentFamilyDetails> studentFamilyDetails;
    Context context;

    public StudentFamilyDetailsAdapter(MainActivity2 mainActivity2, List<StudentFamilyDetails> studentFamilyDetails) {
        this.studentFamilyDetails = studentFamilyDetails;
        this.context = mainActivity2;


    }


    @Override
    public StudentFamilyDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.studentfamilydetails, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(studentFamilyDetails.get(position).getName());
        holder.fathername.setText(studentFamilyDetails.get(position).getFatherName());
        holder.mothername.setText(studentFamilyDetails.get(position).getMotherName());
        holder.phonenumber.setText(studentFamilyDetails.get(position).getPhoneNumber());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(new Intent(holder.edit.getContext(),UpdateDetails.class));
                intent.putExtra("id",String.valueOf(studentFamilyDetails.get(position).getId()));
                intent.putExtra("name",studentFamilyDetails.get(position).getName());
                intent.putExtra("fathername",studentFamilyDetails.get(position).getFatherName());
                intent.putExtra("mothername",studentFamilyDetails.get(position).getMotherName());
                intent.putExtra("phoneno",studentFamilyDetails.get(position).getPhoneNumber());
                holder.edit.getContext().startActivity(intent);


            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(context)
                        .setTitle("Delete User")
                        .setMessage("Are you sure to delete this user?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataBase = Room.databaseBuilder(holder.name.getContext(), DataBase.class, Db_Name).allowMainThreadQueries().build();
                                detailsDao = dataBase.detailsDao();
                                detailsDao.deleteDetails(studentFamilyDetails.remove(position));
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .create();
                dialog.setCancelable(false);
                dialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return studentFamilyDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, fathername, mothername, phonenumber;
        Button edit, delete;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.student_Name2);
            fathername = itemView.findViewById(R.id.father_Name2);
            mothername = itemView.findViewById(R.id.mother_Name2);
            phonenumber = itemView.findViewById(R.id.phone_number2);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);
        }
    }

}
