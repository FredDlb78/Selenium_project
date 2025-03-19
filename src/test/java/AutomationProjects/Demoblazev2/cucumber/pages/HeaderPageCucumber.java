package AutomationProjects.Demoblazev2.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPageCucumber extends DemoblazePageCucumber {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "signin2")
    private WebElement signUpMenu;
    @FindBy(id = "login2")
    private WebElement loginMenu;
    @FindBy(xpath = "//ul//a[@href='index.html']")
    private WebElement homeMenu;
    @FindBy(id = "nameofuser")
    private WebElement welcomeUsername;
    @FindBy(xpath = "//div[@id='navbarExample']//a[contains(text(), 'Contact')]")
    private WebElement contactMenu;
    @FindBy(xpath = "//div[@id='navbarExample']//a[contains(text(), 'About us')]")
    private WebElement aboutUsMenu;
    @FindBy(id = "cartur")
    private WebElement cartMenu;

    public HeaderPageCucumber(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickSignupMenu() {
        waitUntilElementClickable(signUpMenu).click();
    }

    public void clickLoginMenu() {
        waitUntilElementClickable(loginMenu).click();
    }

    public void clickHomeMenu() {
        waitUntilElementClickable(homeMenu).click();
    }

    public String getWelcomeUsername() {
        return waitUntilElementVisible(welcomeUsername).getText();
    }

    public void clickContactMenu() {
        waitUntilElementClickable(contactMenu).click();
    }

    public void clickAboutUsMenu() {
        waitUntilElementClickable(aboutUsMenu).click();
    }

    public void clickCartMenu() {
        waitUntilElementClickable(cartMenu).click();
    }

    private WebElement waitUntilElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private WebElement waitUntilElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}