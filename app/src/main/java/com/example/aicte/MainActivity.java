package com.example.aicte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
private Button login ;
TextView email ;
TextView password ;
FirebaseAuth auth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.button);
        email = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPersonName2);
        auth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   startActivity(new Intent(MainActivity.this,studentlist.class));
                String txt_email = email.getText().toString();
                String txt_pass = password.getText().toString();
              //  loginuser(txt_email,txt_pass);

                auth.signInWithEmailAndPassword(txt_email,txt_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful())
                        if(task.isComplete())
            {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,studentlist.class));

            }else{
                            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

//    private  void loginuser (String txt_email, String txt_pass)
//    { auth.signInWithEmailAndPassword(txt_email, txt_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//        @Override
//        public void onComplete(@NonNull Task<AuthResult> task) {
//
//            //String email = auth.getTenantId();
//            if(task.isSuccessful())
//            {
//                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
//                startActivity(new Intent(MainActivity.this,studentlist.class));
//
//            }
////            else
////            {
////                Toast.makeText(MainActivity.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
////            }
//        }
//    });

  //  }
}