package com.example.covidtracking2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Creadores_A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creadores_);
    }
    public  void  volver(View v){
        Intent i=new Intent(Creadores_A.this, WellcomeUser.class);
        startActivity(i);
    }
}