package test;

import bases.BaseTest;
import drivers.DriverManager;
import org.testng.annotations.Test;
import pages.*;
import reports.ExtentLogger;
import common.DataTest;

public class TestCase extends BaseTest {


    @Test()
    public void Test_Case() {
        // init data
        DataTest data = new DataTest();
        // init page
        BasePage basePage = new BasePage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProductPage product = new ProductPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        RankingPage rankingPage = new RankingPage(getDriver());

        //
        ExtentLogger.info("Open web: " + data.VUONG_BAN_LOC_URL);
        DriverManager.getDriver().get(data.VUONG_BAN_LOC_URL);

        ExtentLogger.info("Verify quick access menu:");
        homePage.verifyQuickAccessMenu(data.buildMenuQuickAccessItem());

        ExtentLogger.info("Select Lips's product by menu: " + data.LIPS);
        DriverManager.getDriver().quit();

//        homePage.searchByCategory(data.LIPS);
//
//        ExtentLogger.info("Sort By: " + data.HIGH_TO_LOW);
//        product.sortBy(data.HIGH_TO_LOW);
//
//        ExtentLogger.info("Add product to card.");
//        product.addProductsToCart(data.buildProductToAdd(), 4);

//        ExtentLogger.info("Verify Title, Category, Price of Product");
//        cartPage.verifyProduct(data.buildProductToAdd());
//
//        ExtentLogger.info("Use menu bars to navigate to the Ranking page.");
//        basePage.clickMenuBar("Ranking");
//
//        ExtentLogger.info("Verify Total Number of products.");
//        rankingPage.verifyTotalProduct(9);
//
//        ExtentLogger.info("Get product OverAll on Top 1.");
//        rankingPage.getOverAllProductTop1();
//
//        ExtentLogger.info(("click menu Liquors"));
//        rankingPage.clickMenuCategory("Liquors");
//
//        ExtentLogger.info(("Select Top 1 product"));
//        rankingPage.selectProductOnTop(1);
//
//        ExtentLogger.info(("Verify notify age is over 20:"));
//        rankingPage.verifyNotifyIsDisplayed();
//
//        ExtentLogger.info(("Click Yes to process to next page:"));
//        rankingPage.click("Yes");
















    }

}