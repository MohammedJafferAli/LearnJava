package oops.inhertanceconcept;


/*The final method in Java is used as a non-access modifier applicable only to a variable, a method, or a class.
It is used to restrict a user in Java.
 * Final Variable - To create constant variable
 Final Methods -    Prevent method overriding
 Final class - Prevent inheritance
 *
 */


public class FinalKeyWordVar {



    public static void main(String[] args) {

        final double PI = 3.14159;

        final int THRESHOLD = 5;

        System.out.println(PI);
        System.out.println(THRESHOLD);

//        THRESHOLD = 10;
    }
}
