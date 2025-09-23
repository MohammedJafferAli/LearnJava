import java.io.*;
import java.util.*;

// Serialization Examples

// Serializable class
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;
    private transient String password; // transient - not serialized
    private static String country = "USA"; // static - not serialized
    
    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPassword() { return password; }
    public static String getCountry() { return country; }
    
    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, password='%s', country='%s'}", 
                           name, age, password, country);
    }
}

// Custom serialization with Externalizable
class Employee implements Externalizable {
    private String name;
    private double salary;
    private Date joinDate;
    
    // Default constructor required for Externalizable
    public Employee() {}
    
    public Employee(String name, double salary, Date joinDate) {
        this.name = name;
        this.salary = salary;
        this.joinDate = joinDate;
    }
    
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeDouble(salary);
        out.writeLong(joinDate.getTime());
    }
    
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        salary = in.readDouble();
        joinDate = new Date(in.readLong());
    }
    
    @Override
    public String toString() {
        return String.format("Employee{name='%s', salary=%.2f, joinDate=%s}", 
                           name, salary, joinDate);
    }
}

// Custom serialization with writeObject/readObject
class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String accountNumber;
    private double balance;
    private transient String pin; // Sensitive data
    
    public BankAccount(String accountNumber, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }
    
    // Custom serialization
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Serialize non-transient fields
        
        // Custom logic for sensitive data
        String encryptedPin = encrypt(pin);
        out.writeUTF(encryptedPin);
    }
    
    // Custom deserialization
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Deserialize non-transient fields
        
        // Custom logic for sensitive data
        String encryptedPin = in.readUTF();
        this.pin = decrypt(encryptedPin);
    }
    
    private String encrypt(String data) {
        // Simple encryption (not for production)
        return new StringBuilder(data).reverse().toString();
    }
    
    private String decrypt(String data) {
        // Simple decryption (not for production)
        return new StringBuilder(data).reverse().toString();
    }
    
    @Override
    public String toString() {
        return String.format("BankAccount{accountNumber='%s', balance=%.2f, pin='%s'}", 
                           accountNumber, balance, pin);
    }
}

public class SerializationExample {
    
    public static void main(String[] args) {
        System.out.println("=== SERIALIZATION EXAMPLES ===\n");
        
        // 1. Basic serialization
        demonstrateBasicSerialization();
        
        // 2. Transient and static fields
        demonstrateTransientStatic();
        
        // 3. Externalizable interface
        demonstrateExternalizable();
        
        // 4. Custom serialization
        demonstrateCustomSerialization();
        
        // 5. Serialization best practices
        demonstrateBestPractices();
    }
    
    private static void demonstrateBasicSerialization() {
        System.out.println("1. BASIC SERIALIZATION:");
        
        Person person = new Person("John Doe", 30, "secret123");
        System.out.println("Original: " + person);
        
        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Person serialized successfully");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
        
        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void demonstrateTransientStatic() {
        System.out.println("2. TRANSIENT AND STATIC FIELDS:");
        
        Person person = new Person("Alice", 25, "password123");
        System.out.println("Before serialization: " + person);
        
        // Serialize and deserialize
        try {
            // Serialize
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(person);
            oos.close();
            
            // Deserialize
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Person deserializedPerson = (Person) ois.readObject();
            ois.close();
            
            System.out.println("After deserialization: " + deserializedPerson);
            System.out.println("Notice: transient field 'password' is null");
            System.out.println("Notice: static field 'country' retains current value");
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void demonstrateExternalizable() {
        System.out.println("3. EXTERNALIZABLE INTERFACE:");
        
        Employee emp = new Employee("Bob Smith", 75000.0, new Date());
        System.out.println("Original: " + emp);
        
        try {
            // Serialize
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(emp);
            oos.close();
            
            // Deserialize
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Employee deserializedEmp = (Employee) ois.readObject();
            ois.close();
            
            System.out.println("Deserialized: " + deserializedEmp);
            System.out.println("Custom serialization logic executed");
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void demonstrateCustomSerialization() {
        System.out.println("4. CUSTOM SERIALIZATION:");
        
        BankAccount account = new BankAccount("12345", 1000.0, "1234");
        System.out.println("Original: " + account);
        
        try {
            // Serialize
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(account);
            oos.close();
            
            // Deserialize
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            BankAccount deserializedAccount = (BankAccount) ois.readObject();
            ois.close();
            
            System.out.println("Deserialized: " + deserializedAccount);
            System.out.println("PIN was encrypted during serialization and decrypted during deserialization");
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void demonstrateBestPractices() {
        System.out.println("5. SERIALIZATION BEST PRACTICES:");
        
        System.out.println("✓ Always declare serialVersionUID");
        System.out.println("✓ Use transient for sensitive or non-serializable fields");
        System.out.println("✓ Implement custom serialization for complex objects");
        System.out.println("✓ Handle versioning with serialVersionUID");
        System.out.println("✓ Be careful with inheritance and serialization");
        System.out.println("✓ Consider security implications");
        System.out.println("✓ Test serialization/deserialization thoroughly");
        
        // Cleanup
        try {
            new File("person.ser").delete();
        } catch (Exception e) {
            // Ignore cleanup errors
        }
        
        System.out.println("\nCommon Issues:");
        System.out.println("• NotSerializableException - class doesn't implement Serializable");
        System.out.println("• InvalidClassException - serialVersionUID mismatch");
        System.out.println("• Security vulnerabilities - deserialization attacks");
        System.out.println("• Performance overhead - reflection and I/O operations");
    }
}
