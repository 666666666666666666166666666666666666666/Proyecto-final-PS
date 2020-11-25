package com.example.covidtracking2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class perfilmenu extends Fragment {

  //  String dbnombre,dbapellido,dbanio;
    public String id;
    private Button botonActualizar;
    DatabaseReference mDatabase;//referencia al nodo principal
//WellcomeUser user= new WellcomeUser();

  //  public static final String user = "names";

    String nombre,apellido,categoria,email;
    int anios;
  private   TextView tvNombre, tvCategoria,tvApellido,tvEmail,tvAnio;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

   /* public  void  llenar(String id1){
        id=id1;
    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ve = inflater.inflate(R.layout.fragment_perfilmenu, container, false);
        WellcomeUser wellcom=(WellcomeUser) getActivity();

        id=wellcom.obtenerId();
        tvAnio=ve.findViewById(R.id.txtAños);
        tvApellido=ve.findViewById(R.id.txtApellido);
        tvCategoria=ve.findViewById(R.id.txtTipoUser);
        tvNombre=ve.findViewById(R.id.txtNombre);
        tvEmail=ve.findViewById(R.id.tvUsuario);
        mDatabase= FirebaseDatabase.getInstance().getReference();
        //Toast.makeText(WellcomeUser.this, "Hola", Toast.LENGTH_LONG).show();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    //  String email=snapshot.child("email").getValue().toString();
                   // Toast.makeText(WellcomeUser.this, "Hola", Toast.LENGTH_LONG).show();

                    // if (snapshot.child("estado").equals(true)){
                     nombre=snapshot.child("dbnombre").getValue().toString();
                    apellido=snapshot.child("apellido").getValue().toString();
                    anios=Integer.parseInt( snapshot.child("edad").getValue().toString());
                    categoria=snapshot.child("categoria").getValue().toString();
                    email=snapshot.child("email").getValue().toString();
                    //  Toast.makeText(getActivity(), "Hola "+nombre, Toast.LENGTH_SHORT).show();
                    //}


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        tvCategoria.setText(categoria);
        tvAnio.setText(anios+"");
       tvEmail.setText(email);
        tvApellido.setText(apellido);
        tvNombre.setText(nombre);




        botonActualizar = (Button) ve.findViewById(R.id.btnEditar);
     //   botonActualizar.setVisibility(View.GONE);
        botonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), ActualizarDatos.class);
                startActivityForResult(intent, 0);
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));

            }
        });
      /*  nombre = (EditText) ve.findViewById(R.id.tvNombre);
        apellido = (EditText) ve.findViewById(R.id.tvApellido);
        //edad = (TextView) ve.findViewById(R.id.tvEdad);
        edid = (Button) ve.findViewById(R.id.btnEditar);
        TextEmail = (EditText) ve.findViewById(R.id.editemail);
        TextPassword = (EditText) ve.findViewById(R.id.editTextPassword);
*/



/*
        edid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dbnombre = nombre.getText().toString();
                dbapellido = apellido.getText().toString();
                String password = TextPassword.getText().toString().trim();
                final String email = TextEmail.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {//(precio.equals(""))

                    System.out.println("Error no se pudo editar tados");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    System.out.println("Falta ingresar la contrase");

                    return;
                } else {


                    //loguear usuario
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //checking if success
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (task.isSuccessful()) {

                                        Map<String, Object> map = new HashMap<>();
                                        map.put("dbnombre", dbnombre);
                                        map.put("apellido", dbapellido);
                                        ;


                                        String id = mAuth.getCurrentUser().getUid();
                                        //se esta creando una tabla
                                        mDatabase.child("Users").updateChildren(map);
                                    }
                                }
                     }
                }
            }
        });
                   */

        return ve;
    }

}