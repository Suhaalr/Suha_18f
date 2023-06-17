package com.example.project_equipment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile1 extends AppCompatActivity {
    private TextView informatino;
    private Button Equi1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);

        informatino = findViewById(R.id.xt1);
        Equi1 = findViewById(R.id.Equi1);

        initial();
    }

    private void initial() {

        Equi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Context packageContext;
                intent.setClass(Profile1.this, equpment2.class);
                startActivity(intent);

            }
        });

    }
}
