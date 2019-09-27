package com.jansek.korfbalstats;

import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Match implements Serializable {
    private View view;
    private static int amountOfShotTypes = 4;
    private String homeTeam;
    private String awayTeam;
    private String matchDate;
    private List<Player> players;
    private List<Player> attackers;
    private List<Player> defenders;
    private List<Player> substitutes;

    //Buttons
    MaterialButton button_1A;
    MaterialButton button_1B;
    MaterialButton button_1C;
    MaterialButton button_1D;

    MaterialButton button_2A;
    MaterialButton button_2B;
    MaterialButton button_2C;
    MaterialButton button_2D;

    MaterialButton button_3A;
    MaterialButton button_3B;
    MaterialButton button_3C;
    MaterialButton button_3D;

    MaterialButton button_4A;
    MaterialButton button_4B;
    MaterialButton button_4C;
    MaterialButton button_4D;

    public Match (String home, String away, String date, View thisView) {
        homeTeam = home;
        awayTeam = away;
        matchDate = date;
        view = thisView;
        addPlayers();
        initButtons();
    }

    private void addPlayers() {
        this.players = new ArrayList<>();
        this.attackers = new ArrayList<>();
        this.defenders = new ArrayList<>();
        this.substitutes = new ArrayList<>();
        if (!MatchFragment.getAllPlayers().isEmpty()) {
            for(Player p: MatchFragment.getAllPlayers()) {
                this.players.add(p);
            }
        }
        createSides();
        setPlayerNameTextViews();
    }


    public void setPlayerNameTextViews() {
        TextView textviewAttacker0 = view.findViewById(R.id.textview_attackername_0);
        textviewAttacker0.setText(attackers.get(0).getPlayerName());
        TextView textviewAttacker1 = view.findViewById(R.id.textview_attackername_1);
        textviewAttacker1.setText(attackers.get(1).getPlayerName());
        TextView textviewAttacker2 = view.findViewById(R.id.textview_attackername_2);
        textviewAttacker2.setText(attackers.get(2).getPlayerName());
        TextView textviewAttacker3 = view.findViewById(R.id.textview_attackername_3);
        textviewAttacker3.setText(attackers.get(3).getPlayerName());
    }

    public void substitute(Player playerOut, Player playerIn) {
        if(this.attackers.contains(playerOut) && this.substitutes.contains(playerIn)) {
            int attackerIndex = attackers.indexOf(playerOut);
            attackers.remove(playerOut);
            attackers.add(attackerIndex, playerIn);

            int subIndex = substitutes.indexOf(playerIn);
            substitutes.remove(playerIn);
            substitutes.add(subIndex, playerOut);
        }
        if(this.defenders.contains(playerOut) && this.substitutes.contains(playerIn)) {
            int defenderIndex = defenders.indexOf(playerOut);
            defenders.remove(playerOut);
            defenders.add(defenderIndex, playerIn);

            int subIndex = substitutes.indexOf(playerIn);
            substitutes.remove(playerIn);
            substitutes.add(subIndex, playerOut);
        }

        setButtonText();
        setPlayerNameTextViews();
    }

    private void initButtons() {
        button_1A = view.findViewById(R.id.goal_button_1A);
        button_1B = view.findViewById(R.id.goal_button_1B);
        button_1C = view.findViewById(R.id.goal_button_1C);
        button_1D = view.findViewById(R.id.goal_button_1D);

        button_2A = view.findViewById(R.id.goal_button_2A);
        button_2B = view.findViewById(R.id.goal_button_2B);
        button_2C = view.findViewById(R.id.goal_button_2C);
        button_2D = view.findViewById(R.id.goal_button_2D);

        button_3A = view.findViewById(R.id.goal_button_3A);
        button_3B = view.findViewById(R.id.goal_button_3B);
        button_3C = view.findViewById(R.id.goal_button_3C);
        button_3D = view.findViewById(R.id.goal_button_3D);

        button_4A = view.findViewById(R.id.goal_button_4A);
        button_4B = view.findViewById(R.id.goal_button_4B);
        button_4C = view.findViewById(R.id.goal_button_4C);
        button_4D = view.findViewById(R.id.goal_button_4D);
    }

    private void createSides() {
        for(int i=0;i<4;i++) {
            this.attackers.add(players.get(i));
        }
        for(int i=4;i<8;i++) {
            this.defenders.add(players.get(i));
        }
        for(int i=8; i < players.size();i++) {
            this.substitutes.add(players.get(i));
        }


    }

    public void changeSides() {
        List<Player> buffer = new ArrayList<>();
        for (Player p: attackers) {
            buffer.add(p);
        }
        attackers.clear();
        for (Player p: defenders) {
            attackers.add(p);
        }
        defenders.clear();
        for (Player p: buffer) {
            defenders.add(p);
        }
        setButtonText();
    }

    public void setButtonText() {
        button_1A.setText(attackers.get(0).getPlayerStats().get(0).get(1) + " / " + attackers.get(0).getPlayerStats().get(0).get(0));
        button_1B.setText(attackers.get(0).getPlayerStats().get(1).get(1) + " / " + attackers.get(0).getPlayerStats().get(1).get(0));
        button_1C.setText(attackers.get(0).getPlayerStats().get(2).get(1) + " / " + attackers.get(0).getPlayerStats().get(2).get(0));
        button_1D.setText(attackers.get(0).getPlayerStats().get(3).get(1) + " / " + attackers.get(0).getPlayerStats().get(3).get(0));

        button_2A.setText(attackers.get(1).getPlayerStats().get(0).get(1) + " / " + attackers.get(1).getPlayerStats().get(0).get(0));
        button_2B.setText(attackers.get(1).getPlayerStats().get(1).get(1) + " / " + attackers.get(1).getPlayerStats().get(1).get(0));
        button_2C.setText(attackers.get(1).getPlayerStats().get(2).get(1) + " / " + attackers.get(1).getPlayerStats().get(2).get(0));
        button_2D.setText(attackers.get(1).getPlayerStats().get(3).get(1) + " / " + attackers.get(1).getPlayerStats().get(3).get(0));

        button_3A.setText(attackers.get(2).getPlayerStats().get(0).get(1) + " / " + attackers.get(2).getPlayerStats().get(0).get(0));
        button_3B.setText(attackers.get(2).getPlayerStats().get(1).get(1) + " / " + attackers.get(2).getPlayerStats().get(1).get(0));
        button_3C.setText(attackers.get(2).getPlayerStats().get(2).get(1) + " / " + attackers.get(2).getPlayerStats().get(2).get(0));
        button_3D.setText(attackers.get(2).getPlayerStats().get(3).get(1) + " / " + attackers.get(2).getPlayerStats().get(3).get(0));

        button_4A.setText(attackers.get(3).getPlayerStats().get(0).get(1) + " / " + attackers.get(3).getPlayerStats().get(0).get(0));
        button_4B.setText(attackers.get(3).getPlayerStats().get(1).get(1) + " / " + attackers.get(3).getPlayerStats().get(1).get(0));
        button_4C.setText(attackers.get(3).getPlayerStats().get(2).get(1) + " / " + attackers.get(3).getPlayerStats().get(2).get(0));
        button_4D.setText(attackers.get(3).getPlayerStats().get(3).get(1) + " / " + attackers.get(3).getPlayerStats().get(3).get(0));

    }

    List<Integer> backTrack = new ArrayList<>();
    boolean justScored = false;

    public void onShot(Player player, int shotType, boolean isGoal) {
        setButtonText();
        if(justScored) {
            System.out.println("SHOT NOT ADDED TO BACKTRACK");
            justScored = false;
            return;
        }
        if (isGoal) {justScored = true;}
        addBacktrack(player, shotType, isGoal);

    }

    private void addBacktrack(Player player, int shotType, boolean isGoal) {
        // -- Add shot to Backtracker
        int thisTrack;
        thisTrack = player.getId() * 16 * 16 +
                shotType * 16;
        if (isGoal) {thisTrack++;}
        backTrack.add(thisTrack);
    }

    public void onUndo() {
        if (backTrack.isEmpty()) {return;}
        int last = backTrack.get(backTrack.size() - 1);
        int id = last / (16 * 16);
        Player thisPlayer = Player.byId(id, players);
        int thisShotType = (last - id*16*16) / 16;
        boolean isGoal = false;
        if ((last%2)==1) {isGoal = true;}
        thisPlayer.removeSingleShot(thisShotType, isGoal);
        setButtonText();
        backTrack.remove(backTrack.size() -1);
        System.out.println("Undo " + Integer.toHexString(last) + "\n id, shotType, goal:" + id + "\t" + thisShotType + "\t" + isGoal);
    }



    // ------ Getters and Setters ----------

    public String getHomeTeam() {
        return homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }
    public String getMatchDate() {
        return matchDate;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public List<Player> getAttackers() {
        return attackers;
    }
    public void setAttackers(List<Player> attackers) {
        this.attackers = attackers;
    }
    public List<Player> getDefenders() {
        return defenders;
    }
    public void setDefenders(List<Player> defenders) {
        this.defenders = defenders;
    }
    public List<Player> getSubstitutes() {
        return substitutes;
    }
    public void setSubstitutes(List<Player> substitutes) {
        this.substitutes = substitutes;
    }
    public static int getAmountOfShotTypes() {
        return amountOfShotTypes;
    }
}
