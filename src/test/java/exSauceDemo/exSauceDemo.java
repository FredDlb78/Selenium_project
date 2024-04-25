package exSauceDemo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjectModel.HeaderPage;
import pageObjectModel.LoginPage;
import pageObjectModel.ProductPage;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class exSauceDemo {
    static FirefoxDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test

    public void t001_loginUser() {
        LoginPage objLoginPage = new LoginPage(driver);
        ProductPage objProductPage = new ProductPage(driver);
        objLoginPage.setLoginAsUser();
        Assertions.assertTrue(objProductPage.getProductPageUrl().contains("inventory.html"),
                "Article page is not reached");

    }

    @Test

    public void t002_filterByPrice() {
        ProductPage objProductPage = new ProductPage(driver);
        objProductPage.setFilterLoHi();
        Assertions.assertTrue(objProductPage.isListInOrder(),
                "List not order correctly");
    }


    @Test

    public void t003_addArticleToCart() {
        ProductPage objProductPage = new ProductPage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);
        objProductPage.clickAddToCartBikeLight();
        Assertions.assertTrue(objHeaderPage.isArticleAddedInCart(),
                "Cart does not contains 1 element");
        //Ajout de cette assertion vs le cours
        try{
            Assertions.assertTrue(objProductPage.isVisibleRemoveToCartBikeLight());
        } catch (NoSuchElementException e){
            Assertions.fail("The remove button could not be found.");
        }

}}