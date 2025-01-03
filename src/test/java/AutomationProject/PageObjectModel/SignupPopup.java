package AutomationProject.PageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPopup extends DemoblazePage{

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "sign-username")
    private WebElement usernameInput;
    @FindBy(id = "sign-password")
    private WebElement passwordInput;
    @FindBy(css = "button[onclick='register()']")
    private WebElement signUpButton;
    @FindBy(xpath = "//div[@id='signInModal']//div[@class='modal-content']//span[contains(text(), '×')]")
    private WebElement crossButton;
    @FindBy(xpath = "//div[@id='signInModal']//button[contains(text(), 'Close')]")
    private WebElement closeButton;

    public SignupPopup(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Step("Set username {0}")
    public SignupPopup setUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys(username);
        return this;
    }

    @Step("Set password {0}")
    public SignupPopup setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click on Sign up button")
    public SignupPopup clickSignUpButton() {
        signUpButton.click();
        return this;
    }
    @Step("Click on x button")
    public HeaderPage clickXButton() {
        crossButton.click();
        return new HeaderPage();
    }
    @Step("Click on close button")
    public HeaderPage clickCloseButton() {
        closeButton.click();
        return new HeaderPage();
    }

}
