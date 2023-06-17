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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class Forget extends AppCompatActivity {
    private EditText write;
    private Button forSPassword;
    private FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);


        auth = FirebaseAuth.getInstance();
        write = findViewById(R.id.user_name);
        forSPassword = findViewById(R.id.buon3);

        forSPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email;
                Email = String.valueOf(write.getText());

                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(Forget.this, "Type your email", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Forget.this, "check your email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Forget.this, Login.class));
                            finish();
                        } else {
                            Toast.makeText(Forget.this, "Error :" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}