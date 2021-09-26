package tests;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public BaseTest(){ }

    public HomePage homePage;
    protected WebDriver driver;
    public String BASE_URL_WIX_SITE = "https://arielkiell.wixsite.com/interview";

    @BeforeMethod(alwaysRun = true)
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(BASE_URL_WIX_SITE);
        Assert.assertEquals(BASE_URL_WIX_SITE,driver.getCurrentUrl());
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}