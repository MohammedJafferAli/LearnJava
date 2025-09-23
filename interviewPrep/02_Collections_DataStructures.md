# Collections & Data Structures

## 1. What is the difference between Array and ArrayList?

| Array | ArrayList |
|-------|-----------|
| Fixed size | Dynamic size |
| Can store primitives and objects | Can only store objects |
| Better performance | Slightly slower due to boxing/unboxing |
| No built-in methods | Rich set of methods |
| Memory efficient | Additional memory overhead |

**Example:** See `codes/ArrayVsArrayList.java`

## 2. How do you convert ArrayList to LinkedList and vice versa?

### ArrayList to LinkedList
```java
ArrayList<String> arrayList = new ArrayList<>();
LinkedList<String> linkedList = new LinkedList<>(arrayList);
```

### LinkedList to ArrayList
```java
LinkedList<String> linkedList = new LinkedList<>();
ArrayList<String> arrayList = new ArrayList<>(linkedList);
```

**Example:** See `codes/ListConversions.java`

## 3. What is the difference between ArrayList and LinkedList?

| ArrayList | LinkedList |
|-----------|------------|
| Dynamic array implementation | Doubly linked list implementation |
| Random access O(1) | Sequential access O(n) |
| Insertion/deletion O(n) | Insertion/deletion O(1) |
| Less memory per element | More memory per element |
| Better for frequent access | Better for frequent modifications |

**Example:** See `codes/ArrayListVsLinkedList.java`

## 4. What are the differences between List, Set, and Map?

### List
- Ordered collection (maintains insertion order)
- Allows duplicates
- Index-based access
- Examples: ArrayList, LinkedList, Vector

### Set
- No duplicates allowed
- May or may not maintain order
- No index-based access
- Examples: HashSet, TreeSet, LinkedHashSet

### Map
- Key-value pairs
- Keys are unique, values can be duplicate
- No index-based access
- Examples: HashMap, TreeMap, LinkedHashMap

**Example:** See `codes/ListSetMapDifferences.java`

## 5. What is the difference between HashSet, TreeSet, and LinkedHashSet?

| HashSet | TreeSet | LinkedHashSet |
|---------|---------|---------------|
| Hash table implementation | Red-Black tree implementation | Hash table + Linked list |
| No ordering | Sorted order | Insertion order |
| O(1) operations | O(log n) operations | O(1) operations |
| Allows null | No null values | Allows null |
| Not synchronized | Not synchronized | Not synchronized |

**Example:** See `codes/SetImplementations.java`

## 6. What is the difference between HashMap and TreeMap?

| HashMap | TreeMap |
|---------|---------|
| Hash table implementation | Red-Black tree implementation |
| No ordering | Sorted by keys |
| O(1) operations | O(log n) operations |
| Allows null key/values | No null keys |
| Not synchronized | Not synchronized |

**Example:** See `codes/HashMapVsTreeMap.java`

## 7. What is the difference between Hashtable and ConcurrentHashMap?

| Hashtable | ConcurrentHashMap |
|-----------|-------------------|
| Synchronized (thread-safe) | Thread-safe with better performance |
| Locks entire table | Segment-based locking |
| No null keys/values | No null keys/values |
| Legacy class | Modern alternative |
| Poor performance in multithreading | Better concurrent performance |

**Example:** See `codes/HashtableVsConcurrentHashMap.java`

## 8. What is the difference between Iterator and Enumerator?

| Iterator | Enumerator |
|----------|------------|
| Introduced in Java 1.2 | Legacy (Java 1.0) |
| Fail-fast | Fail-safe |
| Can remove elements | Read-only |
| Works with all collections | Only Vector, Hashtable |
| hasNext(), next(), remove() | hasMoreElements(), nextElement() |

**Example:** See `codes/IteratorVsEnumerator.java`

## 9. What is the difference between Comparable and Comparator?

### Comparable
- Natural ordering of objects
- Implemented by the class itself
- Single sorting sequence
- compareTo() method

### Comparator
- Custom ordering
- External to the class
- Multiple sorting sequences
- compare() method

**Example:** See `codes/ComparableVsComparator.java`

## 10. What is the difference between Collection and Collections?

### Collection
- Interface in java.util package
- Root interface of collection hierarchy
- Defines basic operations for collections

### Collections
- Utility class in java.util package
- Provides static methods for collection operations
- Methods like sort(), reverse(), shuffle()

**Example:** See `codes/CollectionVsCollections.java`

## 11. How do you make a collection read-only?

Methods to create read-only collections:
1. `Collections.unmodifiableList()`
2. `Collections.unmodifiableSet()`
3. `Collections.unmodifiableMap()`
4. `List.of()`, `Set.of()`, `Map.of()` (Java 9+)

**Example:** See `codes/ReadOnlyCollections.java`

## 12. How do you find the highest and lowest values in a List?

Methods:
1. `Collections.max()` and `Collections.min()`
2. Stream API with `max()` and `min()`
3. Manual iteration

**Example:** See `codes/FindMinMaxInList.java`
