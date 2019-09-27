package com.jansek.korfbalstats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class PlayerChangeFragment extends Fragment {

    Match thisMatch;
    ListView currentPlayersLV;
    ListView substitutionsLV;

    ArrayList<Player> currentPlayers;
    ArrayList<Player> substitutes;

    private Player playerOut;
    private Player playerIn;

    MaterialButton substituteBtn;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ks_playerchange_fragment, container, false);

        Bundle bundle = getArguments();
        thisMatch = (Match) bundle.getSerializable("currentMatch");

        currentPlayersLV = (ListView) view.findViewById(R.id.current_players_list);
        substitutionsLV = (ListView) view.findViewById(R.id.substitutes_list);
        configureLists(currentPlayersLV, substitutionsLV);

        substituteBtn = view.findViewById(R.id.substitute_button);
        MaterialButton cancelBtn = view.findViewById(R.id.cancel_button);

        configureButtons(substituteBtn, cancelBtn);



        return view;
    }

    private void configureLists(final ListView currentPlayersLV, final ListView substitutesLV) {
        currentPlayers = new ArrayList<>();
        substitutes = new ArrayList<>();
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

        currentPlayersLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playerOut = (Player) currentPlayersLV.getItemAtPosition(position);
                log("playerOut set to" + playerOut.getPlayerName());
                substitutionReady();
            }
        });

        substitutesLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playerIn = (Player) substitutesLV.getItemAtPosition(position);
                log("playerIn set to" + playerIn.getPlayerName());
                substitutionReady();
            }
        });


    }

    private void substitutionReady() {
        if (playerIn != null && playerOut != null) {
            substituteBtn.setEnabled(true);
        }
    }

    private void configureButtons(Button substituteBtn, Button cancelBtn) {
        substituteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //#TODO substitute function: match.substitute(Player playerOut, Player playerIn);
                thisMatch.substitute(playerOut, playerIn);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();

                MatchFragment.hideOptionsOverlay();
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

    public void log(String log) {
        System.out.println(log);
    }
}
