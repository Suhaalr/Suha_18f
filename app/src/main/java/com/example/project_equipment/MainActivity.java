package com.example.project_equipment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button Get,log,loAdm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Get = findViewById(R.id.Suha);
        log = findViewById(R.id.Sulog);
        loAdm=findViewById(R.id.SoAdmin);

        initial();

    }

    private void initial() {

        Get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Context packageContext;
                intent.setClass(MainActivity.this,Login.class);
                startActivity(intent);

            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Context packageContext;
                intent.setClass(MainActivity.this, signup.class);
                startActivity(intent);

            }
        });

        loAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Context packageContext;
                intent.setClass(MainActivity.this, LoginAdmin.class);
                startActivity(intent);

            }
        });

    }
}



