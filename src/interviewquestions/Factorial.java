package interviewquestions;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args)
    {

        System.out.println("Enter the number to find dactorial: ");
        Scanner inp = new Scanner(System.in);
        int number = inp.nextInt();
        int temp =1;
        for (int itr =1;itr<=number;itr++)
        {
            temp =temp*itr;
        }
        System.out.println(temp);

    }


}
