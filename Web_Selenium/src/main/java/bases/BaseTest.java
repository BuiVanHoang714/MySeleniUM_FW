package bases;

import assertions.AssertManager;
import assertions.Assert;
import drivers.DriverManager;
import drivers.DriverOC;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    private void setDriver(WebDriver driver) {
        DriverManager.setDriver(driver);
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        setDriver(new DriverOC().initializeDriver(browser));
        AssertManager.setAssertions(new Assert());
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.getDriver().quit();
    }

}

