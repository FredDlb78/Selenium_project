package AutomationProject.PageObjectModel;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

public class ArticlePage extends HeaderPage {
    private WebDriverWait wait;

    public ArticlePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@onclick='addToCart(1)']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@id='tbodyid']//h2[@class='name']")
    private WebElement articleName;
    @FindBy(xpath = "//div[@id='tbodyid']//h3[@class='price-container']")
    private WebElement articlePrice;
    @FindBy(xpath = "//div[@class='item active']//img[@src='imgs/galaxy_s6.jpg']")
    private WebElement articleImage;
    @FindBy(xpath = "//div[@id='more-information']")
    private WebElement articleDescription;
// Faire les assertions sur ArticlePage

    @Step("Click on Add to cart button")
    public ArticlePage clickAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
        return this;
    }

    @Step("Retrieve article name {0}")
    public ArticlePage retrieveArticleName(AtomicReference<String> strRef) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(articleName));

        String articleNameText = articleName.getText();
        strRef.set(articleNameText);
        return this;
    }

    @Step("Verify alert text popup {0}")
    public ArticlePage acceptAndVerifyAlertText(String expectedAlertText, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            if (!alertText.equals(expectedAlertText)) {
                throw new AssertionError(errorMessage);
            }
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            Assertions.fail("No alert found or error occurred: " + e.getMessage());
        }
        return this;
    }

}
