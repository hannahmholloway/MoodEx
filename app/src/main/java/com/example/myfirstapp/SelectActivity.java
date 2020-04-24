package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.calorietracker.CalorieActivity;

public class SelectActivity extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_view);
        clickButton();
    }

    private void clickButton() {
        btn1 = (Button) findViewById(R.id.calorieButton);
        btn2 = (Button) findViewById(R.id.dietButton);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(SelectActivity.this, CalorieActivity.class);
                startActivity(it);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(SelectActivity.this, DietActivity.class);
                startActivity(it);
            }
        });
    }
}
