package interviewquestions;

import java.util.Scanner;

public class Palindrome {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String : ");

        String s = scan.nextLine();
        StringBuilder temp = new StringBuilder();

        for (int i = s.length()-1; i >= 0;i--){

            temp.append(s.charAt(i));
        }
        System.out.println(temp);

        if(s.equals(temp.toString())){

            System.out.println("Given string "+s+" is palindrome");

        }
        else {
            System.out.println("Given string "+s+" is NOT palindrome");
        }
    }
}
