package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtil;

import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ctl00_cphMain_txtNum")
    private WebElement txtProductNumber;

    @FindBy(xpath = "//button[contains(.,'Check the booking items')]")
    private WebElement checkBookingItemsBtn;

    @FindBy(id = "ctl00_cphMain_cartButton_spanExecutePanel")
    private WebElement addToCartBtn;


    @FindBy(css = ".areaSortType span")
    private List<WebElement> sortByList;

    private By xDynamicProduct(String category, String name, String price) {
        return By.xpath(String.format("//div[@class='item_box_frame' and .//span/.='%s' and .//span/.='%s' and .//span/.='%s']//ancestor::a", category, name, price));
    }

    public void sortBy(String expectedSort) {
        WaitUtil.waitListElementAppear(sortByList);
        elementUtil.selectByLoopText(sortByList, expectedSort);

    }

    public void addProductsToCart(Product expectedProduct, int productNumber) {
        elementUtil.getElement(xDynamicProduct(expectedProduct.getCategory(), expectedProduct.getTitle(), expectedProduct.getPrice())).click();
        WaitUtil.waitVisible(txtProductNumber);
        txtProductNumber.clear();
        txtProductNumber.sendKeys(String.valueOf(productNumber));
        addToCartBtn.click();
        WaitUtil.waitClickable(checkBookingItemsBtn);
        checkBookingItemsBtn.click();
    }

}
