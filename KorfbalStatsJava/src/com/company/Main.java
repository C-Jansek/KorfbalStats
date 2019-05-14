package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Player jasper = new Player("Jasper");

        String thisDate = "18 mrt 2019, 12:30";
        Match firstMatch = new Match("Gemini A1", "IJselvogels A3", thisDate);
        StatsList thisList = new StatsList(jasper, firstMatch);

        jasper.addPlayerStatsList(thisList);
        jasper.printPlayerStats();

    }

//    private getStats () {
//        this.shots();
//    }

    /*//Calendar implement
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;
        import java.util.GregorianCalendar;


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(new Date());
        Date thisDate = format.parse("2019-05-18");
        Calendar thisDate = new GregorianCalendar();
        thisDate.set(2019,05,18,12,30);
    */
}
