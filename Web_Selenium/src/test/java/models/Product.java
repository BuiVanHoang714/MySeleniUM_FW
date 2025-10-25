package models;

import assertions.AssertManager;
import com.google.common.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import utilities.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private String title;
    private String category;
    private String price;

    public Product() {

    }

    public void verifyProducts(Product expectProduct) {
        AssertManager.getAssertions().assertEquals(this.getTitle(), expectProduct.getTitle(), "Verify title of product: ", false);
        AssertManager.getAssertions().assertEquals(this.getCategory(), expectProduct.getCategory(), "Verify category of product: ", false);
        AssertManager.getAssertions().assertEquals(this.getPrice(), expectProduct.getPrice(), "Verify price of product: ", false);
    }

    public Product getProductByTitle(String title) {
        Product product = null;
        List<Product> products = JsonUtil.gsonToType("src/test/resources/common/Products.json", new TypeToken<ArrayList<Product>>() {
        }.getType());
        for (Product obj : products) {
            if (Objects.equals(obj.getTitle(), title)) {
                product = obj;
                break;

            }
        }
        return product;
    }


}
