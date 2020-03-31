package com.example.myfirstapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myfirstapp.R;

import com.example.myfirstapp.activitiesmoodstate.MainActivity;
import com.example.myfirstapp.calorietracker.CalorieActivity;
import com.example.myfirstapp.watertracker.HydrationTrackerActivity;
import com.example.myfirstapp.R;
import com.example.myfirstapp.activitiesmoodstate.MainActivity;
import com.example.myfirstapp.activitiesrest.PieChartActivity;
import com.example.myfirstapp.adapters.RvAdapter;
import com.example.myfirstapp.database.DatabaseContract;
import com.example.myfirstapp.database.DatabaseHelper;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

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


public class MyValueFormatter implements IValueFormatter {

    private DecimalFormat mFormat;

    public MyValueFormatter() {
        mFormat = new DecimalFormat("###,###,##0");
    }

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {

        if (value == 1) return mFormat.format(value) + " day";
        else return mFormat.format(value) + " days";

    }
}
}
