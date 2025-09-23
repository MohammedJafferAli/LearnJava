// String vs StringBuffer vs StringBuilder comparison

public class StringComparison {
    
    public static void main(String[] args) {
        System.out.println("=== STRING vs STRINGBUFFER vs STRINGBUILDER ===\n");
        
        // 1. String - Immutable
        demonstrateString();
        
        // 2. StringBuffer - Mutable, Thread-safe
        demonstrateStringBuffer();
        
        // 3. StringBuilder - Mutable, Not thread-safe
        demonstrateStringBuilder();
        
        // 4. Performance comparison
        performanceComparison();
    }
    
    private static void demonstrateString() {
        System.out.println("1. STRING (Immutable):");
        
        String str = "Hello";
        System.out.println("Original: " + str);
        System.out.println("Hash code: " + str.hashCode());
        
        str = str + " World"; // Creates new String object
        System.out.println("After concatenation: " + str);
        System.out.println("Hash code: " + str.hashCode()); // Different hash code
        
        // String pool example
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        
        System.out.println("s1 == s2: " + (s1 == s2)); // true (same reference)
        System.out.println("s1 == s3: " + (s1 == s3)); // false (different reference)
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true (same content)
        System.out.println();
    }
    
    private static void demonstrateStringBuffer() {
        System.out.println("2. STRINGBUFFER (Mutable, Thread-safe):");
        
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("Original: " + sb);
        System.out.println("Hash code: " + sb.hashCode());
        
        sb.append(" World"); // Modifies existing buffer
        System.out.println("After append: " + sb);
        System.out.println("Hash code: " + sb.hashCode()); // Same hash code
        
        // Other StringBuffer methods
        sb.insert(5, " Beautiful");
        System.out.println("After insert: " + sb);
        
        sb.delete(5, 15);
        System.out.println("After delete: " + sb);
        
        sb.reverse();
        System.out.println("After reverse: " + sb);
        System.out.println();
    }
    
    private static void demonstrateStringBuilder() {
        System.out.println("3. STRINGBUILDER (Mutable, Not thread-safe):");
        
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Original: " + sb);
        
        sb.append(" World");
        System.out.println("After append: " + sb);
        
        // Method chaining
        sb.append(" from").append(" Java").append("!");
        System.out.println("After chaining: " + sb);
        
        // Capacity management
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
        
        sb.ensureCapacity(100);
        System.out.println("After ensuring capacity: " + sb.capacity());
        System.out.println();
    }
    
    private static void performanceComparison() {
        System.out.println("4. PERFORMANCE COMPARISON:");
        
        int iterations = 10000;
        
        // String concatenation (slowest)
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a"; // Creates new String object each time
        }
        long stringTime = System.currentTimeMillis() - startTime;
        
        // StringBuffer concatenation
        startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long stringBufferTime = System.currentTimeMillis() - startTime;
        
        // StringBuilder concatenation (fastest)
        startTime = System.currentTimeMillis();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sBuilder.append("a");
        }
        long stringBuilderTime = System.currentTimeMillis() - startTime;
        
        System.out.printf("String concatenation: %d ms%n", stringTime);
        System.out.printf("StringBuffer concatenation: %d ms%n", stringBufferTime);
        System.out.printf("StringBuilder concatenation: %d ms%n", stringBuilderTime);
        
        System.out.println("\nRecommendations:");
        System.out.println("• Use String for simple operations and immutable data");
        System.out.println("• Use StringBuffer for thread-safe mutable operations");
        System.out.println("• Use StringBuilder for single-threaded mutable operations");
    }
}
