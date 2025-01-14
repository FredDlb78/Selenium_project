package AutomationProjects.Opencart;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.atomic.AtomicReference;

public class OpencartPage {
    public static WebDriver driver;
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
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

    @Step("Assert Contains: Expected '{0}' in Actual '{1}'")
    public <T, P> P assertContains(T expectedResult, T actualResult, String errorMessage, Class<P> returnType) {
        try {
            if (!actualResult.toString().contains(expectedResult.toString())) {
                throw new AssertionError(errorMessage +
                        " | Expected: '" + expectedResult + "' but Actual: '" + actualResult + "'");
            }
        } catch (Exception e) {
            Assertions.fail("Assertion failed: " + e.getMessage());
        }
        return PageFactory.initElements(driver, returnType);
    }


}
