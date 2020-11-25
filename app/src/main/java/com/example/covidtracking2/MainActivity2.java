package com.example.covidtracking2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    Button btn1, btn2,btn3,btn4;
    TextView txt1;
    MediaPlayer info1,info2,info3,info4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        txt1=findViewById(R.id.textView1);
        txt1.setText("Aca le brindamos la informacion proporcionada por entidades oficiales de la OMS");
        info1= MediaPlayer.create(com.example.covidtracking2.MainActivity2.this,R.raw.info1);
        info2= MediaPlayer.create(com.example.covidtracking2.MainActivity2.this,R.raw.info2);
        info3= MediaPlayer.create(com.example.covidtracking2.MainActivity2.this,R.raw.info3);
        info4= MediaPlayer.create(com.example.covidtracking2.MainActivity2.this,R.raw.info4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info1.isPlaying())
                    info1.pause();
                else
                    info1.start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info2.isPlaying())
                    info2.pause();
                else
                    info2.start();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info3.isPlaying())
                    info3.pause();
                else
                    info3.start();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info4.isPlaying())
                    info4.pause();
                else
                    info4.start();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        try{
            if(info1.isPlaying())
                info1.stop();
            if(info2.isPlaying())
                info2.stop();
            if(info3.isPlaying())
                info3.stop();
            if(info4.isPlaying())
                info4.stop();
        }
        catch (Exception ex){}
    }
}