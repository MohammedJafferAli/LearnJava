package interviewquestions;

public class ArmstrongNumber100 {

    public static void main(String[] args) {

        int digit1, digit2, digit3, sum, temp;

        for (int i = 100; i <= 999; i++) {

            temp =i;

            digit1 = temp% 10;//3
            temp= temp/ 10;//15

            digit2 = temp% 10; //5
            temp= temp/ 10;//1

            digit3 = temp% 10; //1

            sum = (digit1 * digit1 * digit1) + (digit2 * digit2 * digit2) + (digit3 * digit3 * digit3);//27+125+1= 153
            if (sum == i) {
                System.out.println("Givem number " + sum + " is a Armstrong number");}
//            } else {
//                System.out.println("Givem number " + sum + " is NOT a Armstrong number");
//            }
        }
    }
}
