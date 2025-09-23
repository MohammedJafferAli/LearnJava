// Demonstrating all four pillars of OOP

// 1. Encapsulation - Data hiding using private fields and public methods
class BankAccount {
    private double balance; // Private field - encapsulated
    private String accountNumber;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    // Public methods to access private data
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// 2. Inheritance - SavingsAccount inherits from BankAccount
class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance); // Call parent constructor
        this.interestRate = interestRate;
    }
    
    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }
}

// 3. Abstraction - Abstract class defining common behavior
abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateArea();
    
    // Concrete method
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    // 4. Polymorphism - Method overriding
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;
    
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    // 4. Polymorphism - Method overriding
    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class OOPPillars {
    public static void main(String[] args) {
        // Encapsulation example
        BankAccount account = new BankAccount("12345", 1000.0);
        account.deposit(500);
        System.out.println("Balance: " + account.getBalance());
        
        // Inheritance example
        SavingsAccount savings = new SavingsAccount("67890", 2000.0, 5.0);
        savings.addInterest();
        System.out.println("Savings Balance: " + savings.getBalance());
        
        // Polymorphism example - same method call, different implementations
        Shape[] shapes = {
            new Circle("Red", 5.0),
            new Rectangle("Blue", 4.0, 6.0)
        };
        
        for (Shape shape : shapes) {
            shape.displayColor();
            System.out.println("Area: " + shape.calculateArea());
            System.out.println();
        }
    }
}
