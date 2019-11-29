package com.jansek.korfbalstats;


import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class PlayersActivity extends AppCompatActivity {

    LinearLayout linLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players_activity);

        configureTeamButtons();
    }

    private void configureTeamButtons() {
        linLayout = findViewById(R.id.teamButtonLL);

//        add all teams
        for (final Team t : db.getTeams()) {
            MaterialButton mb = new MaterialButton(this);
            mb.setText(t.getTeamName());
            linLayout.addView(mb);
            int btnwidth = getResources().getDimensionPixelSize(R.dimen.homeButtonWidth);
            mb.getLayoutParams().width = btnwidth;
            mb.requestLayout();
            mb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.setCurrentTeam(t);
                    startActivity(new Intent(PlayersActivity.this, MatchActivity.class));
                }
            });
        }




    }
}
