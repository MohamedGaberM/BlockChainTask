package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private final Duration TIMEOUT = Duration.ofSeconds(30);
    private final Duration POLLING_TIMEOUT = Duration.ofMillis(500);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    protected WebElement findElement(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING_TIMEOUT)
                .ignoring(NoSuchElementException.class);
        return wait.until(d -> d.findElement(locator));
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(("window.scrollBy(0,350)"), "");
    }

    public void actionClick(By locator) {
        WebElement element = findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        try {
            element.click();
        } catch (Exception e) {
            findElement(locator).click();
        } }

    public void takeScreenShot(String path ,By locator){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            if(elementVisible(locator)){
            FileUtils.copyFile(screenshot, new File(path));}
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void takeScreenShotWithOutWait(String path){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    protected boolean elementVisible(By locator) {
        boolean flag;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            flag = true;
        } catch (Exception ex) {
            flag = false;
        }
        return flag;
    }
}