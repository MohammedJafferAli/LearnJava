import java.util.ArrayList;
import java.util.List;

// Final class - cannot be extended
final class FinalClass {
    public void display() {
        System.out.println("This is a final class");
    }
}

class Parent {
    // Final method - cannot be overridden
    public final void finalMethod() {
        System.out.println("This method cannot be overridden");
    }
    
    public void normalMethod() {
        System.out.println("This method can be overridden");
    }
}

class Child extends Parent {
    // This would cause compilation error:
    // public void finalMethod() { } // Cannot override final method
    
    @Override
    public void normalMethod() {
        System.out.println("Overridden method in child class");
    }
}

public class FinalKeyword {
    // Final variable - constant
    public static final double PI = 3.14159;
    
    public static void main(String[] args) {
        // Final primitive variable
        final int x = 10;
        // x = 20; // Compilation error - cannot reassign
        
        // Final reference variable
        final List<String> list = new ArrayList<>();
        list.add("Item 1"); // OK - can modify object state
        list.add("Item 2");
        // list = new ArrayList<>(); // Error - cannot reassign reference
        
        System.out.println("Final variable PI: " + PI);
        System.out.println("List contents: " + list);
        
        // Final class usage
        FinalClass finalObj = new FinalClass();
        finalObj.display();
        
        // Final method usage
        Child child = new Child();
        child.finalMethod(); // Inherited final method
        child.normalMethod(); // Overridden method
        
        // Final local variable
        final String message = "Hello";
        System.out.println("Final local variable: " + message);
    }
}
