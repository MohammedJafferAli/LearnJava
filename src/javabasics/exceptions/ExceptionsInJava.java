package javabasics.exceptions;

import java.util.Scanner;

/* What is an exception in java ?
an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions.

Types
1. User defined exceptions
2. Built-in exceptions
    2.a. Checked exceptions - Java verifies checked exceptions at compile-time.
            FileNotFoundException, IOException, ClassNotFoundException.
    2.b. Unchecked exceptions - Java verifies checked exceptions at run-time.
        ex. NullPointerException, ArrayIndexOutOfBoundsException and IllegalArgumentException.
*
* */
public class ExceptionsInJava {

     static void divisionOperation(int num){
        System.out.println(100 / num);
    }
    //Arithmetic exception
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number you want to divide");
        int num = sc.nextInt(); // if 0 is entered then this will throw arithmetic exception
       // ExceptionsInJava.divisionOperation(num);

        //Example 1
        try {
            System.out.println(100 / num);
        }
        catch (ArithmeticException exception)
        {
            System.out.println("Cannot divide a number by 0 ");
        }

//        Example 2
        try {
            String a = null; //null value
            System.out.println(a.charAt(0));
        } catch(NullPointerException e) {
            System.out.println("NullPointerException, value must be a string");
        }

//        Example 3
        try {
            String a = "Exception when String out of range"; // length is 34
            char c = a.charAt(34); // accessing 25th element
            System.out.println(a.length());
            System.out.println(c);
        }
        catch(StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException, enter the position withing the range");
        }
    }
}
