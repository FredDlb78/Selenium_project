package PageObjectModel.Demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPopupPage {
    @FindBy(id = "name")
            private WebElement nameInput;
    @FindBy(id = "country")
    private WebElement countryInput;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "card")
    private WebElement cardInput;
    @FindBy(id = "month")
    private WebElement monthInput;
    @FindBy(id = "year")
    private WebElement yearInput;
    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    private WebElement purchaseButton;
    @FindBy(id = "orderModalLabel")
            private WebElement popupTitle;


    WebDriver driver;
    public PlaceOrderPopupPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isTitlePopup() {
        String actualTitle = popupTitle.getText();
        return actualTitle.equals("PlaceOrder");
    }
    public void setName(String name){
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(name);
    }
    public void setCountry(String country){
        countryInput.click();
        countryInput.clear();
        countryInput.sendKeys(country);
    }
    public void setCity(String city){
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setCardNumbers(String cardNumbers){
        cardInput.click();
        cardInput.clear();
        cardInput.sendKeys(cardNumbers);
    }
    public void setMonth(String month){
        monthInput.click();
        monthInput.clear();
        monthInput.sendKeys(month);
    }
    public void setYear(String year){
        yearInput.click();
        yearInput.clear();
        yearInput.sendKeys(year);
    }
    public void clickPurchaseButton(){
        purchaseButton.click();
    }
}
