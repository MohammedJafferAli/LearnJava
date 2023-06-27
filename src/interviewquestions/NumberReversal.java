package interviewquestions;

import java.util.Scanner;

public class NumberReversal {
    public static void main(String[] args) {

        System.out.println("Enter the number to reverse :");
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();

        int reverse=0,rem;
        while(num!=0)
        {
            rem=num%10;
            reverse = (reverse*10)+rem;
            num = num/10;

        }
System.out.println("Reverse of Given number is "+reverse);


    }
}
