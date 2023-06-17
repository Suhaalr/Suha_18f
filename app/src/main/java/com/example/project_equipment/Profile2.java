package com.example.project_equipment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile2 extends AppCompatActivity {
    private TextView text;
    private Button Eq2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        text=findViewById(R.id.sxt1);
        Eq2 =findViewById(R.id.Eq2);

        initial();
    }

    private void initial() {

        Eq2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Context packageContext;
                intent.setClass(Profile2.this, equpment.class);
                startActivity(intent);

            }
        });

    }
}



