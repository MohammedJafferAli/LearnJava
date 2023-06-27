package interviewquestions;

import java.util.Scanner;

public class StrongNumber {

    public static void main(String[] args) {
        //Write a program to check whether given number is strong or not
        // ex 145 . find factorial for each digit , sum it, check with original number if its same then strong
        System.out.print("Enter a number :");
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        int originalNum, rem,fact,i,sum=0;
        originalNum = num; //145

        while (num > 0) {
            //find the reminder
            rem = num % 10; //5 4 1
            System.out.println("Reminder : " + rem);
            //find the factorial of the above reminder
            fact=1;
            for (i=1;i<=rem;i++){
                fact=fact*i;
            }
            System.out.println("Factorial : " + fact);
            sum=sum+fact;//0+120=120+24=144+1=145
            num = num / 10;//14 1 0
        }
        if(sum==originalNum){
            System.out.println("Given number is a STRONG number" );
        }
    }
}
