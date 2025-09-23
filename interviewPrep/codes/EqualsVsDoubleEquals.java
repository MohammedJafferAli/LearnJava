public class EqualsVsDoubleEquals {
    public static void main(String[] args) {
        // Primitive comparison with ==
        int a = 10;
        int b = 10;
        System.out.println("Primitives: a == b: " + (a == b)); // true
        
        // String comparison
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        String str3 = "Hello";
        String str4 = "Hello";
        
        System.out.println("str1 == str2: " + (str1 == str2)); // false (different objects)
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true (same content)
        System.out.println("str3 == str4: " + (str3 == str4)); // true (string pool)
        
        // Custom object comparison
        Person person1 = new Person("John", 25);
        Person person2 = new Person("John", 25);
        Person person3 = person1;
        
        System.out.println("person1 == person2: " + (person1 == person2)); // false
        System.out.println("person1.equals(person2): " + person1.equals(person2)); // true
        System.out.println("person1 == person3: " + (person1 == person3)); // true
    }
}

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Override equals method for content comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Person person = (Person) obj;
        return age == person.age && 
               (name != null ? name.equals(person.name) : person.name == null);
    }
    
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
