package com.example.aicte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class studentlist extends AppCompatActivity {
private Button newstd ;
RecyclerView recyclerView;
DatabaseReference databaseReference;
rvadapter rvadapter;
ArrayList<Student> list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist2);
        newstd = findViewById(R.id.button2);

        recyclerView = findViewById(R.id.rvlist);
        databaseReference = FirebaseDatabase.getInstance().getReference("Mentor");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        rvadapter = new rvadapter(this,list);
        recyclerView.setAdapter(rvadapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    Student student = dataSnapshot.getValue(Student.class);
                    list.add(student);
                }
                rvadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        newstd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(studentlist.this,addstudent.class));
            }
        });
    }
}