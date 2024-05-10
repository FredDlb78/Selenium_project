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
public class DEM_13 {
    static FirefoxDriver driver;
    String username = "jeff12345";
    String password = "Adebayor";
    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }
    @Test
    @DisplayName("DEM-13")
    @Description("Login with an existant user")

    public void DEM_13(){
        HeaderPage objHeaderPage = new HeaderPage(driver);

        objHeaderPage.clickLogInButton();
        objHeaderPage.setUsernameLoginPopup(username);
        objHeaderPage.setPasswordLoginPopup(password);
        objHeaderPage.clickLogInButtonLogInPopUp();
        assertTrue(objHeaderPage.welcomeUserButtonContainsText(username));
    }
    @AfterAll
    public static void tearDown(){driver.quit();}
}
