package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class ElementUtil {
    private final WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<String> actualListbyText(List<WebElement> elements) {
        List<String> actuaList = new ArrayList<>();
        for (WebElement webElement : elements) {
            if (!(webElement.getText().isEmpty())) {
                actuaList.add(webElement.getText());
            }
        }
        return actuaList;
    }

    public void selectByLoopText(List<WebElement> elements, String text) {
        for (WebElement webElement : elements) {
            if (webElement.getText().equals(text)) {
                webElement.click();
                break;
            }
        }
    }

    public void goToCatuneView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToTab(int index) {
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(index));
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void clickByJS(String cssPath) {
        ((JavascriptExecutor) driver).executeScript("document.querySelector(arguments[0],':before').click();", cssPath);
    }
}


