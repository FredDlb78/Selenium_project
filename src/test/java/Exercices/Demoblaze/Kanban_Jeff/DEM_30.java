package Exercices.Demoblaze.Kanban_Jeff;

import PageObjectModel.Demoblaze.HeaderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

public class DEM_30 {
    static FirefoxDriver driver;
    String username = "jeffafanou@gmail.com";
    String password = "jeff12345678910";
    String alertText = "User does not exist.";

        @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }
    @Test
    @DisplayName("DEM-30")
    @Description("Login with an inexistant user")

    public void DEM_30(){
            HeaderPage objHeaderPage = new HeaderPage(driver);

       objHeaderPage.clickLogInButton();
       objHeaderPage.setUsernameLoginPopup(username);
       objHeaderPage.setPasswordLoginPopup(password);
       objHeaderPage.clickLogInButtonLogInPopUp();
       assertTrue(objHeaderPage.verifyAlertText(alertText,"Alert text is not right"));
    }
    @AfterAll
    public static void tearDown(){driver.quit();}
}