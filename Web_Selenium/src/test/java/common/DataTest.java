package common;

import models.Product;

import java.util.ArrayList;
import java.util.List;

public class DataTest {
    public final String LOGIN_PAGE_URL = "https://practicetestautomation.com/practice-test-login/";

    public final String HIGH_TO_LOW = "Price: high to low";

    public final String LIPS = "Cosmetics/Make-up/Lips";

    public DataTest() {

    }

    public List<String> buildMenuQuickAccessItem() {
        List<String> ret = new ArrayList<>();
        ret.add("HOME");
        ret.add("PRACTICE");
        ret.add("Courses");
        ret.add("Blog");
        ret.add("Contact");
        return ret;
    }

    public Product buildProductToAdd() {
        return new Product().getProductByTitle("ANNA SUI Lipstick Trio 01 Lipstick Trio");
    }

    public Product buildProductToVerify() {
        return new Product().getProductByTitle("ANNA SUI Lipstick Trio 01 Lipstick Trio");
    }


}









