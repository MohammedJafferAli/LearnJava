# Common Java Interview Questions

## 🔥 Most Frequently Asked Questions

### 1. What is the difference between String, StringBuffer, and StringBuilder?

| String | StringBuffer | StringBuilder |
|--------|--------------|---------------|
| Immutable | Mutable | Mutable |
| Thread-safe | Thread-safe | Not thread-safe |
| Slow concatenation | Faster concatenation | Fastest concatenation |
| Creates new objects | Modifies existing buffer | Modifies existing buffer |

**Example:** See `codes/StringComparison.java`

### 2. What is method overloading and overriding?

**Method Overloading:**
- Same method name, different parameters
- Compile-time polymorphism
- Can change return type

**Method Overriding:**
- Same method signature in parent and child
- Runtime polymorphism
- Cannot change return type (except covariant)

**Example:** See `codes/OverloadingOverriding.java`

### 3. What are access modifiers in Java?

| Modifier | Same Class | Same Package | Subclass | Different Package |
|----------|------------|--------------|----------|-------------------|
| private | ✓ | ✗ | ✗ | ✗ |
| default | ✓ | ✓ | ✗ | ✗ |
| protected | ✓ | ✓ | ✓ | ✗ |
| public | ✓ | ✓ | ✓ | ✓ |

**Example:** See `codes/AccessModifiers.java`

### 4. What is the difference between ArrayList and LinkedList?

| ArrayList | LinkedList |
|-----------|------------|
| Dynamic array | Doubly linked list |
| Random access O(1) | Sequential access O(n) |
| Insertion/deletion O(n) | Insertion/deletion O(1) |
| Less memory overhead | More memory overhead |
| Better for frequent access | Better for frequent modifications |

### 5. What is exception handling in Java?

**Exception Hierarchy:**
```
Throwable
├── Error (unchecked)
└── Exception
    ├── RuntimeException (unchecked)
    └── Checked Exceptions
```

**Key Concepts:**
- **try-catch-finally**: Exception handling blocks
- **throw**: Explicitly throw exception
- **throws**: Declare exceptions in method signature
- **Checked vs Unchecked**: Compile-time vs runtime

**Example:** See `codes/ExceptionHandling.java`

### 6. What is the difference between == and .equals()?

- **==**: Compares references for objects, values for primitives
- **.equals()**: Compares content/values of objects
- **hashCode()**: Must be overridden when equals() is overridden

### 7. What are wrapper classes in Java?

**Primitive to Wrapper:**
- byte → Byte
- short → Short
- int → Integer
- long → Long
- float → Float
- double → Double
- char → Character
- boolean → Boolean

**Autoboxing/Unboxing:**
- Automatic conversion between primitives and wrappers

**Example:** See `codes/WrapperClasses.java`

### 8. What is the difference between abstract class and interface?

**Abstract Class:**
- Can have concrete methods
- Can have instance variables
- Single inheritance
- Can have constructors

**Interface:**
- All methods abstract (before Java 8)
- Only static final variables
- Multiple inheritance
- Cannot have constructors

### 9. What are static methods and variables?

**Static Variables:**
- Belong to class, not instance
- Shared among all instances
- Initialized once when class loads

**Static Methods:**
- Can be called without creating instance
- Cannot access instance variables
- Cannot be overridden

**Example:** See `codes/StaticConcepts.java`

### 10. What is constructor chaining?

**Constructor Chaining:**
- Calling one constructor from another
- **this()**: Call constructor in same class
- **super()**: Call parent class constructor
- Must be first statement

**Example:** See `codes/ConstructorChaining.java`

### 11. What is the difference between HashMap and Hashtable?

| HashMap | Hashtable |
|---------|-----------|
| Not synchronized | Synchronized |
| Allows null key/values | No null key/values |
| Introduced in Java 1.2 | Legacy class (Java 1.0) |
| Better performance | Slower due to synchronization |
| Not thread-safe | Thread-safe |

### 12. What is garbage collection in Java?

**Garbage Collection:**
- Automatic memory management
- Removes unreferenced objects
- Cannot be forced (System.gc() is suggestion)

**GC Types:**
- **Serial GC**: Single-threaded
- **Parallel GC**: Multi-threaded
- **G1 GC**: Low-latency collector

**Example:** See `codes/GarbageCollection.java`

### 13. What is the difference between List, Set, and Map?

**List:**
- Ordered collection
- Allows duplicates
- Index-based access

**Set:**
- No duplicates
- May or may not be ordered
- No index-based access

**Map:**
- Key-value pairs
- Keys are unique
- No duplicate keys

### 14. What are generics in Java?

**Benefits:**
- Type safety at compile time
- Elimination of type casting
- Code reusability

