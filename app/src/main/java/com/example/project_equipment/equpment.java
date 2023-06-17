package com.example.project_equipment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class equpment extends AppCompatActivity {
    RecyclerView recyview;
    List<EqupmClass> list;
    DatabaseReference databaseReference;

    ValueEventListener eventListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equpment);

        recyview = findViewById(R.id.recyview);



        GridLayoutManager gridLayoutManager = new GridLayoutManager(equpment.this,1);
        recyview.setLayoutManager(gridLayoutManager);

        list = new ArrayList<>();
        MyAdapte adapte = new MyAdapte(equpment.this,list);
        recyview.setAdapter(adapte);

        databaseReference = FirebaseDatabase.getInstance().getReference("Equipment");

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot itemSnapshot:snapshot.getChildren()){
                    EqupmClass equpmClass = itemSnapshot.getValue(EqupmClass.class);
                    list.add(equpmClass);
                }
                adapte.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}