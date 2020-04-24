package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myfirstapp.adapters.DietAdapter;

import java.util.ArrayList;

public class DietActivity extends AppCompatActivity{


    private RecyclerView recyclerView;
    private DietAdapter adapter;
    private ArrayList<Diet> dietList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_main);
        recyclerView = (RecyclerView) findViewById(R.id.diet_rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dietList = new ArrayList<>();
        adapter = new DietAdapter(this, dietList);
        recyclerView.setAdapter(adapter);
        createListData();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Diet Recommendations");

    }

    private void createListData() {
        Diet diet = new Diet("Mediterranean Diet", "Lip ipsom loret");
        dietList.add(diet);
        Diet diet2 = new Diet("Ketogenic Diet", "Lip ipsom loret");
        dietList.add(diet2);
        diet = new Diet("Paleo Diet", "Lip ipsom loret");
        dietList.add(diet);
        diet = new Diet("Vegan Diet", "Lip ipsom loret");
        dietList.add(diet);
        adapter.notifyDataSetChanged();
    }


}
