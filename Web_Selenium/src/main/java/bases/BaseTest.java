package bases;

import assertions.AssertManager;
import assertions.Assert;
import drivers.DriverManager;
import drivers.DriverOC;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Base Test Class - Foundation for all test classes
 * Provides common test setup and teardown functionality
 * Manages WebDriver lifecycle and test configuration
 */
public class BaseTest {

    /**
     * Get the current WebDriver instance from ThreadLocal
     *
     * @return WebDriver instance for current thread
     */
    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    /**
     * Set WebDriver instance to ThreadLocal
     *
     * @param driver WebDriver instance to set
     */
    private void setDriver(WebDriver driver) {
        DriverManager.setDriver(driver);
    }

    /**
     * Setup method executed before each test method
     * Initializes WebDriver and assertion manager
     *
     * @param browser Browser type (chrome, edge, firefox)
     */
    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("edge") String browser) {
        try {
            System.out.println("=== Setting up test with browser: " + browser + " ===");
            WebDriver driver = new DriverOC().initializeDriver(browser);
            setDriver(driver);
            AssertManager.setAssertions(new Assert());

            // Maximize window and set implicit wait
            driver.manage().window().maximize();
            System.out.println("=== Test setup completed successfully ===");
        } catch (Exception e) {
            System.err.println("Failed to initialize driver: " + e.getMessage());
            throw new RuntimeException("Test setup failed", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                System.out.println("=== Closing browser and cleaning up resources ===");
                driver.quit();
                System.out.println("=== Teardown completed successfully ===");
            }
        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
        } finally {
            DriverManager.removeDriver();
        }
    }

    /**
     * Optional: Suite level setup
     * Can be used for one-time initialization before all tests
     */
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("========================================");
        System.out.println("    TEST SUITE STARTING");
        System.out.println("========================================");
    }

    /**
     * Optional: Suite level teardown
     * Can be used for cleanup after all tests complete
     */
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("========================================");
        System.out.println("    TEST SUITE COMPLETED");
        System.out.println("========================================");
    }

    protected void navigateToUrl(String url) {
        System.out.println("Navigating to: " + url);
        getDriver().get(url);
        // Wait for page to be ready
        try {
            Thread.sleep(1000); // Short wait for page to start loading
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    protected String getPageTitle() {
        return getDriver().getTitle();
    }

    protected String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}

