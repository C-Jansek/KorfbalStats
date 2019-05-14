package com.company;

public class StatsList {
    private Player statsPlayer;
    private Match statsMatch;
//    int playTime;

    private int shotOverhand = 0;
    private int shotUnderhand = 0;
    private int shotPenalty = 0;
    private int shotFreePass = 0;

    private int goalOverhand = 0;
    private int goalUnderhand = 0;
    private int goalPenalty = 0;
    private int goalFreePass = 0;

    public StatsList (Player player, Match match) {
        statsPlayer = player;
        statsMatch = match;
    }

    public void addOne(boolean goal, String kindOfShot) {
        switch (kindOfShot) {
            case "Overhand":
                shotOverhand++;
                if (goal) {goalOverhand++;}
                break;
            case "Underhand":
                shotUnderhand++;
                if (goal) {goalUnderhand++;}
                break;
            case "Penalty":
                shotPenalty++;
                if (goal) {goalPenalty++;}
                break;
            case "FreePass":
                shotFreePass++;
                if (goal) {goalFreePass++;}
                break;
        }
    }

}
