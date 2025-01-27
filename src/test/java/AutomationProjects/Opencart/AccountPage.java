package AutomationProjects.Opencart;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    public AccountPage(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='list-group']//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    @Step("Click on Login")
    public HomePage clickOnLogout() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
        return new HomePage(driver);
    }
}
