package pages;

import assertions.AssertManager;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span[id$=CartNm]")
    private WebElement producTitle;

    @FindBy(css = "span[id$=CartCate]")
    private WebElement productCategory;

    @FindBy(css = "span[id$=lblTotal]")
    private WebElement productTotal;

    public void verifyProduct(Product expectedProduct){
        Product actualProduct = buildActualProduct(expectedProduct);
        actualProduct.verifyProducts(expectedProduct);
    }

    private Product buildActualProduct(Product product){
        Product product1 = new Product();
        if(Objects.equals(producTitle.getText(), product.getTitle())){
            product1.setTitle(producTitle.getText());
            product1.setCategory(productCategory.getText());
            product1.setPrice(productTotal.getText());
        }
        return product1;
    }


}
