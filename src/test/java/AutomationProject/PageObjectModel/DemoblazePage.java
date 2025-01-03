package AutomationProject.PageObjectModel;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoblazePage {
    public static WebDriver driver;

    public DemoblazePage(WebDriver driver) {
    }

    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Verify alert text popup {0}")
    public <P> P acceptAndVerifyAlertText(String expectedAlertText, String errorMessage, Class<P> returnType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            if (!alertText.equals(expectedAlertText)) {
                throw new AssertionError(errorMessage);
            }
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            Assertions.fail("No alert found or error occurred: " + e.getMessage());
        }
        return PageFactory.initElements(driver, returnType);
    }
    @Step("Assert Equals {0}")
    public <T, P> P assertEquals(T expectedResult, T actualResult, String errorMessage, Class<P> returnType) {
        try {
            if (!expectedResult.equals(actualResult)) {
                throw new AssertionError(errorMessage);
            }
        } catch (Exception e) {
            Assertions.fail("Wrong result: " + e.getMessage());
        }
        return PageFactory.initElements(driver, returnType);
    }
}