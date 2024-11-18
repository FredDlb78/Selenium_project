package DemoblazeProject.PageObjectModel;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "signin2")
    private WebElement signUpMenu;
    @FindBy(xpath = "//ul//a[@href='index.html']")
    private WebElement homeMenu;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public SignUpPopup clickSignUpMenu() {
        signUpMenu.click();
        return new SignUpPopup(driver);
    }
    public HeaderPage clickHomeMenu() {
        signUpMenu.click();
        return this;
    }
}
