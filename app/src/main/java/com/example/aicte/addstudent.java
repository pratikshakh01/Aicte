package com.example.aicte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addstudent extends AppCompatActivity {
private Button addstd ;
private TextView Name;
private TextView Usn;
private TextView Branch;
//private TextView Sec;
Button exit ;
FirebaseDatabase firebaseDatabase;
DatabaseReference reference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);
        
        addstd = findViewById(R.id.button3);
        Name = findViewById(R.id.editTextTextPersonName3);
        Usn = findViewById(R.id.editTextTextPersonName4);
        Branch = findViewById(R.id.editTextTextPersonName5);
        //Sec = findViewById(R.id.editTextTextPersonName6);
        exit= findViewById(R.id.button4);

        addstd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_name = Name.getText().toString();
                String get_usn = Usn.getText().toString();
                String get_branch = Branch.getText().toString();
                String get_remarks = "";
                String get_point="0";

                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference().child("Mentor");

                Student student= new Student(get_name,get_usn,get_branch,get_point,get_remarks);
                reference.child(get_usn).setValue(student);


                Toast.makeText(addstudent.this, "Data Uploaded Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(addstudent.this,studentlist.class));
            }
        });
    }
}