package bases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ElementUtil;

import java.time.Duration;
import java.util.List;

/**
 * Base Page Object Class
 * Provides common functionality for all page objects
 * Includes WebDriver, WebDriverWait, Actions, and ElementUtil,....
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ElementUtil elementUtil;
    protected Actions actions;
    protected JavascriptExecutor jsExecutor;

    // Default timeout configurations
    private static final int DEFAULT_TIMEOUT = 10;
    private static final int LONG_TIMEOUT = 30;
    private static final int SHORT_TIMEOUT = 5;

    /**
     *
     * @param driver WebDriver instance
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        this.elementUtil = new ElementUtil(driver);
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Get WebDriverWait with custom timeout
     *
     * @param timeoutInSeconds Timeout in seconds
     * @return WebDriverWait instance
     */
    protected WebDriverWait getWait(int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    protected WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected List<WebElement> waitForElementsVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void jsClick(WebElement element) {
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    protected void highlightElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }


    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected void navigateBack() {
        driver.navigate().back();
    }

    protected void navigateForward() {
        driver.navigate().forward();
    }
}


