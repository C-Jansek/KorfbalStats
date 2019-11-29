package com.jansek.korfbalstats;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        configureHomeButtons();

        db dataBase = new db();
    }

    private void configureHomeButtons() {
        MaterialButton firstHomeBtn = findViewById(R.id.firstHomeBtn);
        MaterialButton secondHomeBtn = findViewById(R.id.secondHomeBtn);
        MaterialButton thirdHomeBtn = findViewById(R.id.thirdHomeBtn);

//        int width = Math.max(firstHomeBtn.getWidth(), secondHomeBtn.getWidth());
//        width = Math.max(width, thirdHomeBtn.getWidth());
//        firstHomeBtn.setWidth(width);
//        secondHomeBtn.setWidth(width);
//        thirdHomeBtn.setWidth(width);

        firstHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MatchStartActivity.class));
            }
        });

        secondHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, PlayersActivity.class));
            }
        });


    }
}
