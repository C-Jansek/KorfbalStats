package com.jansek.korfbalstats;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MatchFragment extends Fragment {

    // ---- Initialization ----
    private Match thisMatch;
    private static List<Player> allPlayers = new ArrayList<>();

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

        if (allPlayers.isEmpty()) {
            createPlayers();
        }
        thisMatch = new Match("Gemini 1", "KV Arena 1", "20190831 16:30", view);



        for (Player p:thisMatch.getPlayers()) {
            p.getPlayerStats();
        }
        return view;
    }


    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.match_fragment, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void createPlayers() {
        Player david = new Player("David");
        Player christiaan = new Player("Christiaan");
        Player michelle = new Player("Michelle");
        Player lysanne = new Player("Lysanne");
        Player bertJan = new Player("Bert-Jan");
        Player gijs = new Player("Gijs");
        Player ingrid = new Player("Ingrid");
        Player wieke = new Player("Wieke");

        System.out.println("Created following players: " + allPlayers);
    }

    public static void addToAllPlayers(Player p) {
        allPlayers.add(p);
    }

    private void configureButtons(final View view,
                                  final Button button_1A, final Button button_1B, final Button button_1C, final Button button_1D,
                                  final Button button_2A, final Button button_2B, final Button button_2C, final Button button_2D,
                                  final Button button_3A, final Button button_3B, final Button button_3C, final Button button_3D,
                                  final Button button_4A, final Button button_4B, final Button button_4C, final Button button_4D, final Button undoButton, final Button changesSidesButton) {

        MaterialButton menuButton = view.findViewById(R.id.options_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout fl = view.findViewById(R.id.options_overlay);
                fl.setVisibility(View.VISIBLE);
            }
        });

        //   vv   THIS BUTTON HAS TESTING PURPOSES   vv
        MaterialButton substitutionButton = view.findViewById(R.id.substitution_button);
        substitutionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(allPlayers);
            }
        });

        final FrameLayout optionsOverlay = view.findViewById(R.id.options_overlay);
        optionsOverlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionsOverlay.setVisibility(View.GONE);
            }
        });

        MaterialButton saveButton = view.findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Saver thisSaver = new Saver(thisMatch, getContext());
            }
        });

        //   vv   THIS BUTTON HAS TESTING PURPOSES   vv
        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Clicked on undo button!");
