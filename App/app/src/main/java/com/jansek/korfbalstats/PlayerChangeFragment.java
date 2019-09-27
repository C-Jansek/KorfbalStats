package com.jansek.korfbalstats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class PlayerChangeFragment extends Fragment {

    Match thisMatch;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ks_playerchange_fragment, container, false);

        Bundle bundle = getArguments();
        thisMatch = (Match) bundle.getSerializable("currentMatch");

        ListView currentPlayersLV = (ListView) view.findViewById(R.id.current_players_list);
        ListView substitutionsLV = (ListView) view.findViewById(R.id.substitutes_list);
        configureLists(currentPlayersLV, substitutionsLV);

        MaterialButton substituteBtn = view.findViewById(R.id.substitute_button);
        MaterialButton cancelBtn = view.findViewById(R.id.cancel_button);

        configureButtons(substituteBtn, cancelBtn);

        return view;
    }

    private void configureLists(ListView currentPlayersLV, ListView substitutesLV) {
        ArrayList<Player> currentPlayers = new ArrayList<>();
        ArrayList<Player> substitutes = new ArrayList<>();
        for (Player def:thisMatch.getDefenders()) {
            currentPlayers.add(def);
        }
        for (Player att:thisMatch.getAttackers()) {
            currentPlayers.add(att);
        }
        for (Player sub:thisMatch.getSubstitutes()) {
            substitutes.add(sub);
        }

        CurrentPlayersListAdapter currentPlayersAdapter = new CurrentPlayersListAdapter(getContext(), R.layout.adapter_view_layout, currentPlayers);
        currentPlayersLV.setAdapter(currentPlayersAdapter);

        SubstitutesListAdapter substitutesAdapter = new SubstitutesListAdapter(getContext(), R.layout.adapter_view_layout, substitutes);
        substitutesLV.setAdapter(substitutesAdapter);

        //Styling
        currentPlayersLV.setBackgroundResource(R.drawable.listview_background_rounded_corner);
        currentPlayersLV.setDivider(null);
        currentPlayersLV.setDividerHeight(0);
        substitutesLV.setBackgroundResource(R.drawable.listview_background_rounded_corner);
        substitutesLV.setDivider(null);
        substitutesLV.setDividerHeight(0);

    }

    private void configureButtons(Button substituteBtn, Button cancelBtn) {
        substituteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //#TODO substitute function: match.substitute(Player playerOut, Player playerIn);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
            }
        });
    }
}
