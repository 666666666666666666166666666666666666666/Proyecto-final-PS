package com.example.covidtracking2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ActualizarDatos extends AppCompatActivity {
EditText etNombre,etApellido,etAnio,etCorreo;
  private   String dbanioTitulacion,dbCategoria,dbci,dbemail,dbpassword,dbcodigoDr,dbnombreUniversidad,dbestado,dbactivo;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos);
        etApellido=findViewById(R.id.txtAcApellido);
        etNombre=findViewById(R.id.txtAcNombre);
        etAnio=findViewById(R.id.txtAcAnio);
        etCorreo=findViewById(R.id.txtAcCorreo);
        mDatabase = FirebaseDatabase.getInstance().getReference();



    }
    public void actualizarDatos(View v){
        String id;
        String dbCorreo=etCorreo.getText().toString();
        String []todo=dbCorreo.split("@");
        id=todo[0];

     /*   mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    //  String email=snapshot.child("email").getValue().toString();
                    // Toast.makeText(WellcomeUser.this, "Hola", Toast.LENGTH_LONG).show();

                    // if (snapshot.child("estado").equals(true)){


                    dbCategoria=snapshot.child("categoria").getValue().toString();
                    dbcodigoDr=snapshot.child("codigoDr").getValue().toString();
                    dbanioTitulacion=snapshot.child("anioTitulacion").getValue().toString();
                    dbemail=snapshot.child("email").getValue().toString();
                    dbactivo=snapshot.child("estado").getValue().toString();
                    dbestado=snapshot.child("habilitado").getValue().toString();
                    dbci=snapshot.child("ci").getValue().toString();
                    dbpassword=snapshot.child("password").getValue().toString();
                    dbnombreUniversidad=snapshot.child("nombreUniversidad").getValue().toString();
                    //  Toast.makeText(getActivity(), "Hola "+nombre, Toast.LENGTH_SHORT).show();
                    //}


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
        String dbnombre=etNombre.getText().toString();
        String dbapellido=etApellido.getText().toString();
        String dbanio=etAnio.getText().toString();

        String categoria="Medico";



        Map<String, Object> map = new HashMap<>();

        map.put("dbnombre", dbnombre);
        map.put("apellido", dbapellido);
        map.put("edad", dbanio);
        map.put("ci", dbci);
        map.put("email", dbCorreo);
       /* map.put("password", dbpassword);
        map.put("codigoDr", dbcodigoDr);
        map.put("anioTitulacion", dbanioTitulacion);
        map.put("nombreUniversidad", dbnombreUniversidad);*/
        map.put("categoria", categoria);
      /*  map.put("habilitado", dbactivo);
        map.put("estado", dbestado);*/

        mDatabase.child("Users").child(id).child("dbnombre").setValue(dbnombre).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task2) {
                if (task2.isSuccessful()) {


                  //  startActivity(new Intent(ActualizarDatos.this, WellcomeUser.class));
                   // finish();

                } else {
                    Toast.makeText(ActualizarDatos.this, "No se purieron actualizar los Datos correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mDatabase.child("Users").child(id).child("apellido").setValue(dbapellido).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task2) {
                if (task2.isSuccessful()) {


                    //  startActivity(new Intent(ActualizarDatos.this, WellcomeUser.class));
                    // finish();

                } else {
                    Toast.makeText(ActualizarDatos.this, "No se purieron actualizar los Datos correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mDatabase.child("Users").child(id).child("ci").setValue(dbci).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task2) {
                if (task2.isSuccessful()) {


                    //  startActivity(new Intent(ActualizarDatos.this, WellcomeUser.class));
                    // finish();

                } else {
                    Toast.makeText(ActualizarDatos.this, "No se purieron actualizar los Datos correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mDatabase.child("Users").child(id).child("dbnombre").setValue(dbnombre).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task2) {
                if (task2.isSuccessful()) {


                    //  startActivity(new Intent(ActualizarDatos.this, WellcomeUser.class));
                    // finish();

                } else {
                    Toast.makeText(ActualizarDatos.this, "No se purieron actualizar los Datos correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mDatabase.child("Users").child(id).child("dbnombre").setValue(dbnombre).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task2) {
                if (task2.isSuccessful()) {


                     startActivity(new Intent(ActualizarDatos.this, WellcomeUser.class));
                    // finish();

                } else {
                    Toast.makeText(ActualizarDatos.this, "No se purieron actualizar los Datos correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}