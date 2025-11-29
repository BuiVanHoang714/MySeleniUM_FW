package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends bases.BasePage {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    private By xDynamicMenuBars(String title) {
        return By.xpath(String.format("//a[normalize-space(text()) = '%s']", title));
    }

    public void clickMenuBar(String title) {
        elementUtil.selectByLoopText(elementUtil.getElements(xDynamicMenuBars(title)), title);
    }
}


