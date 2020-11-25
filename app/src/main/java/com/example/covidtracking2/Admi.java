package com.example.covidtracking2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracking2.Usuario.Adapter;
import com.example.covidtracking2.Usuario.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Admi extends AppCompatActivity {
    RecyclerView rv;
    List<Usuarios>usuarios;
    Adapter adapter;
    EditText etemail;
    private String id;
  //  private String nombre1,correo1,categoria1, habilitar1,anioTitulacion1,apellido1,ci1,codigoDr1,edad1,estado1,nombreUniversidad1,password1;

    DatabaseReference mDatabase;//referencia al nodo principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admi);
        rv=findViewById(R.id.recicler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        usuarios =new ArrayList<>();
        etemail=findViewById(R.id.editTextTextPersonName);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase database= FirebaseDatabase.getInstance();

        adapter =new Adapter(usuarios);
        rv.setAdapter(adapter);
        database.getReference().child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                usuarios.removeAll(usuarios);
                if (snapshot.exists())
                {
                    for (DataSnapshot snap: snapshot.getChildren()){
                        String nombre=snap.child("dbnombre").getValue().toString();
                        String correo=snap.child("email").getValue().toString();
                        //    int codigoDr=Integer.parseInt( snap.child("codigoDr").toString());
                        String categoria=snap.child("categoria").getValue().toString().trim();
                        Toast.makeText(Admi.this, categoria, Toast.LENGTH_LONG).show();
                        if(categoria.equals("Medico")){
                            String habilitar=snap.child("habilitado").getValue().toString();
                            if(habilitar=="false"){
                                Usuarios usuario=new Usuarios( correo,   nombre);
                                usuarios.add(usuario);
                            }
                        }




                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



    public  void  Actualizar(View v){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        id=etemail.getText().toString();
        String id1;
        String []todo=id.split("@");
        id1=todo[0];



        mDatabase.child("Users").child(id1).child("habilitado").setValue(true).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task2) {
                if (task2.isSuccessful()) {

                //    startActivity(new Intent(Admi.this, Admi.class));

                } else {
                    Toast.makeText(Admi.this, "No se purieron crear los Datos correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public  void volver(View v){
        startActivity(new Intent(Admi.this, MenuAdmi.class));
    }
}