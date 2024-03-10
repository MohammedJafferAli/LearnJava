package interviewquestions;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        //Write a program to find the perfect number
        // Ex 6 and 28 are perfect numbers. 1st find the factors of the given number and exclude the same number
        //Add the factors and the sum should be equal to the given number

        System.out.print("Enter a number :");
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        int sum =0;

        for(int i =1;i<num;i++){//exclude the = sign to exclude validating the same number ex 6

            if(num%i==0)
            {
               sum+=i;//sum=sum+i;
            }
        }
        if(num==sum)
        { System.out.println("Given number is a prefect number");}
        else{System.out.println("Given number is Not a prefect number");}
    }
}
