package tests;

import Pages.CheckOutPage;
import Pages.ProductPage;
import Pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utilities.PriceData.*;

public class OrdersTest extends BaseTest{

    @Test
    public void verifyOrderSpecificProduct_shouldOrder_successfully() throws InterruptedException {
        ShopPage shopPage = homePage.clickShopBtn();
        ProductPage productPage=shopPage.selectProduct();
        CheckOutPage checkOutPage=productPage.addToCart();
        checkOutPage.getProductsFees();
        Assert.assertTrue(checkOutPage.getProductsFees().contains(EXPECTED_PRICE));
        checkOutPage.clickOnProceedToCheckOutBtn();
    }
}