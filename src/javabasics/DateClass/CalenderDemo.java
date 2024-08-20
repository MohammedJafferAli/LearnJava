package javabasics.DateClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalenderDemo {
    /*Goal: Work with Calender class in java*/
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/d HH:mm:ss");
        System.out.println(dateFormat.format(calendar.getTime()));
        //Calender as same as Date class but it gives a lot of inbuilt methods to get the uniques values of date and time

        System.out.println("Week of the year "+calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Current Date "+calendar.get(Calendar.DATE));
        System.out.println("Day of the year "+calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Current hour "+calendar.get(Calendar.HOUR_OF_DAY));
    }
}
