package Exercices.Demoblaze.Tests;

import PageObjectModel.Demoblaze.HeaderPage;
import PageObjectModel.Demoblaze.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB002_Login {
    static FirefoxDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }
    @Test
    @DisplayName("Login01")
    @Description("")

    public void Login01() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        HomePage objHomePage = new HomePage(driver);

        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickLogInButton();
        objHeaderPage.setUsernameLoginPopup("Fred");
        objHeaderPage.setPasswordLoginPopup("Test@1234");
        objHeaderPage.clickLogInButtonLogInPopUp();

    }
    @AfterEach

    public void tearDown(){
        driver.quit();
    }
}

