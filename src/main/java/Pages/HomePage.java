package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utilities.ScreenShotsPaths.*;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By shopBtn = By.id("comp-iy4cwgmq1label");
    private By mainImageLoaded = By.id("img_comp-j4o1o5uq");
    private By textLoaded = By.id("bgMedia_comp-j4o0v5j8");
    private String selectedColor = "rgba(190, 176, 156, 1)";

    public ShopPage clickShopBtn() {
        takeScreenShot(HOME_PATH,mainImageLoaded);
        shopClicked();
        findElement(shopBtn).getCssValue("color");
        takeScreenShot(SHOP_PATH,textLoaded);
        return new ShopPage(driver);
    }
    public void shopClicked(){
           if(elementVisible(shopBtn)){findElement(shopBtn).click();}
         if(!(findElement(shopBtn).getCssValue("color").equals(selectedColor))){
            findElement(shopBtn).click();}
    }
}