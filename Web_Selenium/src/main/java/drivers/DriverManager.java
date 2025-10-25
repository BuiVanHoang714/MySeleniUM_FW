package drivers;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    @Getter
    private static  WebDriver driver;

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }
}
