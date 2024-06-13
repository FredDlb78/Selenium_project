package Exercices.Demoblaze.Kanban_Jeff;

import PageObjectModel.Demoblaze.HeaderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DEM_22 {
    static FirefoxDriver driver;
    String password = "Adebayor";
    String alertText = "Please fill out Username and Password.";

        @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }
    @Test
    @DisplayName("DEM-22")
    @Description("not username")

    public void DEM_22(){
            HeaderPage objHeaderPage = new HeaderPage(driver);

       objHeaderPage.clickLogInButton();
       objHeaderPage.setPasswordLoginPopup(password);
       objHeaderPage.clickLogInButtonLogInPopUp();
       assertTrue(objHeaderPage.verifyAlertText(alertText,"Alerte text is not right"));


    }
    @AfterAll
    public static void tearDown(){driver.quit();}
}