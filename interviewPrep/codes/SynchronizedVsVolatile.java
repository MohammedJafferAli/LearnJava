public class SynchronizedVsVolatile {
    
    // Volatile example - ensures visibility
    private volatile boolean flag = false;
    private volatile int counter = 0;
    
    // Non-volatile for comparison
    private boolean nonVolatileFlag = false;
    
    // Synchronized counter
    private int syncCounter = 0;
    
    public static void main(String[] args) throws InterruptedException {
        SynchronizedVsVolatile example = new SynchronizedVsVolatile();
        
        // Demonstrate volatile visibility
        example.demonstrateVolatile();
        
        Thread.sleep(1000);
        
        // Demonstrate synchronized mutual exclusion
        example.demonstrateSynchronized();
    }
    
    public void demonstrateVolatile() throws InterruptedException {
        System.out.println("=== VOLATILE EXAMPLE ===");
        
        // Thread 1: Writer
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(100);
                flag = true; // Volatile write - immediately visible to other threads
                System.out.println("Writer: Flag set to true");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Thread 2: Reader
        Thread reader = new Thread(() -> {
            while (!flag) {
                // Busy wait - volatile ensures this sees the updated value
            }
            System.out.println("Reader: Flag is now true!");
        });
        
        reader.start();
        writer.start();
        
        reader.join();
        writer.join();
        
        // Demonstrate volatile increment (NOT atomic)
        System.out.println("\n--- Volatile Increment (Race Condition) ---");
        Thread[] threads = new Thread[10];
        
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter++; // NOT atomic even with volatile
                }
            });
            threads[i].start();
        }
        
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("Volatile counter (expected 10000): " + counter);
        System.out.println("Result may be less than 10000 due to race condition");
    }
    
    public void demonstrateSynchronized() throws InterruptedException {
        System.out.println("\n=== SYNCHRONIZED EXAMPLE ===");
        
        Thread[] threads = new Thread[10];
        
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    incrementSyncCounter(); // Atomic operation
                }
            });
            threads[i].start();
        }
        
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("Synchronized counter (expected 10000): " + syncCounter);
        System.out.println("Result is always 10000 due to synchronization");
        
        // Demonstrate synchronized block
        demonstrateSynchronizedBlock();
    }
    
    // Synchronized method
    private synchronized void incrementSyncCounter() {
        syncCounter++;
    }
    
    // Synchronized block example
    private void demonstrateSynchronizedBlock() {
        System.out.println("\n--- Synchronized Block Example ---");
        
        Object lock1 = new Object();
        Object lock2 = new Object();
        
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Acquired lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock2");
                }
            }
        });
        
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Acquired lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock1");
                }
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
