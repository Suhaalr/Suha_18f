package com.example.project_equipment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Booking2 extends AppCompatActivity {
    private EditText REmail1,Rphon1, RName1,REqu1,Rdate1;
    private Button bookbut;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking1);
        reference= FirebaseDatabase.getInstance().getReference( "Name");
        RName1 = findViewById(R.id.ttb);
        REmail1 = findViewById(R.id.editk);
        bookbut = findViewById(R.id.buri);
        REqu1= findViewById(R.id.ex1);
        Rdate1= findViewById(R.id.sit);
        Rphon1=findViewById(R.id.Phon);

        bookbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference("Company2");
                String name = RName1.getText().toString();
                String EmaiL = REmail1.getText().toString();
                String phonenumber = Rphon1.getText().toString();
                String Date = Rdate1.getText().toString();
                String  Equnam = REqu1.getText().toString();


                booking_information booking_information = new booking_information(name, EmaiL,Equnam , phonenumber, Date);

                reference.child(name).setValue(booking_information);

                Toast.makeText(Booking2.this, "Company2", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Booking2.this,ThankYou.class);
                startActivity(intent);
            }
        });
    }
}
