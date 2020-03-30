package com.example.myfirstapp.watertracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myfirstapp.R;

public class MainWaterActivity extends AppCompatActivity {

    /* --------------------------------------------------- onCreate ------------------------------------------------ */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    /* --------------------------------------------------- Actual functions ----------------------------------------- */


    public void openHydrationSetting(MenuItem item)
    {
        Intent intent = new Intent(this, HydrationSettingActivity.class);
        startActivity(intent);
    }



}
