package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utilities.ScreenShotsPaths.*;

public class ShopPage extends BasePage {
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    private By selectProduct = By.xpath("(//div[contains(@class,'_3DNsL _1SZih')])[4]");
    private By productItem =
            By.xpath("(//div[contains(@class,'_1FMIK heightByImageRatio heightByImageRatio0')])[4]");


    public ProductPage selectProduct() {
        takeScreenShot(SHOP_PATH,productItem);
        findElement(selectProduct).click();
        takeScreenShotWithOutWait(SELECT_PRODUCT_PATH);
        return new ProductPage (driver);
    }
}