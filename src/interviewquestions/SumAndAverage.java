package interviewquestions;

import java.util.Scanner;

public class SumAndAverage {

    public static void main(String[] args) {

        System.out.println("Enter the limit: ");
        Scanner inp = new Scanner(System.in);
        int limit = inp.nextInt(), sum =0, temp;
        float avrg;

        for(int i =1;i<=limit;i++)
        {
            System.out.println("Enter the "+ i+ " number");
            temp = inp.nextInt();
            sum+=temp;
        }

        System.out.println("Sum of "+limit+ " given numbers is :"+sum);
        avrg = sum/limit;
        System.out.println("Average of given "+limit+" numbers is :"+avrg);

    }
}
