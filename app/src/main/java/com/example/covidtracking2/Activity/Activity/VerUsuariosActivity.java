package com.example.covidtracking2.Activity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.covidtracking2.Entidades.Firebase.Firebase.Usuario;
import com.example.covidtracking2.Entidades.Logica.Logica.LUsuario;
import com.example.covidtracking2.Holder.Holder.UsuarioViewHolder;
import com.example.covidtracking2.R;
import com.example.covidtracking2.Utilidades.Constantes;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class VerUsuariosActivity extends AppCompatActivity {

    private RecyclerView rvUsuarios;
    private FirebaseRecyclerAdapter adapter;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuarios);

        rvUsuarios = findViewById(R.id.rvUsuarios);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvUsuarios.setLayoutManager(linearLayoutManager);

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child(Constantes.NODO_USUARIOS);

        FirebaseRecyclerOptions<Usuario> options =
                new FirebaseRecyclerOptions.Builder<Usuario>()
                        .setQuery(query, Usuario.class)
                        .build();

        adapter = new FirebaseRecyclerAdapter<Usuario,UsuarioViewHolder>(options) {
            @Override
            public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_usuario, parent, false);
                return new UsuarioViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(UsuarioViewHolder holder, int position, final Usuario model) {
                Glide.with(com.example.covidtracking2.Activity.Activity.VerUsuariosActivity.this).load(model.getFotoPerfilURL()).into(holder.getCivFotoPerfil());
                holder.getTxtNombreUsuario().setText(model.getNombre());

                final LUsuario lUsuario = new LUsuario(getSnapshots().getSnapshot(position).getKey(),model);

                holder.getLayoutPrincipal().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(com.example.covidtracking2.Activity.Activity.VerUsuariosActivity.this,MensajeriaActivity.class);
                        intent.putExtra("key_receptor",lUsuario.getKey());
                        startActivity(intent);
                    }
                });

            }
        };
        rvUsuarios.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}
