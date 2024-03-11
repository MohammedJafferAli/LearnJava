package interviewquestions;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {


        System.out.println("Enter the number to find the fibonacci series :");
        Scanner inp = new Scanner(System.in);

        int limit = inp.nextInt();
        int a = -1, b = 1, sum;
        for (int i = 1; i <= limit; i++) {
            sum = a + b; //-1+1=0+1=1+0=1+
            System.out.println(" fibonacci series :" + sum); //0 1 1 2 3
            a = b; // 1 0 1 1 2
            b = sum;// 0 1 1 2 3
        }

    }
}
