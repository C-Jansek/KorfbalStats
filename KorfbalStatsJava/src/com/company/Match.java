package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Match {

    private String homeTeam;
    private String awayTeam;
    private String matchDate;

    List<StatsList> matchStats;

    public Match (String home, String away, String date) {
        homeTeam = home;
        awayTeam = away;
        matchDate = date;
        matchStats = new ArrayList<>();
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
