package AutomationProject.PageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

public class HeaderPage {
    protected WebDriver driver;
    private WebDriverWait wait;

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


    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Step("Click on Cart Menu")
    public CartPage clickCartMenu() {
        cartMenu.click();
        return new CartPage(driver);
    }

    @Step("Click on Sign up Menu")
    public SignupPopup clickSignupMenu() {
        signUpMenu.click();
        return new SignupPopup(driver);
    }

    @Step("Click on Log in Menu")
    public LoginPopup clickLoginMenu() {
        loginMenu.click();
        return new LoginPopup(driver);
    }

    @Step("Click on About us Menu")
    public AboutUsPopup clickAboutUsMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(aboutUsMenu));
        aboutUsMenu.click();
        return new AboutUsPopup(driver);
    }

    @Step("Click on Home Menu")
    public HeaderPage clickHomeMenu() {
        homeMenu.click();
        return this;
        // a mettre à jour quand on aura créé la page HomeMenu
    }

    @Step("Retrieve Welcome + name {0} instead of Sign up menu")
    public HeaderPage retrieveWelcomeUsername(AtomicReference<String> strRef) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(welcomeUsername));

        String usernameText = welcomeUsername.getText();
        strRef.set(usernameText);
        return this;
    }

    @Step("Click on Contact Menu")
    public ContactPopup clickContactMenu() {
        contactMenu.click();
        return new ContactPopup(driver);
    }

}
