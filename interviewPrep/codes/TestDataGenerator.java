import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Optimized Test Data Generator

enum DataType {
    STRING, INTEGER, DOUBLE, BOOLEAN, DATE, EMAIL, PHONE, UUID, JSON
}

// Immutable configuration class
class DataGenerationConfig {
    private final DataType dataType;
    private final Map<String, Object> parameters;
    
    public DataGenerationConfig(DataType dataType) {
        this.dataType = dataType;
        this.parameters = new HashMap<>();
    }
    
    public DataGenerationConfig withParameter(String key, Object value) {
        DataGenerationConfig newConfig = new DataGenerationConfig(this.dataType);
        newConfig.parameters.putAll(this.parameters);
        newConfig.parameters.put(key, value);
        return newConfig;
    }
    
    public DataType getDataType() { return dataType; }
    
    @SuppressWarnings("unchecked")
    public <T> T getParameter(String key, T defaultValue) {
        return (T) parameters.getOrDefault(key, defaultValue);
    }
}

// Base interface for all generators
interface DataGenerator<T> {
    T generate(DataGenerationConfig config);
    List<T> generateBatch(DataGenerationConfig config, int count);
}

// Optimized String Generator with better performance
class StringDataGenerator implements DataGenerator<String> {
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String ALPHABETIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMERIC = "0123456789";
    
    // Pre-defined arrays for better performance
    private static final String[] FIRST_NAMES = {
        "John", "Jane", "Mike", "Sarah", "David", "Lisa", "Tom", "Anna",
        "Chris", "Emma", "Alex", "Maria", "James", "Amy", "Robert", "Kate"
    };
    
    private static final String[] LAST_NAMES = {
        "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis",
        "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas"
    };
    
    @Override
    public String generate(DataGenerationConfig config) {
        String pattern = config.getParameter("pattern", "random");
        int length = config.getParameter("length", 10);
        
        switch (pattern.toLowerCase()) {
            case "name":
                return generateName();
            case "alphanumeric":
                return generateFromCharset(ALPHANUMERIC, length);
            case "alphabetic":
                return generateFromCharset(ALPHABETIC, length);
            case "numeric":
                return generateFromCharset(NUMERIC, length);
            case "custom":
                String charset = config.getParameter("charset", ALPHANUMERIC);
                return generateFromCharset(charset, length);
            default:
                return generateFromCharset(ALPHANUMERIC, length);
        }
    }
    
    @Override
    public List<String> generateBatch(DataGenerationConfig config, int count) {
        List<String> batch = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            batch.add(generate(config));
        }
        return batch;
    }
    
    private String generateName() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)] + " " +
               LAST_NAMES[random.nextInt(LAST_NAMES.length)];
    }
    
    private String generateFromCharset(String charset, int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(charset.charAt(random.nextInt(charset.length())));
        }
        return sb.toString();
    }
}

// Optimized Integer Generator
class IntegerDataGenerator implements DataGenerator<Integer> {
    @Override
    public Integer generate(DataGenerationConfig config) {
        int min = config.getParameter("min", 0);
        int max = config.getParameter("max", 100);
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    
    @Override
    public List<Integer> generateBatch(DataGenerationConfig config, int count) {
        List<Integer> batch = new ArrayList<>(count);
        int min = config.getParameter("min", 0);
        int max = config.getParameter("max", 100);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        
        for (int i = 0; i < count; i++) {
            batch.add(random.nextInt(min, max + 1));
        }
        return batch;
    }
}

// Optimized Email Generator
class EmailDataGenerator implements DataGenerator<String> {
    private static final String[] DOMAINS = {
        "gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "company.com",
        "test.com", "example.org", "mail.com", "protonmail.com", "icloud.com"
    };
    
    private final StringDataGenerator stringGenerator = new StringDataGenerator();
    
    @Override
    public String generate(DataGenerationConfig config) {
        String domain = config.getParameter("domain", getRandomDomain());
        int usernameLength = config.getParameter("usernameLength", 8);
        
        DataGenerationConfig usernameConfig = new DataGenerationConfig(DataType.STRING)
                .withParameter("pattern", "alphanumeric")
                .withParameter("length", usernameLength);
        
        String username = stringGenerator.generate(usernameConfig).toLowerCase();
        return username + "@" + domain;
    }
    
