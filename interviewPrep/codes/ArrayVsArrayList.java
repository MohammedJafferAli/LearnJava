import java.util.ArrayList;
import java.util.Arrays;

public class ArrayVsArrayList {
    public static void main(String[] args) {
        // Array example
        System.out.println("=== ARRAY EXAMPLE ===");
        int[] array = new int[5]; // Fixed size
        array[0] = 10;
        array[1] = 20;
        array[2] = 30;
        
        System.out.println("Array length: " + array.length);
        System.out.println("Array elements: " + Arrays.toString(array));
        
        // Cannot resize array
        // array[5] = 50; // This would throw ArrayIndexOutOfBoundsException
        
        // ArrayList example
        System.out.println("\n=== ARRAYLIST EXAMPLE ===");
        ArrayList<Integer> arrayList = new ArrayList<>(); // Dynamic size
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);
        
        System.out.println("ArrayList size: " + arrayList.size());
        System.out.println("ArrayList elements: " + arrayList);
        
        // Dynamic operations
        arrayList.add(2, 25); // Insert at index 2
        System.out.println("After insertion: " + arrayList);
        
        arrayList.remove(0); // Remove first element
        System.out.println("After removal: " + arrayList);
        
        // ArrayList methods
        System.out.println("Contains 30: " + arrayList.contains(30));
        System.out.println("Index of 40: " + arrayList.indexOf(40));
        
        // Performance comparison
        System.out.println("\n=== PERFORMANCE COMPARISON ===");
        
        // Array access - O(1)
        long startTime = System.nanoTime();
        int value = array[2];
        long endTime = System.nanoTime();
        System.out.println("Array access time: " + (endTime - startTime) + " ns");
        
        // ArrayList access - O(1) but with method call overhead
        startTime = System.nanoTime();
        int value2 = arrayList.get(2);
        endTime = System.nanoTime();
        System.out.println("ArrayList access time: " + (endTime - startTime) + " ns");
        
        // Memory usage
        System.out.println("\n=== MEMORY USAGE ===");
        System.out.println("Array stores primitives directly");
        System.out.println("ArrayList stores Integer objects (boxing/unboxing overhead)");
        
        // Primitive array
        int[] primitiveArray = {1, 2, 3, 4, 5};
        
        // ArrayList with autoboxing
        ArrayList<Integer> boxedList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            boxedList.add(i); // Autoboxing: int -> Integer
        }
        
        System.out.println("Primitive array: " + Arrays.toString(primitiveArray));
        System.out.println("Boxed ArrayList: " + boxedList);
    }
}
