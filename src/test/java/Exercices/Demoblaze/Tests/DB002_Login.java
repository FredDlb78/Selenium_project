package Exercices.Demoblaze.Tests;

import Credentials.Credentials;
import PageObjectModel.Demoblaze.HeaderPage;
import PageObjectModel.Demoblaze.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Exercices.Demoblaze.Tests.DB001_Signin.password;
import static Exercices.Demoblaze.Tests.DB001_Signin.username;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB002_Login {
    static FirefoxDriver driver;
    String username = "JamesSele";
    String password = "Test@1234";



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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickLogInButton();
        objHeaderPage.setUsernameLoginPopup(username);
        objHeaderPage.setPasswordLoginPopup(password);
        objHeaderPage.clickLogInButtonLogInPopUp();
        wait.until(ExpectedConditions.visibilityOf(objHeaderPage.getLogoutButton()));
        assertTrue(objHeaderPage.isVisibleLogOutButton());
        assertTrue(objHeaderPage.welcomeUserButtonContainsText(username));
    }
    @AfterEach

    public void tearDown(){
        driver.quit();
    }
}

