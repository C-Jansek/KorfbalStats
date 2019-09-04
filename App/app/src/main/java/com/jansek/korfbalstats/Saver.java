package com.jansek.korfbalstats;

import java.util.List;

public class Saver {
    Match match;
    List<Player> matchPlayers;


    public void saveMatch(Match thisMatch) {
        match = thisMatch;
        matchPlayers = match.getPlayers();
    }

    private void addStats(Player player) {

    }

}
