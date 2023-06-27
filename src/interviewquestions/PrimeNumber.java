package interviewquestions;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        //Write a program to find the given number is prime or not
        System.out.print("Enter a number to find prime or not :");
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        int count = 0;

        for (int i = 1; i <= num; i++) {//2<5
            if (num % i == 0) {
                count++;
            }
        }

        if (count == 2) {
            System.out.println("Given number " + num + " is a prime number ");
        } else {
            System.out.println("Given number " + num + " is NOT a prime number ");
        }
    }

}

