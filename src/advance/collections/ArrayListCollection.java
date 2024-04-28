package advance.collections;
/* Collections in java ?
Collections in java is a framework and its an interface. provides an architecture to store and manipulate the group of objects.
*
* Interfaces in Collection framework
* List -> ArrayList, LinkedList, Vector and Stack
* Queue -> PriorityQueue, ArrayDeque
* Set -> HashSet, LinkedHashSet, SortedSet(I)->TreeSet
* Map -> HashMap
*
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*ArrayList is a class that implements List Interface and List extends Collection Interface
 *
 * Conditions to use List:
 * Dynamic Array
 * Heterogeneous data can be stored
 * Insertion order is preserved, can find the element using index, use heap memory
 * Duplicates are allowed to store
 * Mutliple 'null' values are allowed to store
 * Cannot be used for primitive datatypes instead use wrapper class
 * */
public class ArrayListCollection {

    public static void main(String[] args) {

        //Declations
        //List<String> parentList = new ArrayList<String>(); creating an object forArrayList and storing in parent class object
        //ArrayList<String> mylist = new ArrayList<String>(); creating object of arraylist which stores specific data type


        ArrayList mylist = new ArrayList(); //Traditional - All data types are allowed or store object,

        //Add element to the list
        mylist.add("100");
        mylist.add(100);
        mylist.add(12.8);
        mylist.add("Name");
        mylist.add(null);
        mylist.add('A');
        mylist.add(100); // Duplicate
        mylist.add(null); //Mutliple Null


        //Print all the elements
        System.out.println(mylist); // [100, 100, 12.8, Name, null, A, 100, null]

        //Iterate arraylist using iterator

        Iterator itr = mylist.iterator(); //iterator variable

        //Using while loop
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        //use for each loop
        for (Object element : mylist) {
            System.out.println(element);
        }
        //Add a value in specific index
        mylist.add(2, "Inserted");
        System.out.println("List after insertion " + mylist);

        // Sorting of collection will work only with the same datatype like String or Integer
        List<String> nameList = new ArrayList<String>();
        nameList.add("Mohammed");
        nameList.add("JafferAli");
        nameList.add("Wonka");
        nameList.add("Williams");

        System.out.println("List before sorting " + nameList);
        Collections.sort(nameList);
        System.out.println("List after sorting " + nameList);

        //Find the array is empty
        System.out.println(mylist.isEmpty());//Return false

        //Find the size
        System.out.println(mylist.size());

        //remove element
        mylist.remove(0);
        System.out.println("List after removing element from particular index" + mylist);
        mylist.remove("Name");
        System.out.println("List after removing object " + mylist); //

        //Get an element using index
        System.out.println("Get specific element using index " + mylist.get(2));
        //Add element into a specific index
        mylist.add(3, "Name");
        System.out.println("Add specific element using index " + mylist);

        //Create subList from original list
        List sublist = mylist.subList(2, 5); //incldeus 2 but excludes 5
        System.out.println("sub list of mylist " + sublist);

        //Delete all the elements in the list
        nameList.clear();
        System.out.println(nameList.isEmpty());

        //Add name to my lis
        System.out.println(mylist.addAll(sublist)); //return tru is both list are same object type
        System.out.println(mylist); // updated list

        //
        System.out.println(mylist.addAll(nameList)); //return false as both list are NOT same object type
        System.out.println(mylist); // updated list

    }
}
