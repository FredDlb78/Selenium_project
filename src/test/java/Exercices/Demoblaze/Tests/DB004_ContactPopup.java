package Exercices.Demoblaze.Tests;

import PageObjectModel.Demoblaze.HeaderPage;
import PageObjectModel.Demoblaze.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB004_ContactPopup {
    static FirefoxDriver driver;
    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();

    }
    @Test
    @DisplayName("")
    @Description("")

    public void testName() {
        HeaderPage objHeaderPage = new HeaderPage(driver);

        objHeaderPage.clickContactButton();
        objHeaderPage.setContactEmailContactPopup("f.delabre89+1234@gmail.com");
        objHeaderPage.setContactNameContactPopup("Marco Verratti");
        objHeaderPage.setMessageContactPopup("Ceci est un message pour le test DB004_ContactPopUp");
        objHeaderPage.clickSendMessageButton();


    }
    @AfterEach

    public void tearDown(){

        driver.quit();
    }
}
