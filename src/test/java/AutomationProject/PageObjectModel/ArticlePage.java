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

public class ArticlePage extends DemoblazePage{
    private WebDriverWait wait;

    public ArticlePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@onclick='addToCart(1)']")
    private WebElement addToCartButton;

    @Step("Click on Add to cart button")
    public ArticlePage clickAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
        return this;
    }

}
