package Exercices.Demoblaze;


import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjectModel.Demoblaze.HeaderPage;
import PageObjectModel.Demoblaze.HomePage;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB001_Login {
    static FirefoxDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("DB001_Login")
    @Description("DB_EE001 - Login")

    public void Login01_LoginOk() throws InterruptedException {
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



    }


    @AfterAll

    public static void tearDown(){
        driver.quit();
    }
}
