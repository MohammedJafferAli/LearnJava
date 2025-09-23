import java.util.*;

// Comprehensive Generics Examples

// Generic class
class Box<T> {
    private T content;
    
    public void set(T content) {
        this.content = content;
    }
    
    public T get() {
        return content;
    }
    
    public boolean isEmpty() {
        return content == null;
    }
}

// Generic class with multiple type parameters
class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() { return key; }
    public V getValue() { return value; }
    
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

// Generic interface
interface Container<T> {
    void add(T item);
    T get(int index);
    int size();
}

// Generic method examples
class Utility {
    
    // Generic method
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // Bounded type parameter
    public static <T extends Number> double sum(List<T> numbers) {
        double total = 0.0;
        for (T number : numbers) {
            total += number.doubleValue();
        }
        return total;
    }
    
    // Multiple bounds
    public static <T extends Number & Comparable<T>> T findMax(List<T> list) {
        if (list.isEmpty()) return null;
        
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}

// Wildcards examples
class WildcardExamples {
    
    // Upper bounded wildcard (? extends T)
    public static double sumOfNumbers(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
    
    // Lower bounded wildcard (? super T)
    public static void addNumbers(List<? super Integer> numbers) {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    // Unbounded wildcard (?)
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
}

public class GenericsExample {
    
    public static void main(String[] args) {
        System.out.println("=== GENERICS EXAMPLES ===\n");
        
        // 1. Generic classes
        demonstrateGenericClasses();
        
        // 2. Generic methods
        demonstrateGenericMethods();
        
        // 3. Bounded type parameters
        demonstrateBoundedTypes();
        
        // 4. Wildcards
        demonstrateWildcards();
        
        // 5. Type erasure
        demonstrateTypeErasure();
        
        // 6. Generic collections
        demonstrateGenericCollections();
    }
    
    private static void demonstrateGenericClasses() {
        System.out.println("1. GENERIC CLASSES:");
        
        // Type safety with generics
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        String value = stringBox.get(); // No casting needed
        System.out.println("String box: " + value);
        
        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        Integer number = intBox.get();
        System.out.println("Integer box: " + number);
        
        // Multiple type parameters
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println("Pair: " + pair);
        
        System.out.println();
    }
    
    private static void demonstrateGenericMethods() {
        System.out.println("2. GENERIC METHODS:");
        
        // Generic method usage
        String[] names = {"Alice", "Bob", "Charlie"};
        System.out.println("Before swap: " + Arrays.toString(names));
        Utility.swap(names, 0, 2);
        System.out.println("After swap: " + Arrays.toString(names));
        
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Before swap: " + Arrays.toString(numbers));
        Utility.swap(numbers, 1, 3);
        System.out.println("After swap: " + Arrays.toString(numbers));
        
        System.out.println();
    }
    
    private static void demonstrateBoundedTypes() {
        System.out.println("3. BOUNDED TYPE PARAMETERS:");
        
        // Bounded type parameter - extends Number
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        
        System.out.println("Sum of integers: " + Utility.sum(integers));
        System.out.println("Sum of doubles: " + Utility.sum(doubles));
        
        // Multiple bounds - extends Number & Comparable
        System.out.println("Max integer: " + Utility.findMax(integers));
        System.out.println("Max double: " + Utility.findMax(doubles));
        
        System.out.println();
    }
    
    private static void demonstrateWildcards() {
        System.out.println("4. WILDCARDS:");
        
        // Upper bounded wildcard (? extends Number)
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        
        System.out.println("Sum of integers: " + WildcardExamples.sumOfNumbers(intList));
        System.out.println("Sum of doubles: " + WildcardExamples.sumOfNumbers(doubleList));
        
        // Lower bounded wildcard (? super Integer)
        List<Number> numberList = new ArrayList<>();
        WildcardExamples.addNumbers(numberList);
        System.out.println("Numbers added: " + numberList);
        
        // Unbounded wildcard (?)
        List<String> stringList = Arrays.asList("A", "B", "C");
        System.out.print("String list: ");
        WildcardExamples.printList(stringList);
        
        System.out.println();
    }
    
    private static void demonstrateTypeErasure() {
        System.out.println("5. TYPE ERASURE:");
        
        // Type information is erased at runtime
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        
        // Both have the same class at runtime
        System.out.println("String list class: " + stringList.getClass());
        System.out.println("Integer list class: " + integerList.getClass());
        System.out.println("Same class? " + (stringList.getClass() == integerList.getClass()));
        
        System.out.println();
    }
    
    private static void demonstrateGenericCollections() {
        System.out.println("6. GENERIC COLLECTIONS:");
        
        // Before generics (raw types) - not recommended
        List rawList = new ArrayList();
        rawList.add("String");
        rawList.add(123);
        rawList.add(45.67);
        
        // Requires casting and can cause ClassCastException
        for (Object obj : rawList) {
            System.out.println("Raw list item: " + obj);
        }
        
        // With generics - type safe
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        // stringList.add(123); // Compilation error
        
        for (String str : stringList) {
            System.out.println("Generic list item: " + str.toUpperCase());
        }
        
        // Generic Map
        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("Alice", 25);
        ageMap.put("Bob", 30);
        
        for (Map.Entry<String, Integer> entry : ageMap.entrySet()) {
            System.out.println(entry.getKey() + " is " + entry.getValue() + " years old");
        }
        
        System.out.println("\nBenefits of Generics:");
        System.out.println("• Type safety at compile time");
        System.out.println("• Elimination of type casting");
        System.out.println("• Code reusability");
        System.out.println("• Better performance (no boxing/unboxing)");
    }
}
