package AutomationProjects.Demoblaze.PageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchaseConfirmationPopup {
    private WebDriver driver;
    private WebDriverWait wait;

    public PurchaseConfirmationPopup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        }

    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    private WebElement okButton;

    @Step("Click on Purchase")
    public HomePage clickOk() {
        okButton.click();
        return new HomePage(driver);
    }

}
