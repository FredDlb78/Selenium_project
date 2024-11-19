package DemoblazeProject.PageObjectModel;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPopup {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "sign-username")
    private WebElement usernameInput;

    @FindBy(id = "sign-password")
    private WebElement passwordInput;

    @FindBy(css = "button[onclick='register()']")
    private WebElement signUpButton;

    public SignupPopup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public SignupPopup setUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys(username);
        return this;
    }

    public SignupPopup setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public SignupPopup clickSignUpButton() {
        signUpButton.click();
        return this;
    }
    public HeaderPage verifyAlertTextAfterSuccess(String expectedAlertText, String errorMessage) {
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
        return new HeaderPage(driver);
    }
    public SignupPopup verifyAlertTextAfterFailed(String expectedAlertText, String errorMessage) {
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
        return this;
    }

}
