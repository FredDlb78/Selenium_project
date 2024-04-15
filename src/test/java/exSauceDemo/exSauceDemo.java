package exSauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjectModel.LoginPage;
import pageObjectModel.ProductPage;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class exSauceDemo {
    static FirefoxDriver driver;
    @BeforeAll
    public static void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("http://saucedemo.com/");
        driver.manage().window().maximize();
    }
    @Test

    public void t001_loginUser(){
        LoginPage objLoginPage = new LoginPage(driver);
        ProductPage objProductPage = new ProductPage(driver);
        objLoginPage.setLoginAsUser();
        Assertions.assertTrue(objProductPage.getProductPageUrl().contains("inventory.html"));

    }
    @Test

    public void t002_filterByPrice(){
        ProductPage objProductPage = new ProductPage(driver);
        objProductPage.setFilterLoHi();
        Assertions.assertTrue(objProductPage.isListInOrder());
    }
}
