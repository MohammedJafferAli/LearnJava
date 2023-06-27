package interviewquestions;

import java.util.Scanner;

public class ArmstrongNmber {
    //Write a program to check whether the given 3 digit number is armstrong number
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        System.out.println("Enter a 3 digit number: ");
        int number = inp.nextInt(); //153
        int temp = number; //153
        int digit1, digit2, digit3, sum;

        digit1 = temp % 10;//3
        temp = temp / 10;//15

        digit2 = temp % 10; //5
        temp = temp / 10;//1

        digit3 = temp % 10; //1

        sum = (digit1 * digit1 * digit1) + (digit2 * digit2 * digit2) + (digit3 * digit3 * digit3);//27+125+1= 153
        System.out.println(sum);
        if (sum == number) {
            System.out.println("Givem number " + number + " is a Armstrong number");
        } else {
            System.out.println("Givem number " + number + " is NOT a Armstrong number");
        }


    }
}
