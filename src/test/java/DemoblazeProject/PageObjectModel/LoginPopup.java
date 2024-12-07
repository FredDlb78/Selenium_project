package DemoblazeProject.PageObjectModel;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPopup {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "loginusername")
    private WebElement usernameInput;
    @FindBy(id = "loginpassword")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[@class='modal-footer']//button[@onclick='logIn()']")
    private WebElement loginButton;

    public LoginPopup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Step("Set username {0}")
    public LoginPopup setUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys(username);
        return this;
    }

    @Step("Set password {0}")
    public LoginPopup setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click on Login button")
    public HeaderPage clickLoginButton() {
        loginButton.click();
        return new HeaderPage(driver);
    }

    @Step("Click on Login button")
    public LoginPopup clickLoginButtonThenFailed() {
        loginButton.click();
        return this;
    }

    @Step("Verify alert text popup {0}")
    public LoginPopup verifyAlertTextThenFailed(String expectedAlertText, String errorMessage) {
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
