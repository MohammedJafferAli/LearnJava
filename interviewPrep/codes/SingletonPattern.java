// 1. Eager Initialization Singleton
class EagerSingleton {
    // Instance created at class loading time
    private static final EagerSingleton INSTANCE = new EagerSingleton();
    
    private EagerSingleton() {
        // Private constructor prevents instantiation
    }
    
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
    
    public void showMessage() {
        System.out.println("Eager Singleton Instance");
    }
}

// 2. Lazy Initialization Singleton (Not Thread Safe)
class LazySingleton {
    private static LazySingleton instance;
    
    private LazySingleton() {}
    
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
    
    public void showMessage() {
        System.out.println("Lazy Singleton Instance");
    }
}

// 3. Thread Safe Singleton (Synchronized Method)
class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton() {}
    
    // Synchronized method - thread safe but performance impact
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
    public void showMessage() {
        System.out.println("Thread Safe Singleton Instance");
    }
}

// 4. Double Checked Locking Singleton
class DoubleCheckedSingleton {
    // volatile ensures visibility across threads
    private static volatile DoubleCheckedSingleton instance;
    
    private DoubleCheckedSingleton() {}
    
    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                // Double check
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
    
    public void showMessage() {
        System.out.println("Double Checked Locking Singleton Instance");
    }
}

// 5. Bill Pugh Singleton (Initialization-on-demand holder)
class BillPughSingleton {
    private BillPughSingleton() {}
    
    // Inner static class - loaded only when getInstance() is called
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    public void showMessage() {
        System.out.println("Bill Pugh Singleton Instance");
    }
}

// 6. Enum Singleton (Best Practice)
enum EnumSingleton {
    INSTANCE;
    
    public void showMessage() {
        System.out.println("Enum Singleton Instance");
    }
    
    // Can have other methods
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

// Real-world example: Database Connection Manager
class DatabaseManager {
    private static volatile DatabaseManager instance;
    private String connectionString;
    
    private DatabaseManager() {
        // Initialize database connection
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Database connection initialized");
    }
    
    public static DatabaseManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager();
                }
            }
        }
        return instance;
    }
    
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query + " on " + connectionString);
    }
    
    public void closeConnection() {
        System.out.println("Closing database connection");
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        System.out.println("=== SINGLETON PATTERN EXAMPLES ===\n");
        
        // 1. Eager Singleton
        System.out.println("1. Eager Singleton:");
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("Same instance? " + (eager1 == eager2));
        eager1.showMessage();
        
        // 2. Lazy Singleton
        System.out.println("\n2. Lazy Singleton:");
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("Same instance? " + (lazy1 == lazy2));
        lazy1.showMessage();
        
        // 3. Thread Safe Singleton
        System.out.println("\n3. Thread Safe Singleton:");
        ThreadSafeSingleton safe1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton safe2 = ThreadSafeSingleton.getInstance();
        System.out.println("Same instance? " + (safe1 == safe2));
        safe1.showMessage();
        
        // 4. Double Checked Locking
        System.out.println("\n4. Double Checked Locking:");
        DoubleCheckedSingleton dcl1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton dcl2 = DoubleCheckedSingleton.getInstance();
        System.out.println("Same instance? " + (dcl1 == dcl2));
        dcl1.showMessage();
        
        // 5. Bill Pugh Singleton
        System.out.println("\n5. Bill Pugh Singleton:");
        BillPughSingleton bp1 = BillPughSingleton.getInstance();
        BillPughSingleton bp2 = BillPughSingleton.getInstance();
        System.out.println("Same instance? " + (bp1 == bp2));
        bp1.showMessage();
        
        // 6. Enum Singleton (Recommended)
        System.out.println("\n6. Enum Singleton (Best Practice):");
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        System.out.println("Same instance? " + (enum1 == enum2));
        enum1.showMessage();
        enum1.doSomething();
        
        // Real-world example
        System.out.println("\n=== REAL-WORLD EXAMPLE ===");
        DatabaseManager db1 = DatabaseManager.getInstance();
        DatabaseManager db2 = DatabaseManager.getInstance();
        System.out.println("Same database manager? " + (db1 == db2));
        
        db1.executeQuery("SELECT * FROM users");
        db2.executeQuery("SELECT * FROM products");
        
        // Thread safety test
        System.out.println("\n=== THREAD SAFETY TEST ===");
        testThreadSafety();
    }
    
    private static void testThreadSafety() {
        Thread[] threads = new Thread[10];
        
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                DoubleCheckedSingleton instance = DoubleCheckedSingleton.getInstance();
                System.out.println("Thread " + Thread.currentThread().getName() + 
                                 ": " + instance.hashCode());
            });
            threads[i].start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
