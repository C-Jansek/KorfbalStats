package com.jansek.korfbalstats;

import android.app.Activity;
import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import android.content.Context;
import android.os.Environment;

public class Saver extends Activity {
    Match match;
    List<Player> matchPlayers;

    public Saver(Match thisMatch, Context context) {
        saveMatch(thisMatch, context);
        System.out.println("New Saver");
    }

    public void saveMatch(Match thisMatch, Context context) {
        match = thisMatch;
        matchPlayers = match.getPlayers();
        String matchInfo = match.getAwayTeam() + " - " + match.getHomeTeam() + " | " + match.getMatchDate();
        String fileContents = matchInfo + "\n\n" + printHeader();
        FileOutputStream outputStream;
        try {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) + matchInfo + ".csv");
            outputStream = new FileOutputStream(file);
            outputStream.write(fileContents.getBytes());
            for (Player p : matchPlayers) {
                outputStream.write(addStats(p).getBytes());
//                String title = p.getPlayerName() + " with No " + p.getPlayerNo() + " has the following stats: \n";
//                outputStream.write(title.getBytes());
//                int i = 1;
//                for (List<Integer> thisList:p.getPlayerStats()) {
//                    String writeThis = "Shot type " + i + ": " + thisList.get(1) + " / " + thisList.get(0) + "\n";
//                    outputStream.write(writeThis.getBytes());
//                    i++;
//                }
            }

            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(context.getFilesDir().getAbsolutePath());

    }

    private String addStats(Player p) {
        String output = p.getPlayerName() + "," + p.getPlayerNo() + ",";
        for (List<Integer> thisList : p.getPlayerStats()) {
            output = output + thisList.get(1) + "," + thisList.get(0) + ",";
        }
        output = output + "\n";
        return output;
    }

    private String printHeader() {
        String output = "PlayerName,PlayerNo,";
        for (int i = 0; i < Match.getAmountOfShotTypes(); i++) {
            output = output + "Shot type," + (i + 1) + ",";
        }
        output = output + "\n,,";
        for (int i = 0; i < Match.getAmountOfShotTypes(); i++) {
            output = output + "Goals,Shots,";
        }
        output = output + "\n";
        return output;
    }

}
