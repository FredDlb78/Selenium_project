package AutomationProject.PageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPopup extends DemoblazePage{

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "loginusername")
    private WebElement usernameInput;
    @FindBy(id = "loginpassword")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[@class='modal-footer']//button[@onclick='logIn()']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@id='logInModal']//div[@class='modal-content']//span[contains(text(), '×')]")
    private WebElement crossButton;
    @FindBy(xpath = "//div[@id='logInModal']//button[contains(text(), 'Close')]")
    private WebElement closeButton;

    public LoginPopup(WebDriver driver) {
        super(driver);
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
    @Step("Click on x button")
    public HeaderPage clickXButton() {
        crossButton.click();
        return new HeaderPage(driver);
    }
    @Step("Click on close button")
    public HeaderPage clickCloseButton() {
        closeButton.click();
        return new HeaderPage(driver);
    }

}
