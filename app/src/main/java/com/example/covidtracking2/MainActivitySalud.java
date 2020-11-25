package com.example.covidtracking2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivitySalud extends AppCompatActivity {
 private Button botonInformacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_salud);

                botonInformacion = (Button) findViewById(R.id.notificacion);
        botonInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),MainActivity3ayuda.class);
                startActivityForResult(intent, 0);
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));

            }
        });
    }
}