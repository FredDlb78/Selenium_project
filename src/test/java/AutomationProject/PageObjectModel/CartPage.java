package AutomationProject.PageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='page-wrapper']//button[@type='button']")
    private WebElement placeOrderButton;

    public PlaceOrderPopup clickPlaceOrder() {
        placeOrderButton.click();
        return new PlaceOrderPopup(driver);
    }
    @Step("Click on delete button")
    public CartPage clickDelete(Integer index) {
        String xpath = String.format("(//a[contains(text(),'Delete')])[%d]", index);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        deleteButton.click();
        return this;
    }

}