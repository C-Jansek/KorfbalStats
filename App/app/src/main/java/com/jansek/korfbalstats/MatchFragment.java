package com.jansek.korfbalstats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MatchFragment extends Fragment {

    // ---- Initialization ----
    int goals_1A = 0;
    int goals_1B = 0;
    int goals_1C = 0;
    int goals_1D = 0;

    int shots_1A = 0;
    int shots_1B = 0;
    int shots_1C = 0;
    int shots_1D = 0;
    //---
    int goals_2A = 0;
    int goals_2B = 0;
    int goals_2C = 0;
    int goals_2D = 0;

    int shots_2A = 0;
    int shots_2B = 0;
    int shots_2C = 0;
    int shots_2D = 0;

    //---
    int goals_3A = 0;
    int goals_3B = 0;
    int goals_3C = 0;
    int goals_3D = 0;

    int shots_3A = 0;
    int shots_3B = 0;
    int shots_3C = 0;
    int shots_3D = 0;

    //---
    int goals_4A = 0;
    int goals_4B = 0;
    int goals_4C = 0;
    int goals_4D = 0;

    int shots_4A = 0;
    int shots_4B = 0;
    int shots_4C = 0;
    int shots_4D = 0;



    Match thisMatch;
    // ---- End of Initialization ----


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ks_match_fragment, container, false);

        MaterialButton button_1A = (MaterialButton) view.findViewById(R.id.goal_button_1A);
        MaterialButton button_1B = (MaterialButton) view.findViewById(R.id.goal_button_1B);
        MaterialButton button_1C = (MaterialButton) view.findViewById(R.id.goal_button_1C);
        MaterialButton button_1D = (MaterialButton) view.findViewById(R.id.goal_button_1D);

        MaterialButton button_2A = (MaterialButton) view.findViewById(R.id.goal_button_2A);
        MaterialButton button_2B = (MaterialButton) view.findViewById(R.id.goal_button_2B);
        MaterialButton button_2C = (MaterialButton) view.findViewById(R.id.goal_button_2C);
        MaterialButton button_2D = (MaterialButton) view.findViewById(R.id.goal_button_2D);

        MaterialButton button_3A = (MaterialButton) view.findViewById(R.id.goal_button_3A);
        MaterialButton button_3B = (MaterialButton) view.findViewById(R.id.goal_button_3B);
        MaterialButton button_3C = (MaterialButton) view.findViewById(R.id.goal_button_3C);
        MaterialButton button_3D = (MaterialButton) view.findViewById(R.id.goal_button_3D);

        MaterialButton button_4A = (MaterialButton) view.findViewById(R.id.goal_button_4A);
        MaterialButton button_4B = (MaterialButton) view.findViewById(R.id.goal_button_4B);
        MaterialButton button_4C = (MaterialButton) view.findViewById(R.id.goal_button_4C);
        MaterialButton button_4D = (MaterialButton) view.findViewById(R.id.goal_button_4D);

        MaterialButton undoButton = (MaterialButton) view.findViewById(R.id.undo_button);
        MaterialButton changesSidesButton = (MaterialButton) view.findViewById(R.id.change_sides_button);
        configureButtons(view, button_1A, button_1B, button_1C, button_1D,
                button_2A, button_2B, button_2C, button_2D,
                button_3A, button_3B, button_3C, button_3D,
                button_4A, button_4B, button_4C, button_4D,
                undoButton, changesSidesButton);

        thisMatch = new Match("Gemini 1", "KV Arena 1", "20190831 16:30", view);


        for (Player p:thisMatch.getPlayers()) {
            p.getPlayerStats();
        }
        return view;
    }

    private void configureButtons(final View view,
                                  final Button button_1A, final Button button_1B, final Button button_1C, final Button button_1D,
                                  final Button button_2A, final Button button_2B, final Button button_2C, final Button button_2D,
                                  final Button button_3A, final Button button_3B, final Button button_3C, final Button button_3D,
                                  final Button button_4A, final Button button_4B, final Button button_4C, final Button button_4D, final Button undoButton, final Button changesSidesButton) {


        //#TODO Display scores based on player instead of buttonPresses
        //#TODO Dynamically change player scores when changeSidesButton is pressed

        //Player 1
        //Button 1A
        button_1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_1A++;
                button_1A.setText(goals_1A + " / " + shots_1A);
                thisMatch.attackers.get(0).addSingleShot(0);
            }
        });
        button_1A.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_1A++;
                thisMatch.attackers.get(0).addSingleGoal(0);
                return false;
            }
        });

        //Button 1B
        button_1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_1B++;
                button_1B.setText(goals_1B + " / " + shots_1B);
                thisMatch.attackers.get(0).addSingleShot(1);
            }
        });
        button_1B.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_1B++;
                thisMatch.attackers.get(0).addSingleGoal(1);
                return false;
            }
        });

        //Button 1C
        button_1C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_1C++;
                button_1C.setText(goals_1C + " / " + shots_1C);
                thisMatch.attackers.get(0).addSingleShot(2);
            }
        });
        button_1C.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_1C++;
                thisMatch.attackers.get(0).addSingleGoal(2);
                return false;
            }
        });

        //Button 1D
        button_1D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_1D++;
                button_1D.setText(goals_1D + " / " + shots_1D);
                thisMatch.attackers.get(0).addSingleShot(3);
            }
        });
        button_1D.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_1D++;
                thisMatch.attackers.get(0).addSingleGoal(3);
                return false;
            }
        });

        //Player 2
        //Button 2A
        button_2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_2A++;
                button_2A.setText(goals_2A + " / " + shots_2A);
                thisMatch.attackers.get(1).addSingleShot(0);
            }
        });
        button_2A.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_2A++;
                thisMatch.attackers.get(1).addSingleGoal(0);
                return false;
            }
        });

        //Button 2B
        button_2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_2B++;
                button_2B.setText(goals_2B + " / " + shots_2B);
                thisMatch.attackers.get(1).addSingleShot(1);
            }
        });
        button_2B.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_2B++;
                thisMatch.attackers.get(1).addSingleGoal(1);
                return false;
            }
        });

        //Button 2C
        button_2C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_2C++;
                button_2C.setText(goals_2C + " / " + shots_2C);
                thisMatch.attackers.get(1).addSingleShot(2);
            }
        });
        button_2C.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_2C++;
                thisMatch.attackers.get(1).addSingleGoal(2);
                return false;
            }
        });

        //Button 2D
        button_2D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_2D++;
                button_2D.setText(goals_2D + " / " + shots_2D);
                thisMatch.attackers.get(1).addSingleShot(3);
            }
        });
        button_2D.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_2D++;
                thisMatch.attackers.get(1).addSingleGoal(3);
                return false;
            }
        });

        //Player 3
        //Button 3A
        button_3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_3A++;
                button_3A.setText(goals_3A + " / " + shots_3A);
                thisMatch.attackers.get(2).addSingleShot(0);
            }
        });
        button_3A.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_3A++;
                thisMatch.attackers.get(2).addSingleGoal(0);
                return false;
            }
        });

        //Button 3B
        button_3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_3B++;
                button_3B.setText(goals_3B + " / " + shots_3B);
                thisMatch.attackers.get(2).addSingleShot(1);
            }
        });
        button_3B.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_3B++;
                thisMatch.attackers.get(2).addSingleGoal(1);
                return false;
            }
        });

        //Button 3C
        button_3C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_3C++;
                button_3C.setText(goals_3C + " / " + shots_3C);
                thisMatch.attackers.get(2).addSingleShot(2);
            }
        });
        button_3C.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_3C++;
                thisMatch.attackers.get(2).addSingleGoal(2);
                return false;
            }
        });

        //Button 3D
        button_3D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_3D++;
                button_3D.setText(goals_3D + " / " + shots_3D);
                thisMatch.attackers.get(2).addSingleShot(3);
            }
        });
        button_3D.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_3D++;
                thisMatch.attackers.get(2).addSingleGoal(3);
                return false;
            }
        });

        //Player 4
        //Button 4A
        button_4A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_4A++;
                button_4A.setText(goals_4A + " / " + shots_4A);
                thisMatch.attackers.get(3).addSingleShot(0);
            }
        });
        button_4A.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_4A++;
                thisMatch.attackers.get(3).addSingleGoal(0);
                return false;
            }
        });

        //Button 4B
        button_4B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_4B++;
                button_4B.setText(goals_4B + " / " + shots_4B);
                thisMatch.attackers.get(3).addSingleShot(1);
            }
        });
        button_4B.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_4B++;
                thisMatch.attackers.get(3).addSingleGoal(1);
                return false;
            }
        });

        //Button 4C
        button_4C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_4C++;
                button_4C.setText(goals_4C + " / " + shots_4C);
                thisMatch.attackers.get(3).addSingleShot(2);
            }
        });
        button_4C.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_4C++;
                thisMatch.attackers.get(3).addSingleGoal(2);
                return false;
            }
        });

        //Button 4D
        button_4D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shots_4D++;
                button_4D.setText(goals_4D + " / " + shots_4D);
                thisMatch.attackers.get(3).addSingleShot(3);
            }
        });
        button_4D.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goals_4D++;
                thisMatch.attackers.get(3).addSingleGoal(3);
                return false;
            }
        });


        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Clicked on undo button!");
                for (Player p:thisMatch.getPlayers()) {
                    p.printPlayerStats();
                }
            }
        });

        changesSidesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.changeSides();
                thisMatch.setPlayerNameTextViews();
            }
        });


        // --- Create buttons via List, try ---
        // Create buttons List