    @Override
    public List<String> generateBatch(DataGenerationConfig config, int count) {
        List<String> batch = new ArrayList<>(count);
        String domain = config.getParameter("domain", null);
        int usernameLength = config.getParameter("usernameLength", 8);
        
        for (int i = 0; i < count; i++) {
            String actualDomain = domain != null ? domain : getRandomDomain();
            DataGenerationConfig usernameConfig = new DataGenerationConfig(DataType.STRING)
                    .withParameter("pattern", "alphanumeric")
                    .withParameter("length", usernameLength);
            
            String username = stringGenerator.generate(usernameConfig).toLowerCase();
            batch.add(username + "@" + actualDomain);
        }
        return batch;
    }
    
    private String getRandomDomain() {
        return DOMAINS[ThreadLocalRandom.current().nextInt(DOMAINS.length)];
    }
}

// Optimized Phone Generator
class PhoneDataGenerator implements DataGenerator<String> {
    @Override
    public String generate(DataGenerationConfig config) {
        String format = config.getParameter("format", "US");
        
        switch (format.toUpperCase()) {
            case "US":
                return generateUSPhone();
            case "UK":
                return generateUKPhone();
            case "INTERNATIONAL":
                return generateInternationalPhone();
            default:
                return generateUSPhone();
        }
    }
    
    @Override
    public List<String> generateBatch(DataGenerationConfig config, int count) {
        List<String> batch = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            batch.add(generate(config));
        }
        return batch;
    }
    
    private String generateUSPhone() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int area = random.nextInt(200, 999);
        int exchange = random.nextInt(200, 999);
        int number = random.nextInt(1000, 9999);
        return String.format("(%d) %d-%d", area, exchange, number);
    }
    
    private String generateUKPhone() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return "+44 " + random.nextInt(1000, 9999) + " " + random.nextInt(100000, 999999);
    }
    
    private String generateInternationalPhone() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int countryCode = random.nextInt(1, 999);
        long number = random.nextLong(1000000000L, 9999999999L);
        return "+" + countryCode + " " + number;
    }
}

// Optimized Date Generator
class DateDataGenerator implements DataGenerator<String> {
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    @Override
    public String generate(DataGenerationConfig config) {
        String format = config.getParameter("format", "yyyy-MM-dd");
        int daysFromNow = config.getParameter("daysFromNow", 0);
        int randomRange = config.getParameter("randomRange", 365);
        
        DateTimeFormatter formatter = format.equals("yyyy-MM-dd") ? 
                                    DEFAULT_FORMATTER : DateTimeFormatter.ofPattern(format);
        
        LocalDate baseDate = LocalDate.now().plusDays(daysFromNow);
        LocalDate randomDate = baseDate.plusDays(
            ThreadLocalRandom.current().nextInt(-randomRange, randomRange + 1)
        );
        
        return randomDate.format(formatter);
    }
    
    @Override
    public List<String> generateBatch(DataGenerationConfig config, int count) {
        List<String> batch = new ArrayList<>(count);
        String format = config.getParameter("format", "yyyy-MM-dd");
        int daysFromNow = config.getParameter("daysFromNow", 0);
        int randomRange = config.getParameter("randomRange", 365);
        
        DateTimeFormatter formatter = format.equals("yyyy-MM-dd") ? 
                                    DEFAULT_FORMATTER : DateTimeFormatter.ofPattern(format);
        LocalDate baseDate = LocalDate.now().plusDays(daysFromNow);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        
        for (int i = 0; i < count; i++) {
            LocalDate randomDate = baseDate.plusDays(random.nextInt(-randomRange, randomRange + 1));
            batch.add(randomDate.format(formatter));
        }
        return batch;
    }
}

// Optimized JSON Generator
class JsonDataGenerator implements DataGenerator<String> {
    private final StringDataGenerator stringGenerator = new StringDataGenerator();
    private final IntegerDataGenerator integerGenerator = new IntegerDataGenerator();
    private final EmailDataGenerator emailGenerator = new EmailDataGenerator();
    
    @Override
    public String generate(DataGenerationConfig config) {
        String template = config.getParameter("template", "user");
        
        switch (template.toLowerCase()) {
            case "user":
                return generateUserJson();
            case "product":
                return generateProductJson();
            case "order":
                return generateOrderJson();
            default:
                return generateGenericJson();
        }
    }
    