//                for (Player p:thisMatch.getPlayers()) {
//                    p.printPlayerStats();
//                }
                thisMatch.onUndo();
            }
        });

        changesSidesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.changeSides();
                thisMatch.setPlayerNameTextViews();
            }
        });

        //#TODO make user able to change players with

        //Player 1
        //Button 1A
        button_1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(0).addSingleShot(0);
                thisMatch.onShot(thisMatch.getAttackers().get(0), 0,false);
            }
        });
        button_1A.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(0).addSingleGoal(0);
                thisMatch.onShot(thisMatch.getAttackers().get(0), 0,true);
                return false;
            }
        });

        //Button 1B
        button_1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(0).addSingleShot(1);
                thisMatch.onShot(thisMatch.getAttackers().get(0), 1,false);
            }
        });
        button_1B.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(0).addSingleGoal(1);
                thisMatch.onShot(thisMatch.getAttackers().get(0), 1,true);
                return false;
            }
        });

        //Button 1C
        button_1C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(0).addSingleShot(2);
                thisMatch.onShot(thisMatch.getAttackers().get(0), 2,false);
            }
        });
        button_1C.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(0).addSingleGoal(2);
                thisMatch.onShot(thisMatch.getAttackers().get(0), 2,true);
                return false;
            }
        });

        //Button 1D
        button_1D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(0).addSingleShot(3);
                thisMatch.onShot(thisMatch.getAttackers().get(0), 3,false);
            }
        });
        button_1D.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(0).addSingleGoal(3);
                thisMatch.onShot(thisMatch.getAttackers().get(0), 3,true);
                return false;
            }
        });

        //Player 2
        //Button 2A
        button_2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(1).addSingleShot(0);
                thisMatch.onShot(thisMatch.getAttackers().get(1), 0,false);
            }
        });
        button_2A.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(1).addSingleGoal(0);
                thisMatch.onShot(thisMatch.getAttackers().get(1), 0,true);
                return false;
            }
        });

        //Button 2B
        button_2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(1).addSingleShot(1);
                thisMatch.onShot(thisMatch.getAttackers().get(1), 1,false);
            }
        });
        button_2B.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(1).addSingleGoal(1);
                thisMatch.onShot(thisMatch.getAttackers().get(1), 1,true);
                return false;
            }
        });

        //Button 2C
        button_2C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(1).addSingleShot(2);
                thisMatch.onShot(thisMatch.getAttackers().get(1), 2,false);
            }
        });
        button_2C.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(1).addSingleGoal(2);
                thisMatch.onShot(thisMatch.getAttackers().get(1), 2,true);
                return false;
            }
        });

        //Button 2D
        button_2D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(1).addSingleShot(3);
                thisMatch.onShot(thisMatch.getAttackers().get(1), 3,false);
            }
        });
        button_2D.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(1).addSingleGoal(3);
                thisMatch.onShot(thisMatch.getAttackers().get(1), 3,true);
                return false;
            }
        });

        //Player 3
        //Button 3A
        button_3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(2).addSingleShot(0);
                thisMatch.onShot(thisMatch.getAttackers().get(2), 0,false);
            }
        });
        button_3A.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(2).addSingleGoal(0);
                thisMatch.onShot(thisMatch.getAttackers().get(2), 0,true);
                return false;
            }
        });

        //Button 3B
        button_3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(2).addSingleShot(1);
                thisMatch.onShot(thisMatch.getAttackers().get(2), 1,false);
            }
        });
        button_3B.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(2).addSingleGoal(1);
                thisMatch.onShot(thisMatch.getAttackers().get(2), 1,true);
                return false;
            }
        });

        //Button 3C
        button_3C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(2).addSingleShot(2);
                thisMatch.onShot(thisMatch.getAttackers().get(2), 2,false);
            }
        });
        button_3C.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(2).addSingleGoal(2);
                thisMatch.onShot(thisMatch.getAttackers().get(2), 2,true);
                return false;
            }
        });

        //Button 3D
        button_3D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(2).addSingleShot(3);
                thisMatch.onShot(thisMatch.getAttackers().get(2), 3,false);
            }
        });
        button_3D.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(2).addSingleGoal(3);
                thisMatch.onShot(thisMatch.getAttackers().get(2), 3,true);
                return false;
            }
        });

        //Player 4
        //Button 4A
        button_4A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(3).addSingleShot(0);
                thisMatch.onShot(thisMatch.getAttackers().get(3), 0,false);
            }
        });
        button_4A.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(3).addSingleGoal(0);
                thisMatch.onShot(thisMatch.getAttackers().get(3), 0,true);
                return false;
            }
        });

        //Button 4B
        button_4B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(3).addSingleShot(1);
                thisMatch.onShot(thisMatch.getAttackers().get(3), 1,false);
            }
        });
        button_4B.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(3).addSingleGoal(1);
                thisMatch.onShot(thisMatch.getAttackers().get(3), 1,true);
                return false;
            }
        });

        //Button 4C
        button_4C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(3).addSingleShot(2);
                thisMatch.onShot(thisMatch.getAttackers().get(3), 2,false);
            }
        });
        button_4C.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(3).addSingleGoal(2);
                thisMatch.onShot(thisMatch.getAttackers().get(3), 2,true);
                return false;
            }
        });

        //Button 4D
        button_4D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMatch.getAttackers().get(3).addSingleShot(3);
                thisMatch.onShot(thisMatch.getAttackers().get(3), 3,false);
            }
        });
        button_4D.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thisMatch.getAttackers().get(3).addSingleGoal(3);
                thisMatch.onShot(thisMatch.getAttackers().get(3), 3,true);
                return false;
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
    //Getters and Setters

    public static List<Player> getAllPlayers() {
        return allPlayers;
    }

}












