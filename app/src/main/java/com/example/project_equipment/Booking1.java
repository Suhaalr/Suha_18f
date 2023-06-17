package com.example.project_equipment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

public class Booking1 extends AppCompatActivity {
    private EditText Semai, Sphon, SName, SEqNa, Sdate;
    private Button bookButton;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking1);

        SName = findViewById(R.id.ttb);
        Semai = findViewById(R.id.edt);
        bookButton = findViewById(R.id.bt5);
        SEqNa = findViewById(R.id.it1);
        Sdate = findViewById(R.id.ed);
        Sphon = findViewById(R.id.T0xt);

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference("Company1");
                String name = SName.getText().toString();
                String EmaiL = Semai.getText().toString();
                String phonenumber = Sphon.getText().toString();
                String Date = Sdate.getText().toString();
                String Equnam = SEqNa.getText().toString();


                booking_information booking_information = new booking_information(name, EmaiL, phonenumber,Equnam , Date);

                reference.child(name).setValue(booking_information);

                Toast.makeText(Booking1.this, "Company1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Booking1.this,ThankYou.class);
                startActivity(intent);
            }
        });
    }
}
