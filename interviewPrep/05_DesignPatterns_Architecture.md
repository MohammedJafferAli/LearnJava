# Design Patterns & Architecture

## 1. What is the Singleton pattern?

Singleton pattern ensures:
- **Only one instance** of a class exists
- **Global access point** to that instance
- **Lazy or eager initialization** options

### Implementation Types:
1. **Eager Initialization**: Instance created at class loading
2. **Lazy Initialization**: Instance created when first requested
3. **Thread-Safe**: Synchronized methods
4. **Double-Checked Locking**: Optimized thread safety
5. **Enum Singleton**: Best practice approach

### Use Cases:
- Database connections
- Logger instances
- Configuration settings
- Cache managers

**Example:** See `codes/SingletonPattern.java`

## 2. Explain Factory and Strategy patterns.

### Factory Pattern
Creates objects without specifying exact classes:
- **Simple Factory**: Single factory class
- **Factory Method**: Subclasses decide which class to instantiate
- **Abstract Factory**: Family of related objects

### Strategy Pattern
Defines family of algorithms and makes them interchangeable:
- **Context**: Uses strategy interface
- **Strategy Interface**: Common interface for algorithms
- **Concrete Strategies**: Different algorithm implementations

**Example:** See `codes/FactoryStrategyPatterns.java`

## 3. What are the SOLID principles?

### S - Single Responsibility Principle (SRP)
- A class should have only one reason to change
- Each class should have only one responsibility

### O - Open/Closed Principle (OCP)
- Open for extension, closed for modification
- Use inheritance and polymorphism

### L - Liskov Substitution Principle (LSP)
- Objects of superclass should be replaceable with objects of subclass
- Subclasses should be substitutable for their base classes

### I - Interface Segregation Principle (ISP)
- Clients should not depend on interfaces they don't use
- Create specific interfaces rather than general ones

### D - Dependency Inversion Principle (DIP)
- High-level modules should not depend on low-level modules
- Both should depend on abstractions

**Example:** See `codes/SOLIDPrinciples.java`

## 4. How do you apply design patterns in test automation?

### Common Patterns in Test Automation:

1. **Page Object Model**: Encapsulates page elements and actions
2. **Factory Pattern**: Create different browser instances
3. **Singleton Pattern**: WebDriver instance management
4. **Strategy Pattern**: Different test execution strategies
5. **Observer Pattern**: Test result notifications
6. **Builder Pattern**: Test data creation
7. **Command Pattern**: Test step execution

### Benefits:
- **Maintainability**: Easy to update and modify
- **Reusability**: Common components across tests
- **Scalability**: Handle framework growth
- **Readability**: Clear and understandable code

**Example:** See `codes/TestAutomationPatterns.java`

## Additional Design Patterns

### Observer Pattern
Defines one-to-many dependency between objects:
- **Subject**: Maintains list of observers
- **Observer**: Gets notified of changes
- **Loose Coupling**: Subject and observers are loosely coupled

### Builder Pattern
Constructs complex objects step by step:
- **Fluent Interface**: Method chaining
- **Optional Parameters**: Handle multiple constructors
- **Immutable Objects**: Create immutable instances

### Decorator Pattern
Adds new functionality to objects dynamically:
- **Component**: Base interface
- **Concrete Component**: Basic implementation
- **Decorator**: Adds new behavior

**Example:** See `codes/AdditionalPatterns.java`
