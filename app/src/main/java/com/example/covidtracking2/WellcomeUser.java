package com.example.covidtracking2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class WellcomeUser extends AppCompatActivity implements View.OnClickListener {


    public static final String user = "names";

    TextView txtUser;

    fragmentoAlimentacion fragmentoAlimentacion1;
    fragmentoPrevencion fragmentoPrevencion1;
    //Necesitamos 1 objeto de la clase FragmentManager y 1 objeto de la clase FragmentTransaction


    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayoutt;
    private homemenu option1Fragment;
    private perfilmenu option2Fragment;
    private settingsmenu option3Fragment;
    private DatabaseReference mDatabase;

    private String id;
    private String  tipoUsuario;
    //Necesitamos 1 objeto de la clase FragmentManager y 1 objeto de la clase FragmentTransaction
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome_user);
        option1Fragment = new homemenu();
        option2Fragment = new perfilmenu();
        option3Fragment = new settingsmenu();
        Bundle extras = getIntent().getExtras();
        id= extras.getString("dato01");
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayoutt = findViewById(R.id.frameLayoutt);
        mDatabase= FirebaseDatabase.getInstance().getReference();
        ///final Usuarios user=new Usuarios();
        //Toast.makeText(WellcomeUser.this, "Hola", Toast.LENGTH_LONG).show();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               if (snapshot.exists()){
                 //  String email=snapshot.child("email").getValue().toString();
                 //  Toast.makeText(WellcomeUser.this, "Hola", Toast.LENGTH_LONG).show();

                      // if (snapshot.child("estado").equals(true)){
                        //   String nombre=snapshot.child("dbnombre").getValue().toString();
                           tipoUsuario=snapshot.child("categoria").getValue().toString();
                 //  Toast.makeText(WellcomeUser.this, ""+tipoUsuario, Toast.LENGTH_LONG).show();
                //   Toast.makeText(WellcomeUser.this, ""+nombre, Toast.LENGTH_LONG).show();

                       //}
                //  user.setIdCuenta(id);

               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        setFragment(option1Fragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);

                        setFragment(option1Fragment);
                        return true;
                    case R.id.menu_profile:
                        //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(option2Fragment);
                        return true;
                    case R.id.menu_settings:
                        // bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(option3Fragment);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }
    public String obtenerId()
    {
        return id;
    }
    public  String obtenerCategoria(){
        return tipoUsuario;
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTrasaction = getSupportFragmentManager().beginTransaction();
        fragmentTrasaction.replace(R.id.frameLayoutt, fragment);
        fragmentTrasaction.commit();
    }




    @Override
    public void onClick(View view1) {
        switch (view1.getId()) {
            /*
            case R.id.btnAlimentacion:
                //  getSupportFragmentManager().beginTransaction().remove(fragmentoPrevencion1).commit();
                fragmentoAlimentacion1 = new fragmentoAlimentacion();
                fragmentoAlimentacion1.setArguments(getIntent().getExtras());
                //Manager:
                fragmentManager = getSupportFragmentManager();
                //Transaccion:
                fragmentTransaction = fragmentManager.beginTransaction();
                //Hay que especificar el layout donde se va a cargar el Fragmento
                fragmentTransaction.add(R.id.linear_layout_principal, fragmentoAlimentacion1);
                fragmentTransaction.commit();

                break;
            case R.id.btnPrevencion123:
                getSupportFragmentManager().beginTransaction().remove(fragmentoAlimentacion1).commit();
                fragmentoPrevencion1 = new fragmentoPrevencion();
                fragmentoPrevencion1.setArguments(getIntent().getExtras());
                //Manager:
                fragmentManager = getSupportFragmentManager();
                //Transaccion:
                fragmentTransaction = fragmentManager.beginTransaction();
                //Hay que especificar el layout donde se va a cargar el Fragmento
                fragmentTransaction.add(R.id.linear_layout_principal, fragmentoPrevencion1);
                fragmentTransaction.commit();
                break;
        }*/


        }
    }
}

