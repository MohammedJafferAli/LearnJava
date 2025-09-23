import java.util.*;

// Student class implementing Comparable for natural ordering
class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double gpa;
    
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }
    
    // Natural ordering by name (Comparable)
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
    
    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d, gpa=%.2f}", name, age, gpa);
    }
}

public class ComparableVsComparator {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 22, 3.8),
            new Student("Bob", 20, 3.5),
            new Student("Charlie", 21, 3.9),
            new Student("Diana", 23, 3.7)
        );
        
        System.out.println("Original list:");
        students.forEach(System.out::println);
        
        // Using Comparable (natural ordering by name)
        System.out.println("\n=== COMPARABLE (Natural Ordering by Name) ===");
        List<Student> sortedByName = new ArrayList<>(students);
        Collections.sort(sortedByName);
        sortedByName.forEach(System.out::println);
        
        // Using Comparator for custom ordering
        System.out.println("\n=== COMPARATOR (Custom Ordering) ===");
        
        // Sort by age using Comparator
        System.out.println("Sorted by age:");
        List<Student> sortedByAge = new ArrayList<>(students);
        Collections.sort(sortedByAge, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });
        sortedByAge.forEach(System.out::println);
        
        // Sort by GPA using lambda expression
        System.out.println("\nSorted by GPA (descending):");
        List<Student> sortedByGpa = new ArrayList<>(students);
        Collections.sort(sortedByGpa, (s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        sortedByGpa.forEach(System.out::println);
        
        // Using Comparator.comparing() method
        System.out.println("\nSorted by name length:");
        List<Student> sortedByNameLength = new ArrayList<>(students);
        Collections.sort(sortedByNameLength, Comparator.comparing(s -> s.getName().length()));
        sortedByNameLength.forEach(System.out::println);
        
        // Multiple criteria sorting
        System.out.println("\nSorted by age, then by GPA (descending):");
        List<Student> multiSort = new ArrayList<>(students);
        Collections.sort(multiSort, 
            Comparator.comparingInt(Student::getAge)
                     .thenComparing(Student::getGpa, Comparator.reverseOrder()));
        multiSort.forEach(System.out::println);
        
        // Using Stream API for sorting
        System.out.println("\n=== USING STREAM API ===");
        System.out.println("Top 2 students by GPA:");
        students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .limit(2)
                .forEach(System.out::println);
    }
}
