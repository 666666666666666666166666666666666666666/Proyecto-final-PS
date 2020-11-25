package com.example.covidtracking2.Activity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import  com.example.covidtracking2.Persistencia.Persistencia.UsuarioDAO;
import  com.example.covidtracking2.R;
import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    private Button btnVerUsuarios;
    private Button btnCerrarSesion;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnVerUsuarios = findViewById(R.id.btnVerUsuarios);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        btnVerUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( com.example.covidtracking2.Activity.Activity.MenuActivity.this,VerUsuariosActivity.class);
                startActivity(intent);
            }
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                returnLogin();
            }
        });

    }

    private void returnLogin(){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(UsuarioDAO.getInstancia().isUsuarioLogeado()){
            //el usuario esta logeado y hacemos algo
        }else{
            returnLogin();
        }
    }

}
