package interviewquestions;

import java.util.Scanner;

public class PrimeNumber_n {
    public static void main(String[] args) {
        //write a program to find the primes within the given range

        System.out.print("Enter a range :");
        Scanner inp = new Scanner(System.in);
        int range = inp.nextInt();
        int count = 0;
        for (int j = 1; j <= range; j++) {

            for (int i = 1; i <= j; i++) { //1<5
                if (j % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(j+"\t");
            }
            count =0;
        }
    }
}
