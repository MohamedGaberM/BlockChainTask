package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utilities.ScreenShotsPaths.*;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private By checkoutBtn = By.cssSelector("button[data-hook='CheckoutButtonDataHook.button']");
    private By feesText = By.cssSelector("dd[data-hook='Total.formattedValue']");
    private By goIt = By.cssSelector("button[data-hook='close-button']");
    private String popUpFrame ="MUsGO";

    public void clickOnProceedToCheckOutBtn(){
        takeScreenShotWithOutWait(PRICE_PATH);
        scrollDown();
        actionClick(checkoutBtn);
        takeScreenAfterCheckOutClick();
    }

    public String getProductsFees(){
        elementVisible(feesText);
        return findElement(feesText).getText();
    }
    public void takeScreenAfterCheckOutClick(){
        driver.switchTo().frame(findElement(By.className(popUpFrame)));
        if(elementVisible(goIt)){
        takeScreenShotWithOutWait(CHECKOUT_PATH);}
    }
}