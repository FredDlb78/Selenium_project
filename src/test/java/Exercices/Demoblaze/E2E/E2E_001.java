package Exercices.Demoblaze.E2E;

import Credentials.DemoblazeAccounts;
import PageObjectModel.Demoblaze.HeaderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class E2E_001 {
    static FirefoxDriver driver;
    static String username;
    static String password;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("E2E_EE001")
    @Description("Passing case")
    public void Step01_Signin(){
        DemoblazeAccounts.newAccount();
        username = DemoblazeAccounts.getUsername();
        password = DemoblazeAccounts.getPassword();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // Attendre jusqu'à 10 secondes maximum
        HeaderPage objHeaderPage = new HeaderPage(driver);

        objHeaderPage.clickSignUpButton();
        objHeaderPage.setUsernameSignUpPopup(username);
        objHeaderPage.setPasswordSignUpPopup(password);
        objHeaderPage.clickSignupButtonSignupPopup();
        objHeaderPage.verifyAlertText("Sign up successful.",
                "Alert message is not correct");
        objHeaderPage.clickLogInButton();
        objHeaderPage.setUsernameLoginPopup(username);
        objHeaderPage.setPasswordLoginPopup(password);
        objHeaderPage.clickLogInButtonLogInPopUp();
        wait.until(ExpectedConditions.visibilityOf(objHeaderPage.getLogoutButton()));
        objHeaderPage.isVisibleLogOutButton();
        assertTrue(objHeaderPage.welcomeUserButtonContainsText(username),
                "Wrong username");
    }

    @AfterAll
    public static void tearDown(){ driver.quit();}
}

