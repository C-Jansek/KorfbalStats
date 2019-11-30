package com.jansek.korfbalstats;

import java.util.ArrayList;
import java.util.List;

public class db {
    static private List<Team> teams;
    private List<Match> allMatches;
    static private List<Player> allPlayers;
    static private Team currentTeam;
    static private Match currentMatch;

    public db () {
        teams = new ArrayList<>();
        allMatches = new ArrayList<>();
        allPlayers = new ArrayList<>();
        this.createTeams();
        currentTeam = teams.get(0);
    }

    public void createTeams() {
        createPlayers();
//        Team s1 = new Team("Gemini 1");
//        Team s2 = new Team("Gemini 2");
//        Team a1 = new Team("Gemini A1");
//        Team a2 = new Team("Gemini A2");


    }

    public void createPlayers() {
        // 1e
        Player roelant = new Player("Roelant", "H","Gemini 1");
        Player gijs = new Player("Gijs", "H","Gemini 1");
        Player ingrid = new Player("Ingrid", "D", "Gemini 1");
        Player nanda = new Player("Nanda", "D", "Gemini 1");

        Player david = new Player("David", "H", "Gemini 1");
        Player maiko = new Player("Maiko", "H","Gemini 1");
        Player michelle = new Player("Michelle", "D", "Gemini 1");
        Player lysanne = new Player("Lysanne", "D", "Gemini 1");

        Player bertJan = new Player("Bert-Jan", "H", "Gemini 1");
        Player agnes = new Player("Agnes", "D", "Gemini 1");

        // 2e
        Player andre = new Player("André", "H", "Gemini 2");
        Player sebastiaan = new Player("Sebastiaan", "H", "Gemini 2");
        Player wieke = new Player("Wieke", "D", "Gemini 2");
        Player esther = new Player("Esther", "D", "Gemini 2");

        Player frank = new Player("Frank", "H", "Gemini 2");
        Player mathew = new Player("Mathew", "H", "Gemini 2");
        Player fenna = new Player("Fenna", "D", "Gemini 2");
        Player hanke = new Player("Hanke", "D", "Gemini 2");

        Player laura = new Player("Laura", "D", "Gemini 2");

        //A1
        Player christiaan = new Player("Christiaan", "H", "Gemini A1");
        Player jouri = new Player("Jouri", "H", "Gemini A1");
        Player simone = new Player("Simone", "D", "Gemini A1");
        Player annefleur = new Player("Anne-Fleur", "D", "Gemini A1");

        Player davy = new Player("Davy", "H", "Gemini A1");
        Player jasper = new Player("Jasper", "H", "Gemini A1");
        Player indira = new Player("Indira", "D", "Gemini A1");
        Player desanne = new Player("Désanne", "D", "Gemini A1");

        //A2
        Player ryan = new Player("Ryan", "H", "Gemini A1");
        Player nathan = new Player("Nathan", "H", "Gemini A2");
        Player eva = new Player("Eva", "D", "Gemini A2");
        Player marloes = new Player("Marloes", "D", "Gemini A1");

        Player fabian = new Player("Fabian", "H", "Gemini A2");
        Player jochem = new Player("Jochem", "H", "Gemini A2");
        Player myrthe = new Player("Myrthe", "D", "Gemini A2");
        Player jasmijn = new Player("Jasmijn", "D", "Gemini A2");

        Player joris = new Player("Joris", "H", "Gemini A2");
    }

    static public boolean teamExists(String name) {
        for (Team t: teams) {
            if (t.getTeamName() == name) {
                return true;
            }
        }
        Team thisTeam = new Team(name);
        teams.add(thisTeam);
        return true;
    }

    public static Team findTeamByName(String name) {
        for (Team t: teams) {
            if (t.getTeamName() == name) {
                return t;
            }
        }
        return null;
    }

    static public void addToAllPlayers(Player p) {allPlayers.add(p);}



    //Getters and Setters

    public static List<Team> getTeams() {
        return teams;
    }

    public static void setTeams(List<Team> teams) {
        db.teams = teams;
    }

    public List<Match> getAllMatches() {
        return allMatches;
    }

    public void setAllMatches(List<Match> allMatches) {
        this.allMatches = allMatches;
    }

    public static List<Player> getAllPlayers() {
        return allPlayers;
    }

    public static void setAllPlayers(List<Player> allPlayers) {
        db.allPlayers = allPlayers;
    }

    public static Team getCurrentTeam() {
        return currentTeam;
    }

    public static void setCurrentTeam(Team currentTeam) {
        db.currentTeam = currentTeam;
    }

    public static Match getCurrentMatch() {
        return currentMatch;
    }

    public static void setCurrentMatch(Match currentMatch) {
        db.currentMatch = currentMatch;
    }
}
