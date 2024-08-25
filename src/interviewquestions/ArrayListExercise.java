package interviewquestions;

import java.util.ArrayList;
import java.util.Iterator;

/* Goals:
1. Create a list accept only strings and add fruits name
2. Remove the 1st occurrence of apple
3. Print a message when orange present in the list
4. Print the size of array
* */

public class ArrayListExercise {
   public static ArrayList<String> fruitList = new ArrayList<String>();
    public static void main(String[] args) {
       //#1

        fruitList.add("apple");
        fruitList.add("banana");
        fruitList.add("cherry");
        fruitList.add("mango");
        fruitList.add("apple");
        printFruitList();

        //#2
       // System.out.println(fruitList.lastIndexOf("apple")); find the last occurrence
        int indexOfElement = fruitList.indexOf("apple");
        fruitList.remove(indexOfElement);
        printFruitList();

        //#3
        if (fruitList.contains("orange"))
        {
            System.out.println("Orange found in the list of fruits");
        }
        //#4
        System.out.println("Size of the fruit list "+ fruitList.size());

        Iterator iterator = fruitList.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
   static void printFruitList()
    {
        System.out.println(fruitList);
    }
}
