# Testing & Automation

## 1. What is Page Object Model (POM)?

Page Object Model is a design pattern that:
- **Encapsulates** web page elements and actions in separate classes
- **Reduces code duplication** by centralizing element locators
- **Improves maintainability** when UI changes occur
- **Enhances readability** by using meaningful method names

### Benefits:
- Easy maintenance
- Code reusability
- Better test organization
- Separation of test logic and page logic

**Example:** See `codes/PageObjectModelExample.java`

## 2. How do you handle dynamic elements in Selenium?

### Strategies for Dynamic Elements:

1. **Explicit Waits**: WebDriverWait with ExpectedConditions
2. **Partial Locators**: Use contains(), starts-with()
3. **Dynamic XPath**: Build XPath with variables
4. **CSS Selectors**: More flexible than XPath
5. **JavaScript Executor**: Direct DOM manipulation

### Common Dynamic Scenarios:
- Loading spinners
- AJAX content
- Dynamic IDs
- Pop-ups and modals

**Example:** See `codes/DynamicElementsHandling.java`

## 3. What are the advantages of TestNG over JUnit?

| TestNG | JUnit |
|--------|-------|
| Annotations more powerful | Limited annotations |
| Built-in reporting | Requires external tools |
| Data providers | Limited parameterization |
| Test dependencies | No dependencies |
| Parallel execution | Limited parallel support |
| Flexible test configuration | Basic configuration |

### TestNG Advantages:
- **Annotations**: @BeforeClass, @AfterClass, @DataProvider
- **Grouping**: Organize tests into groups
- **Dependencies**: Test method dependencies
- **Parameters**: XML and annotation-based parameters
- **Listeners**: Custom test listeners
- **Reporting**: Built-in HTML reports

**Example:** See `codes/TestNGExample.java`

## 4. How do you implement data-driven testing in TestNG?

### Data-Driven Testing Approaches:

1. **@DataProvider**: Method-level data provision
2. **XML Parameters**: TestNG XML configuration
3. **Excel Files**: Apache POI for Excel reading
4. **CSV Files**: Simple comma-separated values
5. **JSON Files**: Structured data format
6. **Database**: Direct database queries

**Example:** See `codes/DataDrivenTesting.java`

## 5. How do you design a scalable automation framework?

### Framework Components:

1. **Page Object Model**: UI abstraction layer
2. **Configuration Management**: Properties/YAML files
3. **Test Data Management**: External data sources
4. **Reporting**: ExtentReports, Allure
5. **Logging**: Log4j, SLF4J
6. **Utilities**: Common helper methods
7. **CI/CD Integration**: Jenkins, GitHub Actions

### Design Principles:
- **Modularity**: Separate concerns
- **Reusability**: Common components
- **Maintainability**: Easy to update
- **Scalability**: Handle growth
- **Reliability**: Stable execution

**Example:** See `codes/AutomationFrameworkStructure.java`

## 6. How do you test REST APIs using Java?

### API Testing Tools:
1. **RestAssured**: Popular Java library
2. **Apache HttpClient**: Low-level HTTP operations
3. **OkHttp**: Modern HTTP client
4. **TestNG/JUnit**: Test execution framework

### Testing Aspects:
- **Status Codes**: 200, 404, 500, etc.
- **Response Time**: Performance validation
- **Headers**: Content-Type, Authorization
- **Body Content**: JSON/XML validation
- **Schema Validation**: Structure verification

**Example:** See `codes/RestApiTesting.java`

## 7. How do you validate JSON responses?

### JSON Validation Methods:

1. **JSONPath**: Query JSON data
2. **Jackson**: JSON parsing library
3. **Gson**: Google's JSON library
4. **JSON Schema**: Structure validation
5. **RestAssured**: Built-in JSON validation

### Validation Types:
- **Value Validation**: Specific field values
- **Structure Validation**: JSON schema
- **Type Validation**: Data types
- **Array Validation**: List elements

**Example:** See `codes/JsonValidation.java`

## 8. How do you handle authentication in API testing?

### Authentication Types:

1. **Basic Authentication**: Username/password
2. **Bearer Token**: JWT tokens
3. **API Key**: Header or query parameter
4. **OAuth 2.0**: Authorization framework
5. **Session-based**: Cookie authentication

### Implementation Strategies:
- **Pre-request setup**: Obtain tokens
- **Header management**: Authorization headers
- **Token refresh**: Handle expiration
- **Environment-specific**: Different credentials

**Example:** See `codes/ApiAuthentication.java`
