package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Match {

    String homeTeam;
    String awayTeam;
    Date matchDate;

    List<StatsList> matchStats;

    public Match (String home, String away, Date date) {
        homeTeam = home;
        awayTeam = away;
        matchDate = date;
        matchStats = new ArrayList<>();
    }


}
