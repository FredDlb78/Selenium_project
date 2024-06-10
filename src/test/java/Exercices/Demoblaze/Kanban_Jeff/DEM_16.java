package Exercices.Demoblaze.Kanban_Jeff;

import PageObjectModel.Demoblaze.HeaderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

public class DEM_16 {
    static FirefoxDriver driver;
    // je définis un objet qui sappel driver de type Firefoxdrive
    String id = RandomStringUtils.randomNumeric(8);
    String expectedText = "Sign up successful.";
    String username = "jeff"+id;
    //creation d'une variable
    String password = "Adebayor";
    // creation d'une variable

    @BeforeAll

    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        // met en place le firefoxdriver
        driver = new FirefoxDriver();
        // cree une variable qui sappel driver de type firefoxdriver
        driver.get("https://www.demoblaze.com/index.html");
        // URL sur laquelle  je veux pointer
        driver.manage().window().maximize();
        // ouvrir la page et l'agrandir
    }
    @Test
    @DisplayName("DEM-16")
    @Description("Login CAS PASSANT")

    public void DEM_16() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        //creer un nouvel objet objheaderpage pour lui dire que je veux utiliser firefox driver qui est type headerpage

        objHeaderPage.clickSignUpButton();
        objHeaderPage.setUsernameSignUpPopup(username);
        // variable username
        objHeaderPage.setPasswordSignUpPopup(password);
        // variable password
        objHeaderPage.clickSignupButtonSignupPopup();

        assertTrue(objHeaderPage.verifyAlertText(expectedText,"le message est incorrect "));
    }
        @AfterAll
        public static void tearDown(){driver.quit();}
    // c'est une methode pour quitter la fenetre une fois le test fini
}
