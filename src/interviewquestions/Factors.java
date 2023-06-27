package interviewquestions;

import java.util.Scanner;

public class Factors {

    public static void main(String[] args) {
        //Write a program to find the factors of the givcen number
        // when you divide a number by 1 and other numbers and you get reminder as 0 then those numbers are factors of the given number
        Scanner inp = new Scanner(System.in); //
        System.out.print("Enter a number to find the factors :");
        int n = inp.nextInt();
        for(int i=1;i<=n;i++){

            if(n%i==0)
            { System.out.print(  i +"\t");}
        }
    }
}
