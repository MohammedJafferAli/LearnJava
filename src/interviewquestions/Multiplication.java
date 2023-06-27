package interviewquestions;

import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        //Write a program to print a multiplication table of any number

        Scanner inp = new Scanner(System.in);

        System.out.println("Enter the table :");
        int table = inp.nextInt();
        System.out.println("Enter the limit :");
        int limit = inp.nextInt();

        for(int i = 1;i<=limit;i++){

            System.out.println(table +" x "+ i + " = " +(table*i));
        }
    }
}
