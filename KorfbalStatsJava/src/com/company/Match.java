package com.company;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private String homeTeam;
    private String awayTeam;
    private String matchDate;
    private Underground underground;

    List<StatsList> matchStats;

    public Match (String home, String away, String date, boolean undergroundGrass) {
        homeTeam = home;
        awayTeam = away;
        matchDate = date;
        matchStats = new ArrayList<>();
        underground = new Underground(undergroundGrass);
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
    public List<StatsList> getMatchStats() {
        return matchStats;
    }




}
