package test;

import drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUpMethod() {
        // Any setup before each test method can be added here
    }

    @AfterMethod
    public void tearDownMethod() {
        // Any cleanup after each test method can be added here
        DriverManager.getDriver().quit();
    }
}
