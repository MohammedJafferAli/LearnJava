# Multithreading & Concurrency

## 1. What is the difference between synchronized and volatile?

### synchronized
- Provides mutual exclusion (only one thread can access)
- Ensures atomicity and visibility
- Can be applied to methods and blocks
- Can cause thread blocking

### volatile
- Ensures visibility of changes across threads
- No mutual exclusion (multiple threads can access)
- Only for variables
- No blocking, better performance

**Key Differences:**
| synchronized | volatile |
|--------------|----------|
| Mutual exclusion + visibility | Only visibility |
| Can block threads | Non-blocking |
| Methods and blocks | Only variables |
| Heavier operation | Lighter operation |

**Example:** See `codes/SynchronizedVsVolatile.java`

## 2. How do you prevent deadlocks in Java?

### Deadlock Prevention Strategies:

1. **Avoid Nested Locks**: Don't acquire multiple locks
2. **Lock Ordering**: Always acquire locks in same order
3. **Lock Timeout**: Use tryLock() with timeout
4. **Deadlock Detection**: Monitor and detect deadlocks

### Best Practices:
- Use `java.util.concurrent` classes
- Minimize lock scope
- Use lock-free data structures when possible
- Avoid calling external methods while holding locks

**Example:** See `codes/DeadlockPrevention.java`

## 3. What is the role of ExecutorService?

ExecutorService provides:
- **Thread Pool Management**: Reuses threads efficiently
- **Task Submission**: submit() and execute() methods
- **Lifecycle Management**: shutdown() and shutdownNow()
- **Future Support**: Returns Future objects for async results

### Types of Thread Pools:
1. **FixedThreadPool**: Fixed number of threads
2. **CachedThreadPool**: Creates threads as needed
3. **SingleThreadExecutor**: Single worker thread
4. **ScheduledThreadPool**: Scheduled and periodic tasks

**Example:** See `codes/ExecutorServiceExample.java`

## 4. Explain wait(), notify(), and notifyAll().

### wait()
- Releases lock and waits for notification
- Must be called within synchronized block
- Thread goes to waiting state

### notify()
- Wakes up one waiting thread
- Must be called within synchronized block
- Doesn't release lock immediately

### notifyAll()
- Wakes up all waiting threads
- Must be called within synchronized block
- All threads compete for lock

**Example:** See `codes/WaitNotifyExample.java`

## 5. What is the difference between Thread and Runnable?

| Thread | Runnable |
|--------|----------|
| Class (extends Thread) | Interface (implement Runnable) |
| Single inheritance limitation | Multiple inheritance possible |
| Heavyweight | Lightweight |
| Direct thread creation | Needs Thread object |
| Less flexible | More flexible |

**Example:** See `codes/ThreadVsRunnable.java`

## 6. Explain the thread lifecycle and commonly used methods.

### Thread States:
1. **NEW**: Thread created but not started
2. **RUNNABLE**: Thread executing or ready to execute
3. **BLOCKED**: Thread blocked waiting for monitor lock
4. **WAITING**: Thread waiting indefinitely
5. **TIMED_WAITING**: Thread waiting for specified time
6. **TERMINATED**: Thread completed execution

### Common Methods:
- `start()`: Starts thread execution
- `run()`: Contains thread logic
- `sleep()`: Pauses thread for specified time
- `join()`: Waits for thread to complete
- `interrupt()`: Interrupts thread
- `isAlive()`: Checks if thread is alive

**Example:** See `codes/ThreadLifecycle.java`

## 7. How do you create a deadlock in Java?

Deadlock occurs when:
- Two or more threads are blocked forever
- Each thread holds a resource needed by another
- Circular dependency exists

### Conditions for Deadlock:
1. **Mutual Exclusion**: Resources cannot be shared
2. **Hold and Wait**: Thread holds resource while waiting
3. **No Preemption**: Resources cannot be forcibly taken
4. **Circular Wait**: Circular chain of resource dependencies

**Example:** See `codes/DeadlockExample.java`
