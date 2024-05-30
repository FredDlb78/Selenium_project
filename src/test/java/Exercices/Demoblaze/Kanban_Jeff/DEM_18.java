package Exercices.Demoblaze.Kanban_Jeff;

import PageObjectModel.Demoblaze.HeaderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DEM_18 {
    static FirefoxDriver driver;
    String contactEmail = "jeffafanougmail.com";
    String contactName = "jeff";
    String contactMessage = "test1";
    String expectedAlertText = "Email Invalide";
    String errorMessage = "Alert message is not correct";
    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }
    @Test
    @DisplayName("DEM-18")
    @Description("Fill in the contact form")

    public void DEM_18(){

        HeaderPage objHeaderPage = new HeaderPage(driver);

        objHeaderPage.clickContactButton();
        objHeaderPage.setContactEmailContactPopup(contactEmail);
        objHeaderPage.setContactNameContactPopup(contactName);
        objHeaderPage.setMessageContactPopup(contactMessage);
        objHeaderPage.clickSendMessageButton();
        objHeaderPage.verifyAlertText(expectedAlertText, errorMessage);
    }
    @AfterAll
    public static void tearDown(){driver.quit();}
}
