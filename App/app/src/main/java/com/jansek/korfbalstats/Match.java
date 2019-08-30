package com.jansek.korfbalstats;

import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private View view;
    private String homeTeam;
    private String awayTeam;
    private String matchDate;
    static List<Player> players;
    static List<Player> attackers;
    static List<Player> defenders;

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
        createPlayers();
        initButtons();
    }

    private void createPlayers() {
        players = new ArrayList<>();
        attackers = new ArrayList<>();
        defenders = new ArrayList<>();
        Player david = new Player("David");
        players.add(david);
        Player christiaan = new Player("Christiaan");
        players.add(christiaan);
        Player michelle = new Player("Michelle");
        players.add(michelle);
        Player lysanne = new Player("Lysanne");
        players.add(lysanne);
        Player bertJan = new Player("Bert-Jan");
        players.add(bertJan);
        Player gijs = new Player("Gijs");
        players.add(gijs);
        Player ingrid = new Player("Ingrid");
        players.add(ingrid);
        Player wieke = new Player("Wieke");
        players.add(wieke);

        System.out.println("Created following players: " + players);
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
            attackers.add(players.get(i));
        }
        for(int i=4;i<8;i++) {
            defenders.add(players.get(i));
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

    private void setButtonText() {
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

    //#TODO Implement Backtracking
    List<Integer> backTrack = new ArrayList<>();

    public void onShot(Player player, int shotType, boolean isGoal) {
        addBacktrack(player, shotType, isGoal);
        setButtonText();
    }

    private void addBacktrack(Player player, int shotType, boolean isGoal) {
        // -- Add shot to Backtracker
        int thisTrack;
        thisTrack = player.getPlayerNo() * 16 * 16 +
                shotType * 16;
        if (isGoal) {thisTrack++;}
        backTrack.add(thisTrack);
    }

    private void onUndo() {
        if (backTrack.isEmpty()) {return;};
        int last = backTrack.get(backTrack.size() - 1);
        int playerNo = last / (16 * 16);
        Player thisPlayer = Player.byNo(playerNo, players);
        int thisShotType = (last - playerNo) / 16;
        boolean isGoal = false;
        if ((last%2)==1) {isGoal = true;}
        thisPlayer.removeSingleShot(thisShotType, isGoal);
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
    public static List<Player> getPlayers() {
        return players;
    }
    public static List<Player> getAttackers() {
        return attackers;
    }
    public static void setAttackers(List<Player> attackers) {
        Match.attackers = attackers;
    }
    public static List<Player> getDefenders() {
        return defenders;
    }
    public static void setDefenders(List<Player> attackers) {
        Match.defenders = attackers;
    }
}
