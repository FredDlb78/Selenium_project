package Exercices.Demoblaze.Tests;

import Credentials.DemoblazeAccounts;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjectModel.Demoblaze.HeaderPage;
import PageObjectModel.Demoblaze.HomePage;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB001_Signin {
    static FirefoxDriver driver;
    static String username;
    static String password;

    @BeforeAll
    public static void testInscription() {
        DemoblazeAccounts.newAccount();
        username = DemoblazeAccounts.getUsername();
        password = DemoblazeAccounts.getPassword();
        // Utilisez le username et le password pour l'inscription
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Signin01")
    @Description("Passing case")

    public void Signin01() {

        HomePage objHomePage = new HomePage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);


        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickSignUpButton();
        assertTrue(objHeaderPage.isVisibleSignupButton());
        objHeaderPage.setUsernameSignUpPopup(username);
        objHeaderPage.setPasswordSignUpPopup(password);
        objHeaderPage.clickSignupButtonSignupPopup();
        objHeaderPage.verifyAlertText("Sign up successful.",
                "Alert message is not correct");

    }
    @Test
    @DisplayName("Signin02")
    @Description("Non-passing case - User already exists")

    public void Signin02() {
        HomePage objHomePage = new HomePage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);


        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickSignUpButton();
        assertTrue(objHeaderPage.isSignupPopupTitleCorrect("Sign up"),
                "Popup Title is not correct");
        assertTrue(objHeaderPage.isVisibleSignupButton());
        objHeaderPage.setUsernameSignUpPopup(username);
        objHeaderPage.setPasswordSignUpPopup(password);
        objHeaderPage.clickSignupButtonSignupPopup();
        objHeaderPage.verifyAlertText("This user already exist.",
                "Alert message is not correct");
    }

    @Test
    @DisplayName("Signin03")
    @Description("Non-passing case - Not filling the username field")

    public void Signin03() {
        HomePage objHomePage = new HomePage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);


        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickSignUpButton();
        assertTrue(objHeaderPage.isSignupPopupTitleCorrect("Sign up"),
                "Popup Title is not correct");
        assertTrue(objHeaderPage.isVisibleSignupButton());
        objHeaderPage.setUsernameSignUpPopup("");
        objHeaderPage.setPasswordSignUpPopup(password);
        objHeaderPage.clickSignupButtonSignupPopup();
        objHeaderPage.verifyAlertText("Please fill out Username and Password.",
                "Alert message is not correct");
    }
    @Test
    @DisplayName("Signin04")
    @Description("Non-passing case - Not filling the password field")

    public void Signin04() {
        HomePage objHomePage = new HomePage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);


        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickSignUpButton();
        assertTrue(objHeaderPage.isSignupPopupTitleCorrect("Sign up"),
                "Popup Title is not correct");
        assertTrue(objHeaderPage.isVisibleSignupButton());
        objHeaderPage.setUsernameSignUpPopup(username);
        objHeaderPage.setPasswordSignUpPopup("");
        objHeaderPage.clickSignupButtonSignupPopup();
        objHeaderPage.verifyAlertText("Please fill out Username and Password.",
                "Alert message is not correct");
    }


    @AfterEach

    public void tearDown(){
        driver.quit();
    }
}
