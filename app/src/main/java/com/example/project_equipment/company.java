package com.example.project_equipment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class company extends AppCompatActivity implements View.OnClickListener{
    private CardView Company1,Company2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        Company1=(CardView) findViewById(R.id.downlod);
        Company2=(CardView) findViewById(R.id.ssaha) ;


        Company1.setOnClickListener((View.OnClickListener) this );
        Company2.setOnClickListener((View.OnClickListener) this);

    }
    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.downlod: i= new Intent(this,Profile1.class); startActivity(i); break;
            case R.id.ssaha: i= new Intent(this,Profile2.class); startActivity(i); break;
        }
    }
}