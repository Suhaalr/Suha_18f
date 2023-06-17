package com.example.project_equipment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import com.google.firebase.ktx.Firebase;

public class Login extends AppCompatActivity {
    private EditText emailSU, password_su;
    private Button textView5;
    private TextView forg;
    private FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        auth = FirebaseAuth.getInstance();
        emailSU = findViewById(R.id.emailsu);
        password_su = findViewById(R.id.password_su);
        textView5 = findViewById(R.id.iew5);
        forg = findViewById(R.id.hp);

        initial();
    }

    private void initial() {

        forg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Context packageContext;
                intent.setClass(Login.this, Forget.class);
                startActivity(intent);

            }
        });

        textView5.setOnClickListener(View -> {
            loginuser();
        });
    }

    private void loginuser() {

        String emaisu, passsu;
        emaisu = String.valueOf(emailSU.getText());
        passsu = String.valueOf(password_su.getText());

        if (TextUtils.isEmpty(emaisu)) {
            Toast.makeText(Login.this, "Type your email", Toast.LENGTH_SHORT).show();
            return;
        } else {

        }
        if (TextUtils.isEmpty(passsu)) {
            Toast.makeText(Login.this, "Type your password", Toast.LENGTH_SHORT).show();
            return;
        } else {

            auth.signInWithEmailAndPassword(emaisu, passsu).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        Toast.makeText(Login.this, "Register is correct", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, company.class));
                    } else {
                        Toast.makeText(Login.this, "Register is mistake" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }
}