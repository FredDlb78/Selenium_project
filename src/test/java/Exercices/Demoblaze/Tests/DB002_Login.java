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
public class DB002_Login {
    static FirefoxDriver driver;
    String username = "JamesSele";
    String password = "Test@1234";
    String notRegisteredUser = "notRegisterUser1234";
    String wrongPassword = "WrongPassword";
    String emptyUsername = "";
    String emptyPassword = "";



    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();

    }
    @Test
    @DisplayName("Login01")
    @Description("Passing case")

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
    @Test
    @DisplayName("Login02")
    @Description("Non-passing case - Not registered user")

    public void Login02() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        HomePage objHomePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickLogInButton();
        objHeaderPage.setUsernameLoginPopup(notRegisteredUser);
        objHeaderPage.setPasswordLoginPopup(password);
        objHeaderPage.clickLogInButtonLogInPopUp();
        objHeaderPage.verifyAlertText("User does not exist.",
                "Alert message is not correct");
    }
    @Test
    @DisplayName("Login03")
    @Description("Non-passing case - Wrong password")

    public void Login03() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        HomePage objHomePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickLogInButton();
        objHeaderPage.setUsernameLoginPopup(username);
        objHeaderPage.setPasswordLoginPopup(wrongPassword);
        objHeaderPage.clickLogInButtonLogInPopUp();
        objHeaderPage.verifyAlertText("Wrong password.",
                "Alert message is not correct");
    }
    @Test
    @DisplayName("Login04")
    @Description("Non-passing case - Empty username")

    public void Login04() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        HomePage objHomePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickLogInButton();
        objHeaderPage.setUsernameLoginPopup(emptyUsername);
        objHeaderPage.setPasswordLoginPopup(password);
        objHeaderPage.clickLogInButtonLogInPopUp();
        objHeaderPage.verifyAlertText("Please fill out Username and Password.",
                "Alert message is not correct");
    }
    @Test
    @DisplayName("Login05")
    @Description("Non-passing case - Empty password")

    public void Login05() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        HomePage objHomePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickLogInButton();
        objHeaderPage.setUsernameLoginPopup(username);
        objHeaderPage.setPasswordLoginPopup(emptyPassword);
        objHeaderPage.clickLogInButtonLogInPopUp();
        objHeaderPage.verifyAlertText("Please fill out Username and Password.",
                "Alert message is not correct");
    }
    @AfterEach

    public void tearDown(){
        driver.quit();
    }
}

