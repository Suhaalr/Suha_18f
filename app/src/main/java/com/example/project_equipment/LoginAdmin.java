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

public class LoginAdmin extends AppCompatActivity {
    private EditText nameadmin, pad2;
    private Button button1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        nameadmin = findViewById(R.id.nameadmin);
        pad2 = findViewById(R.id.pad2);
        button1 = findViewById(R.id.button1);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (nameadmin.getText().toString().equals("admin") && pad2.getText().toString().equals("4545")) {
                    Toast.makeText(LoginAdmin.this, "Login Admin is successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginAdmin.this,company.class));
                } else {
                    Toast.makeText(LoginAdmin.this, "Login Admin failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}