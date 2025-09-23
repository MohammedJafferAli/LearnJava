# Core Java & OOP Concepts

## 1. What are the four pillars of Object-Oriented Programming?

The four pillars of OOP are:

### 1. Encapsulation
- Bundling data and methods that operate on that data within a single unit (class)
- Data hiding using access modifiers (private, protected, public)

### 2. Inheritance
- Mechanism where one class acquires properties and behaviors of another class
- Promotes code reusability

### 3. Polymorphism
- Ability of objects to take multiple forms
- Method overloading (compile-time) and method overriding (runtime)

### 4. Abstraction
- Hiding implementation details and showing only essential features
- Achieved through abstract classes and interfaces

**Example:** See `codes/OOPPillars.java`

## 2. What is the difference between == and .equals()?

### == Operator
- Compares references (memory addresses) for objects
- Compares actual values for primitives
- Cannot be overridden

### .equals() Method
- Compares content/values of objects
- Can be overridden to define custom equality logic
- Default implementation in Object class uses == comparison

**Example:** See `codes/EqualsVsDoubleEquals.java`

## 3. What is the role of the final keyword?

### With Variables
- Creates constants - value cannot be changed after initialization
- For objects, reference cannot be changed but object state can be modified

### With Methods
- Method cannot be overridden in subclasses

### With Classes
- Class cannot be extended (e.g., String, Integer)

**Example:** See `codes/FinalKeyword.java`

## 4. How does Java achieve platform independence?

Java achieves platform independence through:

1. **Bytecode**: Java source code compiles to platform-neutral bytecode (.class files)
2. **JVM**: Java Virtual Machine interprets bytecode for specific platforms
3. **WORA**: Write Once, Run Anywhere principle

**Process:**
```
Java Source (.java) → Compiler (javac) → Bytecode (.class) → JVM → Machine Code
```

## 5. What is the difference between abstract class and interface?

| Abstract Class | Interface |
|----------------|-----------|
| Can have concrete methods | All methods are abstract (before Java 8) |
| Can have instance variables | Only static final variables |
| Single inheritance | Multiple inheritance |
| Can have constructors | Cannot have constructors |
| Access modifiers allowed | Methods are public by default |

**Example:** See `codes/AbstractVsInterface.java`

## 6. What is method overloading vs overriding?

### Method Overloading (Compile-time Polymorphism)
- Same method name with different parameters
- Occurs within the same class
- Resolved at compile time

### Method Overriding (Runtime Polymorphism)
- Same method signature in parent and child class
- Child class provides specific implementation
- Resolved at runtime

**Example:** See `codes/OverloadingVsOverriding.java`

## 7. What is runtime polymorphism?

Runtime polymorphism occurs when:
- Method calls are resolved at runtime based on actual object type
- Achieved through method overriding and inheritance
- Uses dynamic method dispatch

**Example:** See `codes/RuntimePolymorphism.java`

## 8. What is static vs dynamic binding?

### Static Binding (Early Binding)
- Method calls resolved at compile time
- Used for static, private, and final methods
- Method overloading uses static binding

### Dynamic Binding (Late Binding)
- Method calls resolved at runtime
- Used for overridden methods
- Based on actual object type, not reference type

## 9. What is the difference between JDK, JRE, and JVM?

### JVM (Java Virtual Machine)
- Runtime environment that executes Java bytecode
- Platform-specific implementation

### JRE (Java Runtime Environment)
- JVM + Core libraries + Supporting files
- Needed to run Java applications

### JDK (Java Development Kit)
- JRE + Development tools (compiler, debugger, etc.)
- Needed to develop Java applications

**Relationship:** JDK ⊃ JRE ⊃ JVM

## 10. What is a package in Java? Can we create custom packages?

### Package
- Namespace that organizes related classes and interfaces
- Provides access control and prevents naming conflicts
- Corresponds to directory structure

### Benefits
- Code organization
- Access control
- Namespace management
- Code reusability

**Example:** See `codes/CustomPackageExample.java`

## 11. What is the difference between IS-A and HAS-A relationships?

### IS-A Relationship (Inheritance)
- "Child IS-A Parent" relationship
- Implemented using inheritance
- Example: Car IS-A Vehicle

### HAS-A Relationship (Composition/Aggregation)
- "Class HAS-A another class" relationship
- Implemented using instance variables
- Example: Car HAS-A Engine

**Example:** See `codes/IsAHasARelationship.java`

## 12. What is the use of this and super keywords?

### this Keyword
- Refers to current object instance
- Used to differentiate between instance and local variables
- Can call other constructors in same class

### super Keyword
- Refers to immediate parent class object
- Used to access parent class methods and variables
- Can call parent class constructor

**Example:** See `codes/ThisSuperKeywords.java`

## 13. What is a singleton class? Provide a code example.

Singleton pattern ensures:
- Only one instance of class exists
- Global access point to that instance
- Lazy or eager initialization

**Example:** See `codes/SingletonPattern.java`

## 14. What is typecasting in Java?

### Implicit Casting (Widening)
- Automatic conversion from smaller to larger data type
- No data loss occurs

### Explicit Casting (Narrowing)
- Manual conversion from larger to smaller data type
- Potential data loss

**Example:** See `codes/TypeCasting.java`
