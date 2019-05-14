package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {


    private String playerName;
    private List<StatsList> playerStats;

    public Player (String name) {
        playerName = name;
        playerStats = new ArrayList<>();
    }

    public void printPlayerStats(){
        for (StatsList s : playerStats) {
            System.out.println("Stats from match: \t" + s.getStatsMatch().getHomeTeam() + " - " + s.getStatsMatch().getAwayTeam()
                    + " \ton " + s.getStatsMatch().getMatchDate());
            System.out.println("Overhand: " + s.getOverhandStat());
            System.out.println("Underhand: " + s.getUnderhandStat());
            System.out.println("Penalty: " + s.getPenaltyStat());
            System.out.println("Free Pass: " + s.getFreePassStat());
        }
    }

    public void addPlayerStatsList(StatsList list) {
        playerStats.add(list);
    }

    // ----- Getters and Setters -------

    public String getPlayerName() {
        return playerName;
    }
    public List<StatsList> getPlayerStats() {
        return playerStats;
    }




}

/* ------------------- Notes -------------------
What you want to know from a player:
    Shots
        Overhand
        Underhand
        Penalty
        Free Pass
    Goals
    Match played

What you want to process:
    Shot percentage
        Shot
        Underhand
        Penalty
        Free Pass



*/
