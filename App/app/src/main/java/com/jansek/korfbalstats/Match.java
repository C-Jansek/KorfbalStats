package com.jansek.korfbalstats;

import android.view.View;
import android.widget.TextView;

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

    public Match (String home, String away, String date, View thisView) {
        homeTeam = home;
        awayTeam = away;
        matchDate = date;
        view = thisView;
        createPlayers();
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
        TextView textviewAttacker0 = (TextView) view.findViewById(R.id.textview_attackername_0);
        textviewAttacker0.setText(attackers.get(0).getPlayerName());
        TextView textviewAttacker1 = (TextView) view.findViewById(R.id.textview_attackername_1);
        textviewAttacker1.setText(attackers.get(1).getPlayerName());
        TextView textviewAttacker2 = (TextView) view.findViewById(R.id.textview_attackername_2);
        textviewAttacker2.setText(attackers.get(2).getPlayerName());
        TextView textviewAttacker3 = (TextView) view.findViewById(R.id.textview_attackername_3);
        textviewAttacker3.setText(attackers.get(3).getPlayerName());
    }

    public void createSides() {
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
    }


    //#TODO Implement Backtracking
    List<Integer> backTrack = new ArrayList<>();

    private void onShot(Player player, int shotType, boolean isGoal) {
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
