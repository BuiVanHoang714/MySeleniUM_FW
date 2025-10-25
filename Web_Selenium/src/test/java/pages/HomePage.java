package pages;

import assertions.AssertManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "#ast-hf-menu-1 > li")
    private List<WebElement> quickAccessList;

    private By xDynamicMenuBars(String title) {
        return By.xpath(String.format("//a[normalize-space(text()) = '%s']", title));
    }

    private By xDynamicProductType1(String type1) {
        return By.xpath(String.format("//li[@data-submenu-id='menu_01']/a[normalize-space(text()) = '%s']", type1));
    }

    private By xDynamicProductType2(String type2) {
        return By.xpath(String.format("//li[@data-submenu-id='menu_01_01']/a[normalize-space(text()) = '%s']", type2));
    }

    private By xDynamicProductType3(String type3) {
        return By.xpath(String.format("//span[contains(.,'%s')]", type3));
    }

    public HomePage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void searchByCategory(String category) {
        String[] select = category.split("/");
        actions.moveToElement(elementUtil.getElement(xDynamicMenuBars("Search by category"))).perform();
        actions.moveToElement(elementUtil.getElement(xDynamicProductType1(select[0]))).perform();
        actions.moveToElement(elementUtil.getElement(xDynamicProductType2(select[1]))).perform();
        actions.moveToElement(elementUtil.getElement(xDynamicProductType3(select[2]))).perform();
        elementUtil.getElement(xDynamicProductType3(select[2])).click();
    }

    public void verifyQuickAccessMenu(List<String> expectedQuickAccessList) {
        if (quickAccessList == null || quickAccessList.size() < expectedQuickAccessList.size()) {
            throw new AssertionError("Actual quick access items are fewer than expected. Actual: "
                    + (quickAccessList == null ? 0 : quickAccessList.size())
                    + ", Expected: " + expectedQuickAccessList.size());
        }
        for (int i = 0; i < expectedQuickAccessList.size(); i++) {
            AssertManager.getAssertions().assertEquals(
                    quickAccessList.get(i).getText(),
                    expectedQuickAccessList.get(i),
                    "Verify Title of quick access menus: ",
                    false
            );
        }
    }


}


