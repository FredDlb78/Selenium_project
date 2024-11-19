package DemoblazeProject.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "signin2")
    private WebElement signUpMenu;
    @FindBy(id = "login2")
    private WebElement loginMenu;
    @FindBy(xpath = "//ul//a[@href='index.html']")
    private WebElement homeMenu;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public SignupPopup clickSignupMenu() {
        signUpMenu.click();
        return new SignupPopup(driver);
    }
    public LoginPopup clickLoginMenu() {
        loginMenu.click();
        return new LoginPopup(driver);
    }
    public HeaderPage clickHomeMenu() {
        homeMenu.click();
        return this;
    }
}
