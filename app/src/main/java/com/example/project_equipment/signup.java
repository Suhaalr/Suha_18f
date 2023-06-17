package com.example.project_equipment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class signup extends AppCompatActivity {


    private EditText SREmail, SRPassword, NameSu;
    private Button SRButton;

    FirebaseAuth auth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        NameSu = findViewById(R.id.editText);
        SREmail = findViewById(R.id.F18s013);
        SRButton = findViewById(R.id.Suhabutton);
        SRPassword = findViewById(R.id.Text18f);

        auth = FirebaseAuth.getInstance();

        SRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=SREmail.getText().toString().trim();
                String pass=SRPassword.getText().toString().trim();


                if (email.isEmpty()) {
                    SREmail.setError("Email must be typed");
                }
                if (pass.isEmpty()) {
                    SRPassword.setError("password must be typed");
                }else {
                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()){
                             Toast.makeText(signup.this, "signup correct", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(signup.this,Login.class));
                         }else {
                             Toast.makeText(signup.this, "signup mistake"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                         }
                        }
                    });
                }


            }
        });

    }
}










