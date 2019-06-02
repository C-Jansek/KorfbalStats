package com.jansek.korfbalstats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class MatchFragment extends Fragment {

    int goals_1A = 0;
    int goals_1B = 0;
    int goals_1C = 0;
    int goals_1D = 0;

    int shots_1A = 0;
    int shots_1B = 0;
    int shots_1C = 0;
    int shots_1D = 0;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ks_match_fragment, container, false);

        configureButtons();
        return view;
    }

    private void configureButtons() {
        MaterialButton goalButton1A = (MaterialButton) getView().findViewById(R.id.goal_button_1A);
        MaterialButton goalButton1B = (MaterialButton) getView().findViewById(R.id.goal_button_1B);
        MaterialButton goalButton1C = (MaterialButton) getView().findViewById(R.id.goal_button_1C);
        MaterialButton goalButton1D = (MaterialButton) getView().findViewById(R.id.goal_button_1D);

        goalButton1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_1A++;
            }
        });
        goalButton1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_1B++;
            }
        });
        goalButton1C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_1C++;
            }
        });
        goalButton1D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_1D++;
            }
        });

        goalButton1A.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_1A++; return false;
            }
        });
        goalButton1B.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_1B++; return false;
            }
        });
        goalButton1C.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_1C++; return false;
            }
        });
        goalButton1D.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_1D++; return false;
            }
        });

    }


}
