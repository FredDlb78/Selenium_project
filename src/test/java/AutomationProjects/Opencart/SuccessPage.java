package AutomationProjects.Opencart;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    public SuccessPage(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'contact')]")
    private WebElement contactUs;
    @FindBy(xpath = "//a[contains(text(), 'Continue')]")
    private WebElement continueButton;


    @Step("Click on continue button")
    public AccountPage clickContinue() {
        continueButton.click();
        return new AccountPage(driver);
    }

    @Step("Click on contact us")
    public ContactUsPage clickContactUs() {
        contactUs.click();
        return new ContactUsPage(driver);
    }


}
