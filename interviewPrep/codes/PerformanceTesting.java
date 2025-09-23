import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.Duration;
import java.time.Instant;

// Optimized Performance Testing Framework

// Thread-safe Performance Metrics Collection
class PerformanceMetrics {
    private final List<Long> responseTimes = Collections.synchronizedList(new ArrayList<>());
    private final AtomicInteger successCount = new AtomicInteger(0);
    private final AtomicInteger failureCount = new AtomicInteger(0);
    private volatile long startTime;
    private volatile long endTime;
    
    public void recordResponse(long responseTime, boolean success) {
        responseTimes.add(responseTime);
        if (success) {
            successCount.incrementAndGet();
        } else {
            failureCount.incrementAndGet();
        }
    }
    
    public void startTest() {
        startTime = System.currentTimeMillis();
    }
    
    public void endTest() {
        endTime = System.currentTimeMillis();
    }
    
    public PerformanceReport generateReport() {
        List<Long> sortedTimes = new ArrayList<>(responseTimes);
        Collections.sort(sortedTimes);
        
        if (sortedTimes.isEmpty()) {
            return new PerformanceReport(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        }
        
        double avgResponseTime = sortedTimes.stream()
                                          .mapToLong(Long::longValue)
                                          .average()
                                          .orElse(0.0);
        
        long minResponseTime = sortedTimes.get(0);
        long maxResponseTime = sortedTimes.get(sortedTimes.size() - 1);
        
        // Calculate percentiles efficiently
        long p50 = getPercentile(sortedTimes, 50);
        long p90 = getPercentile(sortedTimes, 90);
        long p95 = getPercentile(sortedTimes, 95);
        long p99 = getPercentile(sortedTimes, 99);
        
        double testDurationSeconds = (endTime - startTime) / 1000.0;
        double throughput = testDurationSeconds > 0 ? 
                           (successCount.get() + failureCount.get()) / testDurationSeconds : 0;
        
        int totalRequests = successCount.get() + failureCount.get();
        double successRate = totalRequests > 0 ? 
                            (double) successCount.get() / totalRequests * 100 : 0;
        
        return new PerformanceReport(avgResponseTime, minResponseTime, maxResponseTime,
                                   p50, p90, p95, p99, throughput, successRate,
                                   successCount.get(), failureCount.get());
    }
    
    private long getPercentile(List<Long> sortedTimes, int percentile) {
        if (sortedTimes.isEmpty()) return 0;
        int index = (int) Math.ceil(percentile / 100.0 * sortedTimes.size()) - 1;
        return sortedTimes.get(Math.max(0, Math.min(index, sortedTimes.size() - 1)));
    }
}

// Immutable Performance Report
class PerformanceReport {
    private final double avgResponseTime;
    private final long minResponseTime, maxResponseTime;
    private final long p50, p90, p95, p99;
    private final double throughput, successRate;
    private final int successCount, failureCount;
    
    public PerformanceReport(double avgResponseTime, long minResponseTime, long maxResponseTime,
                           long p50, long p90, long p95, long p99, double throughput,
                           double successRate, int successCount, int failureCount) {
        this.avgResponseTime = avgResponseTime;
        this.minResponseTime = minResponseTime;
        this.maxResponseTime = maxResponseTime;
        this.p50 = p50;
        this.p90 = p90;
        this.p95 = p95;
        this.p99 = p99;
        this.throughput = throughput;
        this.successRate = successRate;
        this.successCount = successCount;
        this.failureCount = failureCount;
    }
    
    public void printReport() {
        System.out.println("=== PERFORMANCE TEST REPORT ===");
        System.out.printf("Total Requests: %d (Success: %d, Failures: %d)%n", 
                         successCount + failureCount, successCount, failureCount);
        System.out.printf("Success Rate: %.2f%%%n", successRate);
        System.out.printf("Throughput: %.2f requests/second%n", throughput);
        System.out.println("\nResponse Times (ms):");
        System.out.printf("  Average: %.2f%n", avgResponseTime);
        System.out.printf("  Min: %d%n", minResponseTime);
        System.out.printf("  Max: %d%n", maxResponseTime);
        System.out.printf("  50th percentile: %d%n", p50);
        System.out.printf("  90th percentile: %d%n", p90);
        System.out.printf("  95th percentile: %d%n", p95);
        System.out.printf("  99th percentile: %d%n", p99);
    }
}

// Optimized Service Under Test with realistic behavior
class ServiceUnderTest {
    private final Random random = new Random();
    private final AtomicInteger requestCount = new AtomicInteger(0);
    
