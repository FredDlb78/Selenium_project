package Exercices.Demoblaze.E2E;

import PageObjectModel.Demoblaze.HeaderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class E2E_001 {
    static FirefoxDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }
    public static int generateId() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }
    // Génération de l'ID
    int id = generateId();

    // Création du nom d'utilisateur
    String username = "username" + id;
    String password = "Test@1234";

    @Test
    @DisplayName("E2E_EE001")
    @Description("Passing case")

    public void Step01_Signin(){
        HeaderPage objHeaderPage = new HeaderPage(driver);

        objHeaderPage.clickSignUpButton();
        objHeaderPage.setUsernameSignUpPopup(username);
        objHeaderPage.setPasswordSignUpPopup(password);
        objHeaderPage.clickSignupButtonSignupPopup();
        objHeaderPage.verifyAlertText("Sign up successful.",
                "Alert message is not correct");
    }
}
