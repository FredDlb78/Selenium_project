package AutomationProjects.Demoblazev2.cucumber.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoblazePageCucumber {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void acceptAndVerifyAlertText(String expectedAlertText, String errorMessage) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            Assertions.assertEquals(expectedAlertText, alertText, errorMessage);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            Assertions.fail("No alert found or error occurred: " + e.getMessage());
        }
    }

    public void assertEquals(String expectedResult, String actualResult, String errorMessage) {
        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }
}