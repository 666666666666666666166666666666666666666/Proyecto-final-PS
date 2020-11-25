package com.example.covidtracking2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracking2.Usuario.AdapterSuge;
import com.example.covidtracking2.Usuario.Suge;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VistaSugerencias extends AppCompatActivity {
    RecyclerView rv;
    List<Suge> suge;
    AdapterSuge adapterSuge;
    DatabaseReference mDatabase;//referencia al nodo principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_sugerencias);

        rv=findViewById(R.id.list_sugerencia);
        rv.setLayoutManager(new LinearLayoutManager(this));
        suge=new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        adapterSuge =new AdapterSuge(suge);
        rv.setAdapter(adapterSuge);
        database.getReference().child("Sugerencias").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                suge.removeAll(suge);
                if (snapshot.exists())
                {
                    for (DataSnapshot snap: snapshot.getChildren()){
                        String nombre=snap.child("Descripcion").getValue().toString();
                        String correo=snap.child("Usuario").getValue().toString();
                        correo=correo+"@gmail.com";
                        //Toast.makeText(Admi.this, categoria, Toast.LENGTH_LONG).show();

                                Suge suges=new Suge( correo,   nombre);
                                suge.add(suges);





                    }
                }

                adapterSuge.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}