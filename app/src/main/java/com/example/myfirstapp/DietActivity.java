package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.myfirstapp.adapters.DietAdapter;

import java.util.ArrayList;

public class DietActivity extends AppCompatActivity{


    private RecyclerView recyclerView;
    private DietAdapter adapter;
    private ArrayList<Diet> dietList;

    private TextView link;

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

        link = (TextView) findViewById(R.id.dietaryLM);
        link.setMovementMethod(LinkMovementMethod.getInstance());

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Diet Recommendations");

    }

    private void createListData() {
        Diet diet = new Diet("Mediterranean Diet", "It is a diet inspired by the eating habits of Italians and Greeks in the 1960s. The diet primarily consists of olive oil, legumes, fruits, vegetables and often times fish. It is one of three diets recommended by the 2015-2020 US Dietary Guidelines.", "<a href=\"https://en.wikipedia.org/wiki/Mediterranean_diet\">Learn More</a>");
        dietList.add(diet);
        diet = new Diet("Vegetarian Diet", "It is a diet that excludes meats of any kind. There are many variations to Vegetarianism, such as Ovo and Veganism. It is one of three diets recommended by the 2015-2020 US Dietary Guidelines.","<a href=\"https://en.wikipedia.org/wiki/Vegetarianism\">Learn More</a>");
        dietList.add(diet);
        diet = new Diet("DASH Diet", "It is a diet primarily aimed to target people with hypertension, however, it is recommended to the general public as well. This diet is promoted by various institutions such as NHLBI, USDA, and AHA. It is one of three diets recommended by the 2015-2020 US Dietary Guidelines.", "<a href=\"https://en.wikipedia.org/wiki/DASH_diet\">Learn More</a>");
        dietList.add(diet);
        diet = new Diet("Ketogenic Diet", "It is a diet that consists of high-fat, moderate protein, and low carbs. This diet enables easier burning of fat, leading to weight loss. This diet has shown to treat epilepsy in children.", "<a href=\"https://en.wikipedia.org/wiki/Ketogenic_diet\">Learn More</a>");
        dietList.add(diet);
        adapter.notifyDataSetChanged();
    }


}
