package advance.collections;
/* HashSet is a class that implements Set Interface and Set extends Collection Interface
 *
 * Conditions to use Hashset:
 * HashSet contains unique elements only.
 * Dynamic size
 * Heterogeneous data can be stored
 * Insertion order is NOT preserved, cannot find the element using index, use hash memory
 * Duplicates are NOT allowed to store, no compile time or run time error but the data won't be stored.
 * ONly one 'null' values is allowed to store
 * Cannot be used for primitive datatypes instead use wrapper class
 * */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetCollection {


    public static void main(String[] args) {

        HashSet myset = new HashSet<>();
       /* Set myset = new HashSet();
        HashSet<String> strSet = new HashSet<String>();*/

        //Adding values to the set
        myset.add("Mohammed");
        myset.add("JafferAli");
        myset.add(100);
        myset.add(12.28);
        myset.add(100);
        myset.add(null);
        myset.add(null);

        //print the set
        System.out.println(myset); // [null, JafferAli, 100, Mohammed, 12.28] - insertion order not preserved

        //Check an element
        System.out.println(myset.contains(100));// return true if the object contains in the element

        //Remove an element - by giving the value
        System.out.println(myset.remove(12.28));
        System.out.println("List after removing the particualr object " + myset);

        //Fins the size of set
        System.out.println(myset.size());

        //Find the set is empty or not
        System.out.println(myset.isEmpty()); //return truw if set is empty

        //iterate the elements in the set
        Iterator itr = myset.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        //Remove all
        myset.clear();
        System.out.println(myset.isEmpty()); // Return true

    }


}
