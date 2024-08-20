/*
* Array Exploration
Create an Array:

Create a new array called numbers to store 5 numerical values of your choice (they can be whole numbers or decimals).

Access and Print:

Print the following:

The first element of the numbers array.

The last element of the numbers array.

Reverse Order:

Using a loop, print the elements of the numbers array in reverse order.

Element Count:

Calculate the total number of elements within the numbers array.
*
* */


package interviewquestions;

public class WorkWithArrays {


    public static void main(String[] args) {

        int[] numbers = {1, 2, 4, 7, 9};
        int lengthOfTheArray = numbers.length;
        System.out.println(numbers[0]);
        System.out.println(numbers[lengthOfTheArray - 1]);

        int count = 0;
        //Print the array in forward direction
        System.out.println("Printing array in order");
        for (int itr = 0; itr < lengthOfTheArray; itr++) {
            System.out.println(numbers[itr]);
            count += 1;
        }

        //Print the array in reverse direction
        System.out.println("Reversed array");
        for (int itr = lengthOfTheArray - 1; itr > 0; itr--) {
            System.out.println(numbers[itr]);

        }
        System.out.println(count);
    }
}
