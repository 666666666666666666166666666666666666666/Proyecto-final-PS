package com.example.covidtracking2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class NotEvallisActivity extends AppCompatActivity {
List<ListElement> elementList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_evallis);
        init();
    }

    private void init() {
        elementList=new ArrayList<>();
        elementList.add(new ListElement("#775447","Juana","30/10/2020","60%"));
        elementList.add(new ListElement("#666786","Pablo","30/10/2020","50%"));
        elementList.add(new ListElement("#009688","Juana","30/10/2020","70%"));
        elementList.add(new ListElement("#775447",(getIntent().getStringExtra("nombre")),"25/11/2020",(getIntent().getStringExtra("porcentage"))));

        ListAdapter listAdaptador=new ListAdapter(elementList,this);
        RecyclerView recyclerView=findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdaptador);
    }
}