package interviewquestions;

import java.util.Scanner;

public class Fibonacci
{

    public static void main(String[] args) {


        System.out.println("Enter the number to find the fibonacci series :");
        Scanner inp = new Scanner(System.in);

        int limit = inp.nextInt();
        int init =-1, start =1,temp ;
        for (int i =1;i<=limit;i++)
        {
            temp = init+start;
            System.out.println(" fibonacci series :"+temp);

            init = start;
            start = temp;
        }


    }
}
