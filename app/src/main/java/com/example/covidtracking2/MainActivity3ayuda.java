package com.example.covidtracking2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.NotificationCompat;

        import android.app.NotificationManager;
        import android.app.PendingIntent;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

public class MainActivity3ayuda extends AppCompatActivity {
    NotificationCompat.Builder notificacion;
    Button btn11;
    static final int id=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3ayuda);
        btn11=findViewById(R.id.button11);
        notificacion=new NotificationCompat.Builder(this);
        notificacion.setAutoCancel(true);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificacion.setSmallIcon(R.drawable.ic_baseline_notifications_24);
                notificacion.setTicker("Actualizacion de la app");
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setContentTitle("CovidTracking");
                notificacion.setContentText("Nuevas funcionalidades");
                Intent intent= new Intent(MainActivity3ayuda.this,MainActivity3ayuda.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity3ayuda.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                notificacion.setContentIntent(pendingIntent);
                NotificationManager mn=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mn.notify(id,notificacion.build());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuiconos,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.itemgeneral:
                Intent c=new Intent(this,MainActivity2.class);
                startActivity(c);
                //Toast.makeText(getApplicationContext(),"presionó el boton",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}