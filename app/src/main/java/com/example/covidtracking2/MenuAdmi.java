package com.example.covidtracking2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuAdmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admi);
    }
    public  void vistaSuge(View vi){
        Intent i = new Intent(MenuAdmi.this, VistaSugerencias.class);
        startActivity(i);
    }
    public  void ListaMedico(View v){
        Intent i = new Intent(MenuAdmi.this, Admi.class);
        startActivity(i);
    }
    public  void volver(View v){
        startActivity(new Intent(MenuAdmi.this, WellcomeUser.class));
    }
}