    public String processRequest(String request) throws InterruptedException {
        int requestNum = requestCount.incrementAndGet();
        
        // Simulate realistic processing time with load-based variation
        int baseTime = 50;
        int variability = 100;
        int loadFactor = Math.min(requestNum / 100, 50); // Increase latency with load
        
        int processingTime = baseTime + random.nextInt(variability) + loadFactor;
        Thread.sleep(processingTime);
        
        // Simulate realistic failure rate (2% base + load-based increase)
        double failureRate = 0.02 + (loadFactor * 0.001);
        if (random.nextDouble() < failureRate) {
            throw new RuntimeException("Service temporarily unavailable");
        }
        
        return "Response for: " + request;
    }
}

// Immutable Load Test Configuration
class LoadTestConfig {
    private final int numberOfUsers;
    private final int requestsPerUser;
    private final Duration rampUpTime;
    private final Duration testDuration;
    
    public LoadTestConfig(int numberOfUsers, int requestsPerUser, 
                         Duration rampUpTime, Duration testDuration) {
        this.numberOfUsers = numberOfUsers;
        this.requestsPerUser = requestsPerUser;
        this.rampUpTime = rampUpTime;
        this.testDuration = testDuration;
    }
    
    public int getNumberOfUsers() { return numberOfUsers; }
    public int getRequestsPerUser() { return requestsPerUser; }
    public Duration getRampUpTime() { return rampUpTime; }
    public Duration getTestDuration() { return testDuration; }
}

// Optimized Performance Test Runner with proper resource management
class PerformanceTestRunner implements AutoCloseable {
    private final ServiceUnderTest service;
    private final PerformanceMetrics metrics;
    private final ExecutorService executorService;
    
