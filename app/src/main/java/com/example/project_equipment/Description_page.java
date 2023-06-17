package com.example.project_equipment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Description_page extends AppCompatActivity {

    TextView descrTitel,descrprice,descr;
    ImageView descimage;
    Button book1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_page);

        descrTitel = findViewById(R.id.descrTitel);
        descrprice = findViewById(R.id.descrprice);
        descr = findViewById(R.id.descr);
        descimage = findViewById(R.id.descimage);
        book1 = findViewById(R.id.book1);

        initial();
    }

    private void initial() {

        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Context packageContext;
                intent.setClass(Description_page.this, Booking1.class);
                startActivity(intent);

            }
        });



    Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            descr.setText(bundle.getString("description"));
            descrTitel.setText(bundle.getString("Titel"));
            descrprice.setText(bundle.getString("price"));
            Glide.with(this).load(bundle.getString("image")).into(descimage);
        }

    }
}