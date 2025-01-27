package AutomationProjects.Opencart;

import AutomationProjects.Demoblaze.PageObjectModel.ContactPopup;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static AutomationProjects.Opencart.OpencartPage.driver;

public class HomePage extends OpencartPage{
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title=\"My Account\"]")
    private WebElement myAccountButton;
    @FindBy(xpath = "//a[contains(text(), 'Register')]")
    private WebElement registerButton;
    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    private WebElement loginButton;

    @Step("Click on My Account")
    public HomePage clickOnMyAccount() {
        wait.until(ExpectedConditions.visibilityOf(myAccountButton));
        myAccountButton.click();
        return this;
    }

    @Step("Click on Register")
    public RegisterPage clickOnRegister() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
        return new RegisterPage(driver);
    }
    @Step("Click on Login")
    public LoginPage clickOnLogin() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
        return new LoginPage(driver);
    }

    public AccountPage signinPassingCases(String firstName, String lastName, String email, String phone, String password) {

        HomePage homePage = new HomePage(driver);

        homePage.clickOnMyAccount()
                .clickOnRegister()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhone(phone)
                .setPassword(password)
                .setPasswordConfirmation(password)
                .selectRadioNewsletter("Yes")
                .checkPrivacyPolicy()
                .clickContinue()
                .clickContinue();
        return new AccountPage(driver);

    }
}
