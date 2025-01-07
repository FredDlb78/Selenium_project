package AutomationProjects.Opencart;

import AutomationProjects.Demoblaze.PageObjectModel.ArticlePage;
import AutomationProjects.Demoblaze.PageObjectModel.ContactPopup;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static AutomationProjects.Opencart.OpencartPage.driver;

public class RegisterPage {
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        super();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "input-email")
    private WebElement emailInput;
    @FindBy(id = "input-telephone")
    private WebElement phoneInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmationInput;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continueButton;
    @FindBy(xpath = "//input[@name=\"agree\"]")
    private WebElement privacyPolicyButton;

    public RegisterPage selectRadioNewsletter(String radioButton) {
        String xpath = String.format("//input[@name=\"newsletter\" and @type=\"radio\" and " +
                "following-sibling::text()[contains(., \"%s\")]]", radioButton);
        WebElement radio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        radio.click();
        return this;
    }

    @Step("Set first name")
    public RegisterPage setFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @Step("Set last name")
    public RegisterPage setLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @Step("Set email")
    public RegisterPage setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Set email")
    public RegisterPage setPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        return this;
    }

    @Step("Set password")
    public RegisterPage setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Set password confirmation")
    public RegisterPage setPasswordConfirmation(String passwordConfirmation) {
        wait.until(ExpectedConditions.visibilityOf(passwordConfirmationInput));
        passwordConfirmationInput.click();
        passwordConfirmationInput.clear();
        passwordConfirmationInput.sendKeys(passwordConfirmation);
        return this;
    }

    @Step("Click on continue button")
    public SuccessPage clickContinue() {
        continueButton.click();
        return new SuccessPage(driver);
    }

    @Step("Check privacy policy")
    public RegisterPage checkPrivacyPolicy() {
        privacyPolicyButton.click();
        return this;
    }


}
