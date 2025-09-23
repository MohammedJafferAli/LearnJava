// Optimized String Reversal - Multiple approaches with performance analysis

public class StringReversal {
    
    // Method 1: Using StringBuilder (Most efficient for general use)
    public static String reverseUsingStringBuilder(String str) {
        if (str == null || str.length() <= 1) return str;
        return new StringBuilder(str).reverse().toString();
    }
    
    // Method 2: Using character array (Best for memory efficiency)
    public static String reverseUsingCharArray(String str) {
        if (str == null || str.length() <= 1) return str;
        
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            // Swap characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    // Method 3: Using recursion (Educational purpose - not efficient for large strings)
    public static String reverseUsingRecursion(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverseUsingRecursion(str.substring(1)) + str.charAt(0);
    }
    
    // Method 4: Using XOR operation (Memory efficient, no temp variable)
    public static String reverseUsingXOR(String str) {
        if (str == null || str.length() <= 1) return str;
        
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            chars[left] = (char) (chars[left] ^ chars[right]);
            chars[right] = (char) (chars[left] ^ chars[right]);
            chars[left] = (char) (chars[left] ^ chars[right]);
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    // Method 5: Using Stack (Good for understanding data structures)
    public static String reverseUsingStack(String str) {
        if (str == null || str.length() <= 1) return str;
        
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
        // Push all characters
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        
        // Pop and build result
        StringBuilder result = new StringBuilder(str.length());
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }
    
    // Method 6: Using two pointers with StringBuilder (Balanced approach)
    public static String reverseUsingTwoPointers(String str) {
        if (str == null || str.length() <= 1) return str;
        
        StringBuilder result = new StringBuilder(str.length());
        for (int i = str.length() - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }
        
        return result.toString();
    }
    
    // Performance testing utility
    private static long measurePerformance(String testString, int iterations, 
                                         java.util.function.Function<String, String> method) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            method.apply(testString);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000; // Convert to milliseconds
    }
    
    public static void main(String[] args) {
        System.out.println("=== OPTIMIZED STRING REVERSAL METHODS ===\n");
        
        String[] testStrings = {
            "Hello World",
            "Java Programming",
            "The quick brown fox jumps over the lazy dog",
            ""
        };
        
        // Test all methods with different inputs
        for (String original : testStrings) {
            if (original.isEmpty()) {
                System.out.println("Testing empty string:");
                original = "";
            } else {
                System.out.println("Original: \"" + original + "\"");
            }
            
            System.out.println("StringBuilder:  \"" + reverseUsingStringBuilder(original) + "\"");
            System.out.println("Character Array: \"" + reverseUsingCharArray(original) + "\"");
            System.out.println("Two Pointers:    \"" + reverseUsingTwoPointers(original) + "\"");
            System.out.println("XOR Operation:   \"" + reverseUsingXOR(original) + "\"");
            System.out.println("Stack:           \"" + reverseUsingStack(original) + "\"");
            
            // Skip recursion for very long strings to avoid stack overflow
            if (original.length() < 100) {
                System.out.println("Recursion:       \"" + reverseUsingRecursion(original) + "\"");
            }
            System.out.println();
        }
        
        // Performance comparison
        System.out.println("=== PERFORMANCE COMPARISON ===");
        String longString = "This is a performance test string that is reasonably long for benchmarking";
        int iterations = 100000;
        
        System.out.printf("Testing with string length: %d, iterations: %d%n", longString.length(), iterations);
        System.out.println();
        
        long time1 = measurePerformance(longString, iterations, StringReversal::reverseUsingStringBuilder);
        System.out.printf("StringBuilder:   %d ms%n", time1);
        
        long time2 = measurePerformance(longString, iterations, StringReversal::reverseUsingCharArray);
        System.out.printf("Character Array: %d ms%n", time2);
        
        long time3 = measurePerformance(longString, iterations, StringReversal::reverseUsingTwoPointers);
        System.out.printf("Two Pointers:    %d ms%n", time3);
        
        long time4 = measurePerformance(longString, iterations, StringReversal::reverseUsingXOR);
        System.out.printf("XOR Operation:   %d ms%n", time4);
        
        long time5 = measurePerformance(longString, iterations, StringReversal::reverseUsingStack);
        System.out.printf("Stack:           %d ms%n", time5);
        
        // Recursion with fewer iterations to avoid stack overflow
        long time6 = measurePerformance(longString, 1000, StringReversal::reverseUsingRecursion);
        System.out.printf("Recursion (1K):  %d ms%n", time6);
        
        // Analysis
        System.out.println("\n=== PERFORMANCE ANALYSIS ===");
        System.out.println("✓ StringBuilder: Best overall performance, built-in optimization");
        System.out.println("✓ Character Array: Memory efficient, good for large strings");
        System.out.println("✓ Two Pointers: Good balance of readability and performance");
        System.out.println("⚠ XOR Operation: Memory efficient but less readable");
        System.out.println("⚠ Stack: Educational value but slower due to object overhead");
        System.out.println("❌ Recursion: Slowest, risk of stack overflow for large strings");
        
        // Edge cases
        System.out.println("\n=== EDGE CASES ===");
        testEdgeCases();
        
        // Best practices
        System.out.println("\n=== BEST PRACTICES ===");
        System.out.println("1. Use StringBuilder for general purpose string reversal");
        System.out.println("2. Use character array for memory-constrained environments");
        System.out.println("3. Always check for null and empty strings");
        System.out.println("4. Consider string length for method selection");
        System.out.println("5. Avoid recursion for production code with large strings");
    }
    
    private static void testEdgeCases() {
        String[] edgeCases = {
            null,
            "",
            "a",
            "ab",
            "aba",
            "abba",
            "12321",
            "A man a plan a canal Panama",
            "!@#$%^&*()",
            "🚀🌟💻" // Unicode characters
        };
        
        System.out.println("Testing edge cases:");
        for (String testCase : edgeCases) {
            try {
                String result = reverseUsingStringBuilder(testCase);
                System.out.printf("Input: %-30s → Output: %s%n", 
                                "\"" + (testCase != null ? testCase : "null") + "\"", 
                                "\"" + (result != null ? result : "null") + "\"");
            } catch (Exception e) {
                System.out.printf("Input: %-30s → Error: %s%n", 
                                "\"" + (testCase != null ? testCase : "null") + "\"", 
                                e.getMessage());
            }
        }
    }
}