    @Override
    public List<String> generateBatch(DataGenerationConfig config, int count) {
        List<String> batch = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            batch.add(generate(config));
        }
        return batch;
    }
    
    private String generateUserJson() {
        String name = stringGenerator.generate(new DataGenerationConfig(DataType.STRING)
                .withParameter("pattern", "name"));
        String email = emailGenerator.generate(new DataGenerationConfig(DataType.EMAIL));
        int age = integerGenerator.generate(new DataGenerationConfig(DataType.INTEGER)
                .withParameter("min", 18).withParameter("max", 80));
        String id = UUID.randomUUID().toString();
        
        return String.format(
            "{\"id\":\"%s\",\"name\":\"%s\",\"email\":\"%s\",\"age\":%d,\"active\":true}",
            id, name, email, age
        );
    }
    
    private String generateProductJson() {
        String name = stringGenerator.generate(new DataGenerationConfig(DataType.STRING)
                .withParameter("length", 15));
        int price = integerGenerator.generate(new DataGenerationConfig(DataType.INTEGER)
                .withParameter("min", 10).withParameter("max", 1000));
        String id = UUID.randomUUID().toString();
        
        return String.format(
            "{\"id\":\"%s\",\"name\":\"%s\",\"price\":%d,\"inStock\":true}",
            id, name, price
        );
    }
    
    private String generateOrderJson() {
        String orderId = UUID.randomUUID().toString();
        String customerId = UUID.randomUUID().toString();
        int total = integerGenerator.generate(new DataGenerationConfig(DataType.INTEGER)
                .withParameter("min", 50).withParameter("max", 500));
        
        return String.format(
            "{\"orderId\":\"%s\",\"customerId\":\"%s\",\"total\":%d,\"status\":\"pending\"}",
            orderId, customerId, total
        );
    }
    
    private String generateGenericJson() {
        return "{\"key\":\"value\",\"number\":42,\"boolean\":true}";
    }
}

// Optimized Factory with singleton pattern
class TestDataGeneratorFactory {
    private static final TestDataGeneratorFactory INSTANCE = new TestDataGeneratorFactory();
    private final Map<DataType, DataGenerator<?>> generators;
    
    private TestDataGeneratorFactory() {
        generators = new EnumMap<>(DataType.class);
        generators.put(DataType.STRING, new StringDataGenerator());
        generators.put(DataType.INTEGER, new IntegerDataGenerator());
        generators.put(DataType.EMAIL, new EmailDataGenerator());
        generators.put(DataType.PHONE, new PhoneDataGenerator());
        generators.put(DataType.DATE, new DateDataGenerator());
        generators.put(DataType.JSON, new JsonDataGenerator());
    }
    
    public static TestDataGeneratorFactory getInstance() {
        return INSTANCE;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T generateData(DataGenerationConfig config) {
        DataGenerator<T> generator = (DataGenerator<T>) generators.get(config.getDataType());
        if (generator == null) {
            throw new IllegalArgumentException("No generator found for type: " + config.getDataType());
        }
        return generator.generate(config);
    }
    
    @SuppressWarnings("unchecked")
    public <T> List<T> generateBatch(DataGenerationConfig config, int count) {
        DataGenerator<T> generator = (DataGenerator<T>) generators.get(config.getDataType());
        if (generator == null) {
            throw new IllegalArgumentException("No generator found for type: " + config.getDataType());
        }
        return generator.generateBatch(config, count);
    }
}

// Optimized Builder with fluent interface
class TestDataSetBuilder {
    private final TestDataGeneratorFactory factory;
    private final Map<String, Object> dataSet;
    
    public TestDataSetBuilder() {
        this.factory = TestDataGeneratorFactory.getInstance();
        this.dataSet = new LinkedHashMap<>(); // Preserve insertion order
    }
    
    public TestDataSetBuilder addField(String fieldName, DataGenerationConfig config) {
        Object data = factory.generateData(config);
        dataSet.put(fieldName, data);
        return this;
    }
    
    public TestDataSetBuilder addBatchField(String fieldName, DataGenerationConfig config, int count) {
        List<?> data = factory.generateBatch(config, count);
        dataSet.put(fieldName, data);
        return this;
    }
    
    public Map<String, Object> build() {
        return new LinkedHashMap<>(dataSet);
    }
    