//        int amountOfPlayers = 4;
//        int amountOfButtonsPP = 4;
//
//        List<List<MaterialButton>> buttons = new ArrayList<>();
//
//        for (int i = 0; i < amountOfPlayers; i++) {
//            buttons.add(new ArrayList<MaterialButton>());
//            for (char j = 65; j < 65 + amountOfButtonsPP; j++) {
//                String currentId = Integer.toString(i) + Character.toString(j);
//                MaterialButton currentButton = (MaterialButton) view.findViewById(R.id.goal_button_currentId)
//                buttons.add(currentButton);
//            }
//        }
//
//
//        for (Button b : buttons) {
//
//        }


    }


//
//    private void createPlayers() {
//        players = new ArrayList<>();
//        Player Roelant = new Player("Roelant");
//        Player Wytse = new Player("Wytse");
//        Player Lysanne = new Player("Lysanne");
//        Player Michelle = new Player("Michelle");
//    }
//
//
//    List<Integer> backTrack = new ArrayList<>();
//
//    private void onShot(Player player, int shotType, boolean isGoal) {
//        // -- Add shot to Backtracker
//        int thisTrack;
//        thisTrack = player.getPlayerNo() * 16 * 16 +
//                shotType * 16;
//        if (isGoal) {thisTrack++;}
//        backTrack.add(thisTrack);
//    }
//
//    private void onUndo() {
//        if (backTrack.isEmpty()) {return};
//        int last = backTrack.get(backTrack.size() - 1);
//        int playerNo = last / (16 * 16);
//        Player thisPlayer = Player.byNo(playerNo, players);
//        int thisShotType = (last - playerNo) / 16;
//        boolean isGoal = false;
//        if ((last%2)==1) {isGoal = true;}
//        thisPlayer.removeSingleShot(thisShotType, isGoal);
//    }
//
//
//
//    //Getters and Setters
//
//    public List<Player> getPlayers() {
//        return players;
//    }

}












