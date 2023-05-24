package javabasics;

public class StringHandling {

    //
    public static void main(String[] args) {
        // String is class installed by default with java and creating a object is simply write obj name
        String str = "Your order #O12345 has been submitted successfully";
        System.out.println(str.charAt(11));// get the value based on the index
        String str1 = "Your order #O12345 has been submitted successfully";
        System.out.println(str1.indexOf("#")); // Get the index by specifying the string value
        System.out.println(str1.substring(11,18)); // get only the portion of the text/string



    }
}
