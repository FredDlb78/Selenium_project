package Exercices.Demoblaze.Kanban_Jeff;

import PageObjectModel.Demoblaze.HeaderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class DEM_24 {
    static FirefoxDriver driver;
    String contactEmail = "";
    String contactName = "jeff";
    String contactMessage = "test12345678910";
    String contactAlertText = "renseigner votre email";
    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }
    @Test
    @DisplayName("DEM-24")
    @Description("Fill in the contact form without email")

    public void DEM_24(){
        HeaderPage objHeaderPage = new HeaderPage(driver);

        objHeaderPage.clickContactButton();
        Assertions.assertTrue(objHeaderPage.isCorrectContactPopupTitle(), "Wrong message");
        objHeaderPage.setContactEmailContactPopup(contactEmail);
        objHeaderPage.setContactNameContactPopup(contactName);
        objHeaderPage.setMessageContactPopup(contactMessage);
        objHeaderPage.clickSendMessageButton();
        objHeaderPage.verifyAlertText(contactAlertText, "Wrong alert message");

    }
    @AfterAll
    public static void tearDown(){driver.quit();}
}
