package Exercices.Demoblaze.Tests;

import PageObjectModel.Demoblaze.HeaderPage;
import PageObjectModel.Demoblaze.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB004_ContactPopup {
    static FirefoxDriver driver;
    static String contactEmail = "f.delabre89+1234@gmail.com";
    static String contactName = "Marco Verratti";
    static String message = "Ceci est un message pour le test DB004_ContactPopUp";
    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();

    }
    @Test
    @DisplayName("Contact01")
    @Description("Passing Case")

    public void Contact01() {
        HeaderPage objHeaderPage = new HeaderPage(driver);

        objHeaderPage.clickContactButton();
        objHeaderPage.setContactEmailContactPopup(contactEmail);
        objHeaderPage.setContactNameContactPopup(contactName);
        objHeaderPage.setMessageContactPopup(message);
        objHeaderPage.clickSendMessageButton();
        objHeaderPage.verifyAlertText("Thanks for the message!!",
                "Alert message is not correct");
    }
    @AfterEach

    public void tearDown(){

        driver.quit();
    }
}
