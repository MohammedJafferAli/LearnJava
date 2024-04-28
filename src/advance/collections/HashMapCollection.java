package advance.collections;


/* HashMap is a class that implements Map Interface. Where the data are stored in the form key & value pair.
 * ex. Person name and their mobile number
 * Country name and captial
 * # Conditions to use Hashset:
 * Keys should not be duplicated but values can be duplicated.
 * Insertion order is not preserved
 *
 * */


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapCollection {

    public static void main(String[] args) {

        //Declaration
        // HashMap hashMap = new HashMap();
        //Map mymap = new HashMap();

        // Define the key value pair Data type example ID & username is Integer & String type
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

        //Add data to the map
        hashMap.put(101, "Ajith");
        hashMap.put(100, "David");
        hashMap.put(100, "Dharan");//Value will be replaced with the new value if the same key is duplicated
        hashMap.put(102, "Jaffer");

        //Print the map data
        System.out.println(hashMap); //{100=Dharan, 101=Ajith, 102=Jaffer} as a list

        //Find the size
        System.out.println(hashMap.size());

        //Remove any element by passing the key or key&pair
        System.out.println("After removing a specific data from the map: " + hashMap.remove(100));

        //access any particular data
        System.out.println("Access the element using key: " + hashMap.get(102));

        //Return only the keys
        System.out.println(hashMap.keySet()); //return keys in a set

        //Return only the values
        System.out.println(hashMap.values()); //return keys in a set

        //Return both key&values
        System.out.println(hashMap.entrySet()); //return keys in a set

        // Find the map is empty
        System.out.println(hashMap.isEmpty()); //return false

        /*Read the data in the map
         * Using enhance for loop
         */
        System.out.println("Key     Value ");
        for (Integer K : hashMap.keySet())
        {
            System.out.println(K+"     "+hashMap.get(K));
        }
        //Using Iterator but the data should be in set format
        Iterator<Map.Entry<Integer, String>> itr = hashMap.entrySet().iterator();

        System.out.println("Reading data using iterator...");
        while (itr.hasNext())
        {

            Map.Entry entry = itr.next();
            System.out.println(entry.getKey()+"     "+ entry.getValue());
        }

        //Clear the entire map collection
        hashMap.clear();

        System.out.println(hashMap.isEmpty()); //return true
    }
}
