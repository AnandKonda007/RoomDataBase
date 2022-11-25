package com.example.roomdatabase.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.MainActivity2;
import com.example.roomdatabase.Model.StudentFamilyDetails;
import com.example.roomdatabase.R;

import java.util.List;

public class StudentFamilyDetailsAdapter extends RecyclerView.Adapter<StudentFamilyDetailsAdapter.ViewHolder> {
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

    }

    @Override
    public int getItemCount() {
        return studentFamilyDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, fathername, mothername, phonenumber;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name2);
            fathername = itemView.findViewById(R.id.father_Name2);
            mothername = itemView.findViewById(R.id.motherName2);
            phonenumber = itemView.findViewById(R.id.phone_number2);
        }
    }
}
