package com.example.myfirstapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.myfirstapp.R;

import com.example.myfirstapp.activitiesmoodstate.MainActivity;
import com.example.myfirstapp.activitiesmoodstate.MainActivity;


public class Dashboard extends AppCompatActivity {

    private Button  button4;
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
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Dashboard.this, MainActivity.class);
                startActivity(it);
            }
        });

    }
}
