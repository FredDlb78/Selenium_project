package Exercices.DemoblazeV2.Tests;


import Exercices.DemoblazeV2.PageObjectModel.HeaderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Signup {
    static FirefoxDriver driver;
    String id = RandomStringUtils.randomNumeric(8);
    String username = "Fred" + id;
    String password = "Test@1234";
    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }
    @Test
    @DisplayName("Signup")
    @Description("Signup")

    public void DEM_13() {
        HeaderPage objHeaderPage = new HeaderPage(driver);

        objHeaderPage.clickSignUpButton()
                .isTitleCorrect("Sign up")
                .setUsername(username)
                .setPassword(password)
                        .clickSignup();
    }
    @AfterAll
    public static void tearDown(){driver.quit();}
}