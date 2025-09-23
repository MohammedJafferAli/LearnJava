import java.io.*;
import java.util.*;

// Comprehensive Exception Handling Examples

// Custom checked exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Custom unchecked exception
class InvalidAccountException extends RuntimeException {
    public InvalidAccountException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;
    private String accountNumber;
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    // Method that throws checked exception
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Balance: " + balance);
        }
        balance -= amount;
    }
    
    // Method that throws unchecked exception
    public void validateAccount() {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new InvalidAccountException("Account number cannot be null or empty");
        }
    }
    
    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
}

public class ExceptionHandling {
    
    public static void main(String[] args) {
        System.out.println("=== EXCEPTION HANDLING EXAMPLES ===\n");
        
        // 1. Basic try-catch
        demonstrateBasicTryCatch();
        
        // 2. Multiple catch blocks
        demonstrateMultipleCatch();
        
        // 3. Finally block
        demonstrateFinallyBlock();
        
        // 4. Try-with-resources
        demonstrateTryWithResources();
        
        // 5. Custom exceptions
        demonstrateCustomExceptions();
        
        // 6. Exception propagation
        demonstrateExceptionPropagation();
        
        // 7. Common exceptions
        demonstrateCommonExceptions();
    }
    
    private static void demonstrateBasicTryCatch() {
        System.out.println("1. BASIC TRY-CATCH:");
        
        try {
            int result = 10 / 0; // ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println("Program continues...\n");
    }
    
    private static void demonstrateMultipleCatch() {
        System.out.println("2. MULTIPLE CATCH BLOCKS:");
        
        String[] array = {"1", "2", "abc", "4"};
        
        for (int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                int result = 100 / value;
                System.out.println("Result for " + array[i] + ": " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array index out of bounds: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("General exception: " + e.getMessage());
            }
        }
        System.out.println();
    }
    
    private static void demonstrateFinallyBlock() {
        System.out.println("3. FINALLY BLOCK:");
        
        FileReader file = null;
        try {
            file = new FileReader("nonexistent.txt");
            System.out.println("File opened successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
            if (file != null) {
                try {
                    file.close();
                    System.out.println("File closed");
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }
        System.out.println();
    }
    
    private static void demonstrateTryWithResources() {
        System.out.println("4. TRY-WITH-RESOURCES:");
        
        // Automatic resource management
        try (Scanner scanner = new Scanner("Hello World")) {
            while (scanner.hasNext()) {
                System.out.println("Token: " + scanner.next());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Scanner is automatically closed
        
        System.out.println();
    }
    
    private static void demonstrateCustomExceptions() {
        System.out.println("5. CUSTOM EXCEPTIONS:");
        
        BankAccount account = new BankAccount("12345", 1000.0);
        
        // Checked exception example
        try {
            account.withdraw(1500.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
        
        // Unchecked exception example
        BankAccount invalidAccount = new BankAccount("", 500.0);
        try {
            invalidAccount.validateAccount();
        } catch (InvalidAccountException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void demonstrateExceptionPropagation() {
        System.out.println("6. EXCEPTION PROPAGATION:");
        
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Caught in main: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void methodA() throws Exception {
        methodB();
    }
    
    private static void methodB() throws Exception {
        methodC();
    }
    
    private static void methodC() throws Exception {
        throw new Exception("Exception from methodC");
    }
    
    private static void demonstrateCommonExceptions() {
        System.out.println("7. COMMON EXCEPTIONS:");
        
        // NullPointerException
        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        
        // ClassCastException
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }
        
        // IllegalArgumentException
        try {
            Thread.sleep(-1000);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
        }
        
        System.out.println("\nBest Practices:");
        System.out.println("• Catch specific exceptions before general ones");
        System.out.println("• Use try-with-resources for automatic resource management");
        System.out.println("• Don't catch exceptions you can't handle");
        System.out.println("• Log exceptions with proper context");
        System.out.println("• Use custom exceptions for business logic errors");
    }
}
