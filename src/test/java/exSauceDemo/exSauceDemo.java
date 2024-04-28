package exSauceDemo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjectModel.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(objProductPage.getProductPageUrl().contains("inventory.html"),
                "Article page is not reached");

    }

    @Test

    public void t002_filterByPrice() {
        ProductPage objProductPage = new ProductPage(driver);
        objProductPage.setFilterLoHi();
        assertTrue(objProductPage.isListInOrder(),
                "List not order correctly");
    }


    @Test

    public void t003_addArticleToCart() {
        ProductPage objProductPage = new ProductPage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);
        objProductPage.clickAddToCartBikeLight();
        assertTrue(objHeaderPage.isArticleAddedInCart(),
                "Cart does not contains 1 element");
        //Ajout de cette assertion vs le cours
        try {
            assertTrue(objProductPage.isVisibleRemoveToCartBikeLight());
        } catch (NoSuchElementException e) {
            Assertions.fail("The remove button could not be found.");
        }
    }

    @Test

    public void t004_clickOnCartAndCheckArticle(){
        HeaderPage objHeaderPage = new HeaderPage(driver);
        CartPage objCartPage = new CartPage(driver);
        objHeaderPage.clickOnCart();
        assertTrue(objCartPage.getUrlWebPage().contains("cart.html"),
                "Url is not correct");
        Assertions.assertEquals(objCartPage.getArticleInCart(), "Sauce Labs Bike Light",
                "Article in cart is not the one expected");
        objCartPage.clickCheckout();
    }

    @Test

    public void t005_fillInInformations(){
        CheckoutInformationPage objCheckoutInformationPage = new CheckoutInformationPage(driver);
        assertTrue(objCheckoutInformationPage.getUrlWebPage().contains("checkout-step-one.html"),
                "Url is not correct");
        objCheckoutInformationPage.setFirstName();
        objCheckoutInformationPage.setLastName();
        objCheckoutInformationPage.setPostalCode();
        objCheckoutInformationPage.clickContinue();
    }

    @Test

    public void t006_finishOrder(){
        CheckoutOverviewPage objCheckoutOverviewPage = new CheckoutOverviewPage(driver);
        assertTrue(objCheckoutOverviewPage.getUrlWebPage().contains("checkout-step-two.html"),
                "Url is not correct");
        Assertions.assertEquals(objCheckoutOverviewPage.getTitle(), "Checkout: Overview",
                "Title is not correct");
        //Exemple de 2 assertions sur la même ligne
        assertTrue(objCheckoutOverviewPage.getProductName().contains("Sauce Labs Bike Light")
                && objCheckoutOverviewPage.getProductPrice().contains("$9.99"),
                "Product price or product name is not correct");
        Assertions.assertEquals(objCheckoutOverviewPage.getTotalPrice(),"Total: $10.79",
                "Total price is not correct");
        objCheckoutOverviewPage.clickFinish();
    }
    @Test
    public void  t007_exitTest(){
        driver.quit();
    }
}