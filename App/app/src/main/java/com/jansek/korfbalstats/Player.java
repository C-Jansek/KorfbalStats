package com.jansek.korfbalstats;


import android.service.autofill.FieldClassification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private String playerName;
    private int playerNo;
    private int amountOfShotTypes = Match.getAmountOfShotTypes();
    private List<List<Integer>> playerStats;


    public Player (String name) {
        playerName = name;
        playerNo = createPlayerNo();
        MatchFragment.addToAllPlayers(this);

        resetPlayerStats();
    }

    private void resetPlayerStats() {
        //Set all stats 0
        playerStats = new ArrayList<>();
        for (int i = 0; i < amountOfShotTypes; i++) {
            playerStats.add(Arrays.asList(0,0));
        }
    }

    //Select player from playerNo
    public static Player byNo(Integer no, List<Player> players) {
        for (Player p: players) {
            if (p.getPlayerNo() == no) {
                return p;
            }
        }
        return null;
    }


    private int createPlayerNo() {
        int number = MatchFragment.getAllPlayers().size() + 1;
        return number;
    }

    public void addSingleShot(int shotType) {
        playerStats.get(shotType).set(0, playerStats.get(shotType).get(0) + 1);
    }
    public void addSingleGoal(int shotType) {
        playerStats.get(shotType).set(1, playerStats.get(shotType).get(1) + 1);

        System.out.println("GOAL ADDED TO BACKTRACK");
    }

    public void removeSingleShot(int shotType, boolean isGoal) {
        playerStats.get(shotType).set(0, playerStats.get(shotType).get(0) - 1);
        int newGoalScore = playerStats.get(shotType).get(1) - 1;
        System.out.println("Removed " + playerNo + "\t" + shotType + "\t" + isGoal + "\n Old Score: " + playerStats.get(shotType).get(1) + "\t\t New Score: "+ newGoalScore);
        if (isGoal) {playerStats.get(shotType).set(1, newGoalScore);}
    }


    public void printPlayerStats() {
        System.out.println("\n" + playerName + " with playerNo " + playerNo + " has " + playerStats.size() + " stat(s), which are:\n");
                for (int i = 0; i < playerStats.size(); i++) {
            List<Integer> shot = playerStats.get(i);
            System.out.println("Shot type " + i + ":  \t" + shot.get(1) + " / " + shot.get(0) + "\n");
        }
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return playerNo + " " + playerName ;
    }

    //Getters and setters
    public List<List<Integer>> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(List<List<Integer>> playerStats) {
        this.playerStats = playerStats;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerNo() {
        return playerNo;
    }

    // End of Getters and Setters
}