    public PerformanceTestRunner(ServiceUnderTest service) {
        this.service = service;
        this.metrics = new PerformanceMetrics();
        this.executorService = Executors.newCachedThreadPool(r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
    }
    
    public PerformanceReport runLoadTest(LoadTestConfig config) {
        System.out.printf("Starting load test: %d users, %d requests each%n",
                         config.getNumberOfUsers(), config.getRequestsPerUser());
        
        metrics.startTest();
        
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        long rampUpDelayMs = config.getNumberOfUsers() > 1 ? 
                            config.getRampUpTime().toMillis() / (config.getNumberOfUsers() - 1) : 0;
        
        // Create virtual users with staggered start times
        for (int i = 0; i < config.getNumberOfUsers(); i++) {
            final int userId = i;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    // Ramp-up delay
                    if (userId > 0) {
                        Thread.sleep(userId * rampUpDelayMs);
                    }
                    
                    // Execute requests for this user
                    for (int j = 0; j < config.getRequestsPerUser(); j++) {
                        executeRequest("User" + userId + "_Request" + j);
                        
                        // Small delay between requests from same user
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, executorService);
            futures.add(future);
        }
        
        // Wait for all users to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        
        metrics.endTest();
        return metrics.generateReport();
    }
    
    public PerformanceReport runStressTest(int maxUsers, Duration testDuration) {
        System.out.printf("Starting stress test: up to %d users for %s%n", maxUsers, testDuration);
        
        metrics.startTest();
        Instant endTime = Instant.now().plus(testDuration);
        
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        
        // Gradually increase load
        for (int currentUsers = 1; currentUsers <= maxUsers && Instant.now().isBefore(endTime); currentUsers++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                while (Instant.now().isBefore(endTime)) {
                    executeRequest("StressTest_" + System.currentTimeMillis());
                    try {
                        Thread.sleep(50); // Controlled request rate
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }, executorService);
            futures.add(future);
            
            try {
                Thread.sleep(500); // Add users every 500ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        // Wait for test duration
        try {
            long remainingMs = Duration.between(Instant.now(), endTime).toMillis();
            if (remainingMs > 0) {
                Thread.sleep(remainingMs);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Cancel all futures
        futures.forEach(future -> future.cancel(true));
        
        metrics.endTest();
        return metrics.generateReport();
    }
    
    private void executeRequest(String requestId) {
        long startTime = System.currentTimeMillis();
        boolean success = true;
        
        try {
            service.processRequest(requestId);
        } catch (Exception e) {
            success = false;
        }
        
        long responseTime = System.currentTimeMillis() - startTime;
        metrics.recordResponse(responseTime, success);
    }
    
    @Override
    public void close() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                    System.err.println("Executor did not terminate");
                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

// Optimized Spike Test Runner
class SpikeTestRunner implements AutoCloseable {
    private final ServiceUnderTest service;
    private final PerformanceMetrics metrics;
    private final ExecutorService executorService;
    
    public SpikeTestRunner(ServiceUnderTest service) {
        this.service = service;
        this.metrics = new PerformanceMetrics();
        this.executorService = Executors.newCachedThreadPool();
    }
    
    public PerformanceReport runSpikeTest(int baselineUsers, int spikeUsers, Duration spikeDuration) {
        System.out.printf("Spike test: %d baseline → %d spike users for %s%n",
                         baselineUsers, spikeUsers, spikeDuration);
        
        metrics.startTest();
        
        try {
            // Phase 1: Baseline
            System.out.println("Phase 1: Baseline load");
            runPhase(baselineUsers, Duration.ofSeconds(20));
            
            // Phase 2: Spike
            System.out.println("Phase 2: Spike load");
            runPhase(spikeUsers, spikeDuration);
            
            // Phase 3: Return to baseline
            System.out.println("Phase 3: Return to baseline");
            runPhase(baselineUsers, Duration.ofSeconds(20));
            
        } finally {
            metrics.endTest();
        }
        
        return metrics.generateReport();
    }
    
    private void runPhase(int users, Duration duration) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        Instant endTime = Instant.now().plus(duration);
        
        for (int i = 0; i < users; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                while (Instant.now().isBefore(endTime)) {
                    executeRequest("SpikeTest_" + System.currentTimeMillis());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }, executorService);
            futures.add(future);
        }
        
        // Wait for phase completion
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        futures.forEach(future -> future.cancel(true));
    }
    
    private void executeRequest(String requestId) {
        long startTime = System.currentTimeMillis();
        boolean success = true;
        
        try {
            service.processRequest(requestId);
        } catch (Exception e) {
            success = false;
        }
        
        long responseTime = System.currentTimeMillis() - startTime;
        metrics.recordResponse(responseTime, success);
    }
    
    @Override
    public void close() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

// Main class with optimized execution
public class PerformanceTesting {
    public static void main(String[] args) {
        ServiceUnderTest service = new ServiceUnderTest();
        
        System.out.println("=== OPTIMIZED PERFORMANCE TESTING ===\n");
        
        // 1. Load Test
        System.out.println("1. LOAD TEST");
        try (PerformanceTestRunner loadTestRunner = new PerformanceTestRunner(service)) {
            LoadTestConfig loadConfig = new LoadTestConfig(5, 10, 
                                                          Duration.ofSeconds(5), 
                                                          Duration.ofMinutes(1));
            PerformanceReport loadReport = loadTestRunner.runLoadTest(loadConfig);
            loadReport.printReport();
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // 2. Stress Test
        System.out.println("2. STRESS TEST");
        try (PerformanceTestRunner stressTestRunner = new PerformanceTestRunner(service)) {
            PerformanceReport stressReport = stressTestRunner.runStressTest(20, Duration.ofSeconds(30));
            stressReport.printReport();
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // 3. Spike Test
        System.out.println("3. SPIKE TEST");
        try (SpikeTestRunner spikeTestRunner = new SpikeTestRunner(service)) {
            PerformanceReport spikeReport = spikeTestRunner.runSpikeTest(3, 15, Duration.ofSeconds(20));
            spikeReport.printReport();
        }
        
        System.out.println("\n=== PERFORMANCE TESTING COMPLETED ===");
    }
}
