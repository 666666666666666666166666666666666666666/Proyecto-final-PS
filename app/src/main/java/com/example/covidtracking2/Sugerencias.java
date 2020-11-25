package com.example.covidtracking2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Sugerencias extends AppCompatActivity {
    private String id;
    EditText descripcion;
    DatabaseReference mRootReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias);
        mRootReference= FirebaseDatabase.getInstance().getReference();
        descripcion=findViewById(R.id.editTextlastName2);
        WellcomeUser wellcom= new WellcomeUser();

    }
    public  void  enviarSugenrencia(View view)
    {
        Bundle extras = getIntent().getExtras();
        id= extras.getString("n");
        String des=descripcion.getText().toString();
        Map<String,Object> datos=new HashMap<>();
        datos.put("Descripcion", des);
        datos.put("Usuario", id);
        Toast.makeText(this,  id, Toast.LENGTH_LONG).show();
        mRootReference.child("Sugerencias").push().setValue(datos);
        //Toast.makeText(this, "Gracias por la sugerencia ", Toast.LENGTH_LONG).show();
        descripcion.setText("");
       /* Intent i=new Intent(Sugerencias.this, WellcomeUser.class);
        startActivity(i);*/
        finish();
    }
}