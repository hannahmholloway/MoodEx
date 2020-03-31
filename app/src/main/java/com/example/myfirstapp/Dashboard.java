package com.example.myfirstapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.myfirstapp.R;

import com.example.myfirstapp.activitiesmoodstate.MainActivity;
import com.example.myfirstapp.calorietracker.CalorieActivity;
import com.example.myfirstapp.watertracker.HydrationTrackerActivity;


public class Dashboard extends AppCompatActivity {

    private Button  button, button4, button2, button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.dashboard);
        clickOnButton();
    }

    private void clickOnButton(){
        button4 = (Button) findViewById(R.id.button4);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

            button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Dashboard.this, HydrationTrackerActivity.class);
                startActivity(it);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Dashboard.this, CalorieActivity.class);
                startActivity(it);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Dashboard.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}


