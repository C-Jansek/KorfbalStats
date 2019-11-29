package com.jansek.korfbalstats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private Team playerStandardTeam;
    private String playerName;
    private String sex;
    private int id;
    private int amountOfShotTypes = Match.getAmountOfShotTypes();
    private List<List<Integer>> playerStats;

    public Player (String playerName, String sex) {
        this.playerName = playerName;
        this.sex = sex;
        id = createId();
        MatchFragment.addToAllPlayers(this);
        db.addToAllPlayers(this);

        resetPlayerStats();
    }

    public Player (String playerName, String sex, String standardTeam) {
        if (db.teamExists(standardTeam)) {
            playerStandardTeam = db.findTeamByName(standardTeam);
            playerStandardTeam.addPlayer(this);
        }
        this.playerName = playerName;
        this.sex = sex;
        id = createId();
//        MatchFragment.addToAllPlayers(this);
        db.addToAllPlayers(this);

        resetPlayerStats();
    }

    private void resetPlayerStats() {
        //Set all stats 0
        playerStats = new ArrayList<>();
        for (int i = 0; i < amountOfShotTypes; i++) {
            playerStats.add(Arrays.asList(0,0));
        }
    }

    //Select player from id
    public static Player byId(Integer id, List<Player> players) {
        for (Player p: players) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private int createId() {
        int number = db.getAllPlayers().size() + 1;
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
        int newGoalScore = playerStats.get(shotType).get(1);
        if (isGoal) {
            newGoalScore -= 1;
            playerStats.get(shotType).set(1, newGoalScore);
        }
        System.out.println("Removed " + id + "\t" + shotType + "\t" + isGoal + "\n Old Score: " + playerStats.get(shotType).get(1) + "\t\t New Score: "+ newGoalScore);
    }


    public void printPlayerStats() {
        System.out.println("\n" + playerName + " with id " + id + " has " + playerStats.size() + " stat(s), which are:\n");
                for (int i = 0; i < playerStats.size(); i++) {
            List<Integer> shot = playerStats.get(i);
            System.out.println("Shot type " + i + ":  \t" + shot.get(1) + " / " + shot.get(0) + "\n");
        }
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return id + " " + playerName ;
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

    public int getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    // End of Getters and Setters
}
