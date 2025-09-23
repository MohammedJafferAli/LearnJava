import java.util.*;

// Optimized Array Operations with comprehensive error handling and performance improvements

public class ArrayOperations {
    
    // 1. Reverse array in-place (O(n) time, O(1) space)
    public static void reverseArray(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // Swap using XOR to avoid temporary variable
            arr[left] ^= arr[right];
            arr[right] ^= arr[left];
            arr[left] ^= arr[right];
            left++;
            right--;
        }
    }
    
    // 2. Find second largest number (O(n) time, O(1) space)
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("All elements are the same");
        }
        
        return secondLargest;
    }
    
    // 3. Remove duplicates from sorted array (O(n) time, O(1) space)
    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return 1;
        
        int writeIndex = 1;
        for (int readIndex = 1; readIndex < arr.length; readIndex++) {
            if (arr[readIndex] != arr[readIndex - 1]) {
                arr[writeIndex++] = arr[readIndex];
            }
        }
        return writeIndex;
    }
    
    // 4. Move zeros to end while maintaining relative order (O(n) time, O(1) space)
    public static void moveZerosToEnd(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int writeIndex = 0;
        
        // Move all non-zero elements to the front
        for (int readIndex = 0; readIndex < arr.length; readIndex++) {
            if (arr[readIndex] != 0) {
                arr[writeIndex++] = arr[readIndex];
            }
        }
        
        // Fill remaining positions with zeros
        Arrays.fill(arr, writeIndex, arr.length, 0);
    }
    
    // 5. Find missing number in array containing 1 to n (O(n) time, O(1) space)
    public static int findMissingNumber(int[] arr, int n) {
        if (arr == null) throw new IllegalArgumentException("Array cannot be null");
        if (arr.length != n - 1) throw new IllegalArgumentException("Array length should be n-1");
        
        // Using mathematical formula: sum of 1 to n = n*(n+1)/2
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;
        
        for (int num : arr) {
            actualSum += num;
        }
        
        return (int) (expectedSum - actualSum);
    }
    
    // 6. Maximum consecutive ones (O(n) time, O(1) space)
    public static int maxConsecutiveOnes(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        int maxCount = 0;
        int currentCount = 0;
        
        for (int num : arr) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }
        
        return maxCount;
    }
    
    // 7. First and last position of target (O(log n) time using binary search)
    public static int[] findFirstLastPosition(int[] arr, int target) {
        if (arr == null || arr.length == 0) return new int[]{-1, -1};
        
        int first = findFirstPosition(arr, target);
        if (first == -1) return new int[]{-1, -1};
        
        int last = findLastPosition(arr, target);
        return new int[]{first, last};
    }
    
    private static int findFirstPosition(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private static int findLastPosition(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    // 8. Product of array except self (O(n) time, O(1) extra space)
    public static int[] productExceptSelf(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];
        
        int n = arr.length;
        int[] result = new int[n];
        
        // Calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }
        
        // Calculate right products and multiply with left products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= arr[i];
        }
        
        return result;
    }
    
    // 9. Check if arrays have same elements (O(n log n) time)
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return true;
        if (arr1 == null || arr2 == null) return false;
        if (arr1.length != arr2.length) return false;
        
        // Create copies to avoid modifying original arrays
        int[] copy1 = arr1.clone();
        int[] copy2 = arr2.clone();
        
        Arrays.sort(copy1);
        Arrays.sort(copy2);
        
        return Arrays.equals(copy1, copy2);
    }
    
    // 10. Longest consecutive sequence (O(n) time, O(n) space)
    public static int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }
        
        int longestStreak = 0;
        
        for (int num : numSet) {
            // Only start counting if this is the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
    
    // 11. Rotate array right by k positions (O(n) time, O(1) space)
    public static void rotateRight(int[] arr, int k) {
        if (arr == null || arr.length <= 1 || k == 0) return;
        
        int n = arr.length;
        k = k % n; // Handle k > n
        
        // Reverse entire array
        reverse(arr, 0, n - 1);
        // Reverse first k elements
        reverse(arr, 0, k - 1);
        // Reverse remaining elements
        reverse(arr, k, n - 1);
    }
    
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    // 12. Find peak element (O(log n) time using binary search)
    public static int findPeakElement(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return 0;
        
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        System.out.println("=== OPTIMIZED ARRAY OPERATIONS ===\n");
        
        // Test all operations with comprehensive examples
        demonstrateArrayOperations();
        
        // Performance testing
        System.out.println("\n=== PERFORMANCE TESTING ===");
        performanceTest();
        
        // Edge cases testing
        System.out.println("\n=== EDGE CASES TESTING ===");
        testEdgeCases();
    }
    
    private static void demonstrateArrayOperations() {
        // 1. Reverse array
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("1. Reverse Array:");
        System.out.println("Original: " + Arrays.toString(arr1));
        reverseArray(arr1);
        System.out.println("Reversed: " + Arrays.toString(arr1));
        
        // 2. Second largest
        int[] arr2 = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("\n2. Second Largest:");
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Second largest: " + findSecondLargest(arr2));
        
        // 3. Remove duplicates
        int[] arr3 = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.println("\n3. Remove Duplicates:");
        System.out.println("Original: " + Arrays.toString(arr3));
        int newLength = removeDuplicates(arr3);
        System.out.println("After removal: " + Arrays.toString(Arrays.copyOf(arr3, newLength)));
        
        // 4. Move zeros
        int[] arr4 = {0, 1, 0, 3, 12, 0, 5};
        System.out.println("\n4. Move Zeros to End:");
        System.out.println("Original: " + Arrays.toString(arr4));
        moveZerosToEnd(arr4);
        System.out.println("After moving: " + Arrays.toString(arr4));
        
        // 5. Missing number
        int[] arr5 = {1, 2, 4, 5, 6};
        System.out.println("\n5. Find Missing Number:");
        System.out.println("Array: " + Arrays.toString(arr5));
        System.out.println("Missing number (1-6): " + findMissingNumber(arr5, 6));
        
        // 6. Max consecutive ones
        int[] arr6 = {1, 1, 0, 1, 1, 1, 0, 1};
        System.out.println("\n6. Max Consecutive Ones:");
        System.out.println("Array: " + Arrays.toString(arr6));
        System.out.println("Max consecutive ones: " + maxConsecutiveOnes(arr6));
        
        // 7. First and last position
        int[] arr7 = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println("\n7. First and Last Position:");
        System.out.println("Array: " + Arrays.toString(arr7));
        System.out.println("Positions of " + target + ": " + Arrays.toString(findFirstLastPosition(arr7, target)));
        
        // 8. Product except self
        int[] arr8 = {1, 2, 3, 4};
        System.out.println("\n8. Product Except Self:");
        System.out.println("Array: " + Arrays.toString(arr8));
        System.out.println("Product except self: " + Arrays.toString(productExceptSelf(arr8)));
        
        // 9. Array equality
        int[] arr9a = {1, 2, 3};
        int[] arr9b = {3, 1, 2};
        System.out.println("\n9. Array Equality:");
        System.out.println("Array 1: " + Arrays.toString(arr9a));
        System.out.println("Array 2: " + Arrays.toString(arr9b));
        System.out.println("Are equal: " + areArraysEqual(arr9a, arr9b));
        
        // 10. Longest consecutive
        int[] arr10 = {100, 4, 200, 1, 3, 2};
        System.out.println("\n10. Longest Consecutive Sequence:");
        System.out.println("Array: " + Arrays.toString(arr10));
        System.out.println("Longest consecutive: " + longestConsecutive(arr10));
        
        // 11. Rotate array
        int[] arr11 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("\n11. Rotate Array Right:");
        System.out.println("Original: " + Arrays.toString(arr11));
        rotateRight(arr11, 3);
        System.out.println("Rotated by 3: " + Arrays.toString(arr11));
        
        // 12. Peak element
        int[] arr12 = {1, 2, 3, 1};
        System.out.println("\n12. Find Peak Element:");
        System.out.println("Array: " + Arrays.toString(arr12));
        System.out.println("Peak element index: " + findPeakElement(arr12));
    }
    
    private static void performanceTest() {
        int[] largeArray = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = random.nextInt(1000);
        }
        
        long startTime = System.currentTimeMillis();
        longestConsecutive(largeArray);
        long endTime = System.currentTimeMillis();
        
        System.out.printf("Longest consecutive on 1M elements: %d ms%n", endTime - startTime);
        
        startTime = System.currentTimeMillis();
        findSecondLargest(largeArray);
        endTime = System.currentTimeMillis();
        
        System.out.printf("Second largest on 1M elements: %d ms%n", endTime - startTime);
    }
    
    private static void testEdgeCases() {
        System.out.println("Testing edge cases:");
        
        // Test with null arrays
        try {
            findSecondLargest(null);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Null array handled: " + e.getMessage());
        }
        
        // Test with single element
        try {
            findSecondLargest(new int[]{5});
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Single element handled: " + e.getMessage());
        }
        
        // Test with all same elements
        try {
            findSecondLargest(new int[]{5, 5, 5, 5});
        } catch (IllegalArgumentException e) {
            System.out.println("✓ All same elements handled: " + e.getMessage());
        }
        
        // Test empty array
        System.out.println("✓ Empty array max consecutive ones: " + maxConsecutiveOnes(new int[]{}));
        
        // Test array with no target
        System.out.println("✓ Target not found: " + Arrays.toString(findFirstLastPosition(new int[]{1, 2, 3}, 5)));
    }
}
