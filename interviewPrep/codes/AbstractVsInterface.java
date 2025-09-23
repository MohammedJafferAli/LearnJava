// Abstract class example
abstract class Vehicle {
    protected String brand; // Instance variable allowed
    protected int year;
    
    // Constructor allowed in abstract class
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    
    // Concrete method
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void start();
    public abstract double calculateFuelEfficiency();
}

// Interface example
interface Flyable {
    // All variables are public static final by default
    int MAX_ALTITUDE = 50000;
    
    // All methods are public abstract by default (before Java 8)
    void takeOff();
    void land();
    
    // Default method (Java 8+)
    default void performPreFlightCheck() {
        System.out.println("Performing pre-flight check...");
    }
    
    // Static method (Java 8+)
    static void displayFlightRules() {
        System.out.println("Follow aviation safety rules");
    }
}

interface Drivable {
    void accelerate();
    void brake();
}

// Class extending abstract class
class Car extends Vehicle {
    public Car(String brand, int year) {
        super(brand, year);
    }
    
    @Override
    public void start() {
        System.out.println("Car engine started");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        return 25.5; // miles per gallon
    }
}

// Class implementing multiple interfaces
class FlyingCar extends Vehicle implements Flyable, Drivable {
    public FlyingCar(String brand, int year) {
        super(brand, year);
    }
    
    @Override
    public void start() {
        System.out.println("Flying car systems activated");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        return 15.0; // Lower efficiency due to flight capability
    }
    
    // Implementing Flyable interface
    @Override
    public void takeOff() {
        System.out.println("Flying car taking off");
    }
    
    @Override
    public void land() {
        System.out.println("Flying car landing");
    }
    
    // Implementing Drivable interface
    @Override
    public void accelerate() {
        System.out.println("Flying car accelerating");
    }
    
    @Override
    public void brake() {
        System.out.println("Flying car braking");
    }
}

public class AbstractVsInterface {
    public static void main(String[] args) {
        // Using abstract class
        Car car = new Car("Toyota", 2023);
        car.displayInfo();
        car.start();
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " mpg");
        
        System.out.println();
        
        // Using class with multiple interfaces
        FlyingCar flyingCar = new FlyingCar("AeroMobil", 2024);
        flyingCar.displayInfo();
        flyingCar.start();
        
        // Interface methods
        flyingCar.performPreFlightCheck(); // Default method
        flyingCar.takeOff();
        flyingCar.accelerate();
        flyingCar.brake();
        flyingCar.land();
        
        // Static method call
        Flyable.displayFlightRules();
        
        System.out.println("Max altitude: " + Flyable.MAX_ALTITUDE + " feet");
    }
}
