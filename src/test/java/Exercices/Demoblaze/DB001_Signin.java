package Exercices.Demoblaze;


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

    @BeforeAll
    public static void setUp() {
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
        assertTrue(objHeaderPage.isTitleCorrect("Sign up"),
                "Popup Title is not correct");
        assertTrue(objHeaderPage.isVisibleSignupButton());
        objHeaderPage.setUsernameSignUpPopup("Fredinho7830078");
        objHeaderPage.setPasswordSignUpPopup("Test@1234");
        objHeaderPage.clickSignupButtonSignupPopup();
        // Ajouter une assertion sur le message dans la popup via l'interception de requête
        // Sign up successful.
        // objHeaderPage.clickSignupPopupCrossButton();
    }
    @Test
    @DisplayName("Signin02")
    @Description("Non-passing case - User already exists")

    public void Signin02() {
        HomePage objHomePage = new HomePage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);


        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickSignUpButton();
        assertTrue(objHeaderPage.isTitleCorrect("Sign up"),
                "Popup Title is not correct");
        assertTrue(objHeaderPage.isVisibleSignupButton());
        objHeaderPage.setUsernameSignUpPopup("Fredinho78");
        objHeaderPage.setPasswordSignUpPopup("Test@1234");
        objHeaderPage.clickSignupButtonSignupPopup();
        // Ajouter une assertion sur le message dans la popup via l'interception de requête
        // This user already exist.
        // objHeaderPage.clickSignupPopupCrossButton();
    }

    @Test
    @DisplayName("Signin03")
    @Description("Non-passing case - Not filling the username field")

    public void Signin03() {
        HomePage objHomePage = new HomePage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);


        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickSignUpButton();
        assertTrue(objHeaderPage.isTitleCorrect("Sign up"),
                "Popup Title is not correct");
        assertTrue(objHeaderPage.isVisibleSignupButton());
        objHeaderPage.setUsernameSignUpPopup("");
        objHeaderPage.setPasswordSignUpPopup("Test@1234");
        objHeaderPage.clickSignupButtonSignupPopup();
        // Ajouter une assertion sur le message dans la popup via l'interception de requête
        // Please fill out Username And Password
        // objHeaderPage.clickSignupPopupCrossButton();
    }
    @Test
    @DisplayName("Signin04")
    @Description("Non-passing case - Not filling the password field")

    public void Signin04() {
        HomePage objHomePage = new HomePage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);


        assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickSignUpButton();
        assertTrue(objHeaderPage.isTitleCorrect("Sign up"),
                "Popup Title is not correct");
        assertTrue(objHeaderPage.isVisibleSignupButton());
        objHeaderPage.setUsernameSignUpPopup("Fredinho78");
        objHeaderPage.setPasswordSignUpPopup("");
        objHeaderPage.clickSignupButtonSignupPopup();
        // Ajouter une assertion sur le message dans la popup via l'interception de requête
        // Please fill out Username And Password
        // objHeaderPage.clickSignupPopupCrossButton();
    }


    @AfterAll

    public static void tearDown(){
        driver.quit();
    }
}
