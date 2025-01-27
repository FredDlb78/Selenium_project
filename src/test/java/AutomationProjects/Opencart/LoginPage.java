package AutomationProjects.Opencart;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

import static AutomationProjects.Opencart.OpencartPage.driver;

public class LoginPage extends OpencartPage{
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="input-email")
    private WebElement inputEmail;
    @FindBy(id="input-password")
    private WebElement inputpassword;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement clickOnLogin;
    @FindBy(xpath = "//div[contains(text(), 'Warning: No match for E-Mail Address and/or Password.')]")
    private WebElement errorMessageNoMatch;

    @Step("Set email")
    public LoginPage setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);
        return this;
    }
    @Step("Set password")
    public LoginPage setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(inputpassword));
        inputpassword.click();
        inputpassword.clear();
        inputpassword.sendKeys(password);
        return this;
    }
    @Step("Click on Login")
    public AccountPage clickOnLogin() {
        wait.until(ExpectedConditions.visibilityOf(clickOnLogin));
        clickOnLogin.click();
        return new AccountPage(driver);
    }
    @Step("Click on Login")
    public LoginPage clickOnLoginThenFailed() {
        wait.until(ExpectedConditions.visibilityOf(clickOnLogin));
        clickOnLogin.click();
        return this;
    }
    @Step("Retrieve no match error message")
    public LoginPage retrieveNoMatchErrorMessage(AtomicReference<String> strRef) {
        String error = errorMessageNoMatch.getText();
        strRef.set(error);
        return this;
    }

}