    public String buildAsJson() {
        StringBuilder json = new StringBuilder("{");
        boolean first = true;
        
        for (Map.Entry<String, Object> entry : dataSet.entrySet()) {
            if (!first) json.append(",");
            json.append("\"").append(entry.getKey()).append("\":");
            
            Object value = entry.getValue();
            appendJsonValue(json, value);
            first = false;
        }
        
        json.append("}");
        return json.toString();
    }
    
    private void appendJsonValue(StringBuilder json, Object value) {
        if (value instanceof String) {
            json.append("\"").append(value).append("\"");
        } else if (value instanceof List) {
            json.append("[");
            List<?> list = (List<?>) value;
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) json.append(",");
                appendJsonValue(json, list.get(i));
            }
            json.append("]");
        } else {
            json.append(value);
        }
    }
}

// Main class with optimized execution
public class TestDataGenerator {
    public static void main(String[] args) {
        System.out.println("=== OPTIMIZED TEST DATA GENERATOR ===\n");
        
        TestDataGeneratorFactory factory = TestDataGeneratorFactory.getInstance();
        
        // 1. String generation examples
        System.out.println("1. STRING GENERATION:");
        demonstrateStringGeneration(factory);
        
        // 2. Numeric generation
        System.out.println("\n2. NUMERIC GENERATION:");
        demonstrateNumericGeneration(factory);
        
        // 3. Email generation
        System.out.println("\n3. EMAIL GENERATION:");
        demonstrateEmailGeneration(factory);
        
        // 4. Complex data sets
        System.out.println("\n4. COMPLEX DATA SETS:");
        demonstrateComplexDataSets();
        
        // 5. Performance test
        System.out.println("\n5. PERFORMANCE TEST:");
        demonstratePerformance(factory);
        
        System.out.println("\n=== GENERATION COMPLETED ===");
    }
    
    private static void demonstrateStringGeneration(TestDataGeneratorFactory factory) {
        DataGenerationConfig nameConfig = new DataGenerationConfig(DataType.STRING)
                .withParameter("pattern", "name");
        System.out.println("Names: " + factory.generateBatch(nameConfig, 3));
        
        DataGenerationConfig alphanumericConfig = new DataGenerationConfig(DataType.STRING)
                .withParameter("pattern", "alphanumeric")
                .withParameter("length", 8);
        System.out.println("Alphanumeric: " + factory.generateBatch(alphanumericConfig, 3));
    }
    
    private static void demonstrateNumericGeneration(TestDataGeneratorFactory factory) {
        DataGenerationConfig intConfig = new DataGenerationConfig(DataType.INTEGER)
                .withParameter("min", 100)
                .withParameter("max", 999);
        System.out.println("Random integers: " + factory.generateBatch(intConfig, 5));
    }
    
    private static void demonstrateEmailGeneration(TestDataGeneratorFactory factory) {
        DataGenerationConfig emailConfig = new DataGenerationConfig(DataType.EMAIL)
                .withParameter("domain", "testcompany.com");
        System.out.println("Emails: " + factory.generateBatch(emailConfig, 3));
    }
    
    private static void demonstrateComplexDataSets() {
        TestDataSetBuilder builder = new TestDataSetBuilder();
        
        Map<String, Object> testData = builder
                .addField("userId", new DataGenerationConfig(DataType.STRING)
                        .withParameter("pattern", "alphanumeric")
                        .withParameter("length", 8))
                .addField("userName", new DataGenerationConfig(DataType.STRING)
                        .withParameter("pattern", "name"))
                .addField("userEmail", new DataGenerationConfig(DataType.EMAIL))
                .addField("userAge", new DataGenerationConfig(DataType.INTEGER)
                        .withParameter("min", 18)
                        .withParameter("max", 65))
                .build();
        
        System.out.println("Complex test data:");
        testData.forEach((key, value) -> System.out.println("  " + key + ": " + value));
    }
    
    private static void demonstratePerformance(TestDataGeneratorFactory factory) {
        long startTime = System.currentTimeMillis();
        
        DataGenerationConfig config = new DataGenerationConfig(DataType.STRING)
                .withParameter("pattern", "alphanumeric")
                .withParameter("length", 10);
        
        List<String> largeDataSet = factory.generateBatch(config, 10000);
        
        long endTime = System.currentTimeMillis();
        System.out.printf("Generated %d strings in %d ms%n", 
                         largeDataSet.size(), endTime - startTime);
        System.out.println("Sample: " + largeDataSet.subList(0, 3));
    }
}
