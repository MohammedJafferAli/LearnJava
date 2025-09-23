import java.util.*;
import java.util.function.*;
import java.util.stream.*;

// Lambda Expressions and Stream API Examples

class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;
    
    public Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }
    
    // Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }
    
    @Override
    public String toString() {
        return String.format("%s (%s, $%.0f, %d years)", name, department, salary, age);
    }
}

public class LambdaAndStreams {
    
    public static void main(String[] args) {
        System.out.println("=== LAMBDA EXPRESSIONS & STREAM API ===\n");
        
        // 1. Lambda expressions basics
        demonstrateLambdaBasics();
        
        // 2. Functional interfaces
        demonstrateFunctionalInterfaces();
        
        // 3. Method references
        demonstrateMethodReferences();
        
        // 4. Stream API operations
        demonstrateStreamOperations();
        
        // 5. Advanced stream operations
        demonstrateAdvancedStreams();
    }
    
    private static void demonstrateLambdaBasics() {
        System.out.println("1. LAMBDA EXPRESSIONS BASICS:");
        
        // Traditional anonymous class
        Runnable oldWay = new Runnable() {
            @Override
            public void run() {
                System.out.println("Old way with anonymous class");
            }
        };
        
        // Lambda expression
        Runnable newWay = () -> System.out.println("New way with lambda");
        
        oldWay.run();
        newWay.run();
        
        // Lambda with parameters
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Traditional way
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        
        // Lambda way
        Collections.sort(names, (a, b) -> a.compareTo(b));
        
        // Even shorter with method reference
        Collections.sort(names, String::compareTo);
        
        System.out.println("Sorted names: " + names);
        System.out.println();
    }
    
    private static void demonstrateFunctionalInterfaces() {
        System.out.println("2. FUNCTIONAL INTERFACES:");
        
        // Predicate<T> - takes T, returns boolean
        Predicate<String> isEmpty = s -> s.isEmpty();
        Predicate<String> isLong = s -> s.length() > 5;
        
        System.out.println("Is 'Hello' empty? " + isEmpty.test("Hello"));
        System.out.println("Is 'Programming' long? " + isLong.test("Programming"));
        
        // Function<T, R> - takes T, returns R
        Function<String, Integer> stringLength = s -> s.length();
        Function<Integer, String> intToString = i -> "Number: " + i;
        
        System.out.println("Length of 'Java': " + stringLength.apply("Java"));
        System.out.println(intToString.apply(42));
        
        // Consumer<T> - takes T, returns void
        Consumer<String> printer = s -> System.out.println("Printing: " + s);
        printer.accept("Hello Consumer");
        
        // Supplier<T> - takes nothing, returns T
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get());
        
        // BiFunction<T, U, R> - takes T and U, returns R
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.apply(5, 3));
        
        System.out.println();
    }
    
    private static void demonstrateMethodReferences() {
        System.out.println("3. METHOD REFERENCES:");
        
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        
        // Static method reference
        words.stream()
             .map(String::toUpperCase) // String::toUpperCase
             .forEach(System.out::println); // System.out::println
        
        // Instance method reference
        String prefix = "Fruit: ";
        words.stream()
             .map(prefix::concat) // instance method reference
             .forEach(System.out::println);
        
        // Constructor reference
        List<Integer> lengths = words.stream()
                                    .map(String::length)
                                    .collect(Collectors.toList());
        System.out.println("Word lengths: " + lengths);
        
        System.out.println();
    }
    
    private static void demonstrateStreamOperations() {
        System.out.println("4. STREAM API OPERATIONS:");
        
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 75000, 28),
            new Employee("Bob", "HR", 65000, 35),
            new Employee("Charlie", "IT", 85000, 32),
            new Employee("Diana", "Finance", 70000, 29),
            new Employee("Eve", "IT", 90000, 26)
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        // Filter - IT employees only
        System.out.println("\nIT employees:");
        employees.stream()
                 .filter(emp -> emp.getDepartment().equals("IT"))
                 .forEach(System.out::println);
        
        // Map - employee names only
        System.out.println("\nEmployee names:");
        employees.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);
        
        // Filter + Map - IT employee names
        System.out.println("\nIT employee names:");
        List<String> itNames = employees.stream()
                                       .filter(emp -> emp.getDepartment().equals("IT"))
                                       .map(Employee::getName)
                                       .collect(Collectors.toList());
        System.out.println(itNames);
        
        // Reduce - total salary
        double totalSalary = employees.stream()
                                    .mapToDouble(Employee::getSalary)
                                    .sum();
        System.out.println("\nTotal salary: $" + totalSalary);
        
        // Average salary
        OptionalDouble avgSalary = employees.stream()
                                          .mapToDouble(Employee::getSalary)
                                          .average();
        System.out.println("Average salary: $" + avgSalary.orElse(0));
        
        System.out.println();
    }
    
    private static void demonstrateAdvancedStreams() {
        System.out.println("5. ADVANCED STREAM OPERATIONS:");
        
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 75000, 28),
            new Employee("Bob", "HR", 65000, 35),
            new Employee("Charlie", "IT", 85000, 32),
            new Employee("Diana", "Finance", 70000, 29),
            new Employee("Eve", "IT", 90000, 26),
            new Employee("Frank", "HR", 60000, 40)
        );
        
        // Group by department
        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        
        System.out.println("Employees by department:");
        byDepartment.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList.size() + " employees");
        });
        
        // Average salary by department
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.averagingDouble(Employee::getSalary)
                ));
        
        System.out.println("\nAverage salary by department:");
        avgSalaryByDept.forEach((dept, avg) -> 
            System.out.printf("%s: $%.2f%n", dept, avg));
        
        // Find highest paid employee
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        
        highestPaid.ifPresent(emp -> 
            System.out.println("\nHighest paid: " + emp));
        
        // Partition by age (above/below 30)
        Map<Boolean, List<Employee>> partitionedByAge = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() >= 30));
        
        System.out.println("\nEmployees 30 and above: " + 
                          partitionedByAge.get(true).size());
        System.out.println("Employees below 30: " + 
                          partitionedByAge.get(false).size());
        
        // Parallel stream example
        long count = employees.parallelStream()
                             .filter(emp -> emp.getSalary() > 70000)
                             .count();
        System.out.println("\nEmployees with salary > $70,000: " + count);
        
        // Custom collector example
        String allNames = employees.stream()
                                 .map(Employee::getName)
                                 .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("All employee names: " + allNames);
        
        System.out.println("\nStream API Benefits:");
        System.out.println("• Functional programming style");
        System.out.println("• Lazy evaluation");
        System.out.println("• Parallel processing support");
        System.out.println("• Readable and concise code");
        System.out.println("• Immutable operations");
    }
}
