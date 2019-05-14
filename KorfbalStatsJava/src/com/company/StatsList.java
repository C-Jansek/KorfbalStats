package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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



    // ------------ Get stats -------------
    public String getOverhandStat() {
        String percentage;
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        if (shotOverhand>0) {
            percentage = df.format((float)this.goalOverhand/this.shotOverhand*100) + "%";
        }
        else percentage = "0%";
        return this.goalOverhand + " / " + this.shotOverhand + "  -  " + percentage;
    }
    public String getUnderhandStat() {
        String percentage;
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        if (shotUnderhand>0) {
            percentage = df.format((float)this.goalUnderhand/this.shotUnderhand*100) + "%";
        }
        else percentage = "0%";
        return this.goalUnderhand + " / " + this.shotUnderhand + "  -  " + percentage;
    }
    public String getPenaltyStat() {
        String percentage;
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        if (shotPenalty>0) {
            percentage = df.format((float)this.goalPenalty/this.shotPenalty*100) + "%";
        }
        else percentage = "0%";
        return this.goalPenalty + " / " + this.shotPenalty + "  -  " + percentage;
    }
    public String getFreePassStat() {
        String percentage;
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        if (shotFreePass>0) {
            percentage = df.format((float)this.goalFreePass/this.shotFreePass*100) + "%";
        }
        else percentage = "0%";
        return this.goalFreePass + " / " + this.shotFreePass + "  -  " + percentage;
    }




    // ------- Getters and Setters ---------


    public Player getStatsPlayer() {
        return statsPlayer;
    }
    public Match getStatsMatch() {
        return statsMatch;
    }
    public int getShotOverhand() {
        return shotOverhand;
    }
    public int getShotUnderhand() {
        return shotUnderhand;
    }
    public int getShotPenalty() {
        return shotPenalty;
    }
    public int getShotFreePass() {
        return shotFreePass;
    }
    public int getGoalOverhand() {
        return goalOverhand;
    }
    public int getGoalUnderhand() {
        return goalUnderhand;
    }
    public int getGoalPenalty() {
        return goalPenalty;
    }
    public int getGoalFreePass() {
        return goalFreePass;
    }
}
