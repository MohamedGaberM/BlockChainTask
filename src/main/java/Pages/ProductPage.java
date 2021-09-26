package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utilities.ScreenShotsPaths.*;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By increaseProductAmount = By.cssSelector("span[data-hook='number-input-spinner-up-arrow']");

    private By colorSelect = By.xpath("(//div[contains(@class,'ColorPickerItem1936504531__radioInner')])[1]");
    private By cartBtn =
            By.cssSelector(".buttonnext1472800972__root.Focusable3907780744__root.Button3423134372__root.Button3423134372--fullWidth.StatesButton828051268__root.AddToCartButton3061789056__addToCartButton");
    private By viewCartBtn = By.xpath("(//a[contains(@id,'widget-view-cart-button')])[1]");
    private String frameClassName ="_2DJg7";



    public CheckOutPage addToCart(){
        chooseColor();
        increaseCountToThree();
        takeScreenShotWithOutWait(AMOUNT_And_COLOR_OF_PRODUCT);
        addToCartClick();
        viewCartClick();
        takeScreenShotWithOutWait(VIEW_CART_PATH);
        return new CheckOutPage(driver);
    }

    public void increaseCountToThree(){
        for(int i =0; i<2 ;i++){
            findElement(increaseProductAmount).click();
        }
        scrollDown();
    }

    public void chooseColor(){
        actionClick(colorSelect);
    }
    public void addToCartClick(){
        findElement(cartBtn).click();
    }

    public void viewCartClick(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.className(frameClassName)));
        if (elementVisible(viewCartBtn)){actionClick(viewCartBtn);}
    }
}