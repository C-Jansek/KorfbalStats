package com.jansek.korfbalstats;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MatchStartActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    Match thisMatch;

    ListView playersLV;

    ArrayList<Player> currentPlayers;
    MaterialButton addBtn;
    MaterialButton continueBtn;
    MaterialButton backBtn;
    AutoCompleteTextView teamDropdown;
    TextInputLayout awayTeamInput;
    TextInputLayout dateInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ks_match_start_activity);

        teamDropdown =
                findViewById(R.id.filled_exposed_dropdown);
        configureDropdown(teamDropdown);

        playersLV = (ListView) findViewById(R.id.players_list);
        currentPlayers = new ArrayList<>();
        addBtn = findViewById(R.id.add_button);
        continueBtn = findViewById(R.id.continue_button);
        backBtn = findViewById(R.id.back_button);
        configureLists(playersLV, teamDropdown.getText().toString());

        awayTeamInput = findViewById(R.id.away_team_input);
        dateInput = findViewById(R.id.date_input);
        awayTeamInput.getEditText().addTextChangedListener(new TextWatcher() {

                public void afterTextChanged(Editable s) {}

                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                            configureButtons(addBtn, continueBtn, backBtn);}
                });
        dateInput.getEditText().addTextChangedListener(new TextWatcher() {

                public void afterTextChanged(Editable s) {}

                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                            configureButtons(addBtn, continueBtn, backBtn);}
                });


    }

    private void configureDropdown(AutoCompleteTextView editTextFilledExposedDropdown) {
        List<String> teamNames = new ArrayList<>();
        for (Team t : db.getTeams()) {
            teamNames.add(t.getTeamName());


            ArrayAdapter<String> adapter =
                    new ArrayAdapter<>(
                            Korfbalstats.getAppContext(),
                            R.layout.dropdown_menu_popup_item,
                            teamNames);

            editTextFilledExposedDropdown.setAdapter(adapter);

            editTextFilledExposedDropdown.setOnItemClickListener(this);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        String item = parent.getItemAtPosition(position).toString();

        configureLists(playersLV, item);

    }

    private void configureLists(final ListView playersLV, String teamName) {
        log("configurLists!");
        if (db.findTeamByName(teamName) != null) {
            db.setCurrentTeam(db.findTeamByName(teamName));
            currentPlayers.clear();
            for (Player p : db.findTeamByName(teamName).getTeamPlayers()) {
                currentPlayers.add(p);
            }
        }

        CurrentPlayersListAdapter currentPlayersAdapter = new CurrentPlayersListAdapter(Korfbalstats.getAppContext(), R.layout.adapter_view_layout, currentPlayers);
        playersLV.setAdapter(currentPlayersAdapter);

        //Styling
        playersLV.setBackgroundResource(R.drawable.listview_background_rounded_corner);
        playersLV.setDivider(null);
        playersLV.setDividerHeight(0);

        configureButtons(addBtn, continueBtn, backBtn);

    }

    private void configureButtons(Button addBtn, Button continueBtn, Button backBtn) {
        addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Add player thingy
                }
            });
        backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Add back functionality
                }
            });

        if (isReady()) {
            continueBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    thisMatch = new Match(db.getCurrentTeam(),
                            awayTeamInput.getEditText().getText().toString(),
                            dateInput.getEditText().getText().toString());
                    thisMatch.setMatchPlayers(currentPlayers);
//                    db.setCurrentTeam(db.findTeamByName(teamDropdown.getText().toString()));
                    db.setCurrentMatch(thisMatch);
                    log("Match info: \n" +
                            "hometeam: "+ thisMatch.getHomeTeam().getTeamName() +
                            "\nawayteam: "+ thisMatch.getAwayTeam() +
                            "\n date; "+thisMatch.getMatchDate()
                            );
                    startActivity(new Intent(MatchStartActivity.this, MatchActivity.class));
                }
            });
            continueBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        } else {
            continueBtn.setOnClickListener(null);
            continueBtn.setBackgroundColor(Color.parseColor("#D4D4D4"));
        }
    }

    public boolean isReady() {
        if (currentPlayers != null && awayTeamInput != null && dateInput != null) {
            if (!currentPlayers.isEmpty() && !awayTeamInput.getEditText().getText().toString().equals("") && !awayTeamInput.getEditText().getText().toString().equals("") ) {
                return true;
            }
        }
        return false;
    }

    public void log(String log) {
        System.out.println(log);
    }
}