**Wildcards:**
- **?**: Unknown type
- **? extends T**: Upper bounded
- **? super T**: Lower bounded

**Example:** See `codes/GenericsExample.java`

### 15. What is the difference between Comparable and Comparator?

**Comparable:**
- Natural ordering
- compareTo() method
- Single sorting sequence
- Implemented by class itself

**Comparator:**
- Custom ordering
- compare() method
- Multiple sorting sequences
- External to class

### 16. What are lambda expressions?

**Lambda Expressions (Java 8+):**
- Anonymous functions
- Functional programming support
- Reduces boilerplate code

**Syntax:** `(parameters) -> expression`

**Example:** See `codes/LambdaExpressions.java`

### 17. What is the Stream API?

**Stream API Features:**
- Functional-style operations
- Lazy evaluation
- Parallel processing support
- Immutable operations

**Common Operations:**
- **filter()**: Filter elements
- **map()**: Transform elements
- **collect()**: Collect results
- **reduce()**: Reduce to single value

**Example:** See `codes/StreamAPI.java`

### 18. What is method reference?

**Method Reference Types:**
- **Static method**: `ClassName::methodName`
- **Instance method**: `object::methodName`
- **Constructor**: `ClassName::new`

### 19. What is the difference between fail-fast and fail-safe iterators?

**Fail-fast:**
- Throws ConcurrentModificationException
- ArrayList, HashMap iterators
- Detects concurrent modification

**Fail-safe:**
- Creates copy of collection
- ConcurrentHashMap, CopyOnWriteArrayList
- Allows concurrent modification

### 20. What is serialization in Java?

**Serialization:**
- Converting object to byte stream
- Implements Serializable interface
- Used for persistence, network transfer

**Key Concepts:**
- **serialVersionUID**: Version control
- **transient**: Skip field during serialization
- **Externalizable**: Custom serialization

**Example:** See `codes/SerializationExample.java`

### 21. What is reflection in Java?

**Reflection:**
- Examine and modify runtime behavior
- Access private fields/methods
- Create objects dynamically

**Common Uses:**
- Frameworks (Spring, Hibernate)
- Testing frameworks
- IDE features

**Example:** See `codes/ReflectionExample.java`

### 22. What are annotations in Java?

**Built-in Annotations:**
- **@Override**: Method overriding
- **@Deprecated**: Mark as deprecated
- **@SuppressWarnings**: Suppress compiler warnings
- **@FunctionalInterface**: Functional interface

**Custom Annotations:**
- Create using @interface
- Meta-annotations: @Retention, @Target

**Example:** See `codes/AnnotationsExample.java`

### 23. What is the difference between checked and unchecked exceptions?

**Checked Exceptions:**
- Must be handled or declared
- Compile-time checking
- Examples: IOException, SQLException

**Unchecked Exceptions:**
- Runtime exceptions
- No compile-time checking
- Examples: NullPointerException, ArrayIndexOutOfBoundsException

### 24. What is enum in Java?

**Enum Features:**
- Type-safe constants
- Can have methods and constructors
- Implements Comparable and Serializable
- Cannot extend other classes

**Example:** See `codes/EnumExample.java`

### 25. What is the difference between String pool and heap?

**String Pool:**
- Special memory area in heap
- Stores string literals
- Enables string interning
- Memory optimization

**Heap:**
- General memory area
- Stores all objects
- Garbage collected

### 26. What is immutability in Java?

**Immutable Class Characteristics:**
- All fields are final and private
- No setter methods
- Class is final
- Defensive copying for mutable objects

**Benefits:**
- Thread-safe
- Cacheable
- No side effects

**Example:** See `codes/ImmutableClass.java`

### 27. What is the difference between shallow copy and deep copy?

**Shallow Copy:**
- Copies object references
- Changes affect original object
- Default clone() behavior

**Deep Copy:**
- Copies actual objects
- Independent copies
- Custom implementation needed

**Example:** See `codes/CopyingObjects.java`

### 28. What are nested classes in Java?

**Types of Nested Classes:**
- **Static nested class**: No access to outer instance
- **Inner class**: Access to outer instance
- **Local class**: Defined in method
- **Anonymous class**: No name, defined inline

**Example:** See `codes/NestedClasses.java`

### 29. What is the difference between composition and inheritance?

**Inheritance (IS-A):**
- Child class extends parent
- Tight coupling
- Single inheritance in Java

**Composition (HAS-A):**
- Class contains other objects
- Loose coupling
- Multiple composition possible

### 30. What are design patterns commonly asked in interviews?

**Creational Patterns:**
- Singleton, Factory, Builder

**Structural Patterns:**
- Adapter, Decorator, Facade

**Behavioral Patterns:**
- Observer, Strategy, Command

**Example:** See existing design pattern files
