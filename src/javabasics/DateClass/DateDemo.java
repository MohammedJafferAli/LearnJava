package javabasics.DateClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

    /* Goal : Java supports date feature by default from the utils package.
    import those package, get classes and methods in our program
    1. Get the value customised format
    //Refer this link for more details - https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html

    * */
    public static void main(String[] args) {

        //Create an object for Date Class
        Date date = new Date();
        System.out.println(date.toString());//Print the current date in default format

        //Customise date format using SimpleDateFormat class in java
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/YYYY");
        System.out.println(dateFormat.format(date));

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("YYYYMMd_HHmmss");
        System.out.println(dateFormat1.format(date));

    }
}
