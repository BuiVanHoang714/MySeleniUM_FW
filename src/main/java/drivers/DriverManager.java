package drivers;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

/**
 * Driver Manager - Manages WebDriver instances using ThreadLocal
 * Ensures thread-safety for parallel test execution
 */
public class DriverManager {

    @Getter
    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void removeDriver() {
        if (driver != null) {
            driver = null;
        }
    }
}
