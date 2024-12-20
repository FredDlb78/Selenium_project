package AutomationProject.PageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderPopup {
    private WebDriver driver;
    private WebDriverWait wait;

    public PlaceOrderPopup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    private WebElement nameInput;
    @FindBy(id = "country")
    private WebElement countryInput;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "card")
    private WebElement creditCardInput;
    @FindBy(id = "month")
    private WebElement monthInput;
    @FindBy(id = "year")
    private WebElement yearInput;
    @FindBy(xpath = "//*[@id=\"orderModal\"]//button[@onclick='purchaseOrder()']")
    private WebElement purchaseButton;
    @FindBy(xpath = "//*[@id=\"orderModal\"]//button[contains(text(), 'Close')]")
    private WebElement closeButton;

    @Step("Click on Purchase")
    public PurchaseConfirmationPopup clickPurchase() {
        purchaseButton.click();
        return new PurchaseConfirmationPopup(driver);
    }
    @Step("Click on Close")
    public ContactPopup clickClose() {
        closeButton.click();
        return new ContactPopup(driver);
    }
    @Step("Set name {0}")
    public PlaceOrderPopup setName(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(name);
        return this;
    }
    @Step("Set country {0}")
    public PlaceOrderPopup setCountry(String country) {
        wait.until(ExpectedConditions.visibilityOf(countryInput));
        countryInput.click();
        countryInput.clear();
        countryInput.sendKeys(country);
        return this;
    }
    @Step("Set city {0}")
    public PlaceOrderPopup setCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(cityInput));
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
        return this;
    }
    @Step("Set credit card {0}")
    public PlaceOrderPopup setCard(String card) {
        wait.until(ExpectedConditions.visibilityOf(creditCardInput));
        creditCardInput.click();
        creditCardInput.clear();
        creditCardInput.sendKeys(card);
        return this;
    }
    @Step("Set month {0}")
    public PlaceOrderPopup setMonth(String month) {
        wait.until(ExpectedConditions.visibilityOf(monthInput));
        monthInput.click();
        monthInput.clear();
        monthInput.sendKeys(month);
        return this;
    }
    @Step("Set year {0}")
    public PlaceOrderPopup setYear(String year) {
        wait.until(ExpectedConditions.visibilityOf(yearInput));
        yearInput.click();
        yearInput.clear();
        yearInput.sendKeys(year);
        return this;
    }


}
