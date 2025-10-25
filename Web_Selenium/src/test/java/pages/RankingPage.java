package pages;

import assertions.AssertManager;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reports.ExtentLogger;
import utilities.WaitUtil;

import java.util.List;

public class RankingPage extends BasePage{
    public static String product;

    public RankingPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#ctl00_cphMain_lnkgroup span")
    List<WebElement> menuCategoryList;
    @FindBy(css = ".rankingList>div")
    List<WebElement> productList;

    @FindBy(css = ".modal-body")
    WebElement notify;

    private By xDynamicOptions(String opt) {
        return By.xpath(String.format("//span[contains(text(),'%s')]", opt));
    }


    public void verifyTotalProduct(int expectedTotal){
        WaitUtil.waitListElementAppear(productList);
        AssertManager.getAssertions().assertEquals(productList.size(), expectedTotal, "Verify Total Number of Product:", false);

    }

    public void getOverAllProductTop1(){
        WaitUtil.waitListElementAppear(productList);
        ExtentLogger.details(productList.get(0).findElement(By.cssSelector(" [class=name]")).getText());
    }

    public void clickMenuCategory(String text){
        WaitUtil.waitListElementAppear(menuCategoryList);
        elementUtil.selectByLoopText(productList, text);
    }

    public Product selectProductOnTop(int index){
        WaitUtil.waitListElementAppear(productList);
        Product product1 = new Product();
        productList.get(index - 1).click();
        return  product1;
    }

    public void verifyNotifyIsDisplayed(){
        WaitUtil.waitVisible(notify);
        AssertManager.getAssertions().assertTrue(notify.isDisplayed(),"Verify of Age is 20", false);

    }

    public void click(String opt){
        WaitUtil.waitVisible(notify);
        elementUtil.getElement(xDynamicOptions(opt)).click();

    }





}
