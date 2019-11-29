package com.jansek.korfbalstats;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String teamName;
    private List<Player> teamPlayers;
    private List<Match> teamMatches;


    public Team (String teamName) {
        this.teamName = teamName;
        teamPlayers = new ArrayList<>();
        teamMatches = new ArrayList<>();
    }

    public void addPlayer(Player p) {
        this.teamPlayers.add(p);
    }



    //Getters and Setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public List<Match> getTeamMatches() {
        return teamMatches;
    }

    public void setTeamMatches(List<Match> teamMatches) {
        this.teamMatches = teamMatches;
    }
}
