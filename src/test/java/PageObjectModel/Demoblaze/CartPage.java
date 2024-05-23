package PageObjectModel.Demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(xpath = "//img[@src='imgs/galaxy_s6.jpg']")
            private WebElement samsungGalaxyS6Image;
    @FindBy(xpath = "//td[contains(text(), 'Samsung galaxy s6')]")
            private WebElement samsungGalaxyS6Title;
    @FindBy(xpath = "//td[contains(text(), '360')]")
    private WebElement samsungGalaxyS6Price;
    @FindBy(xpath = "//a[contains(@onclick, 'deleteItem')]")
    private WebElement deleteButton;
    @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
    private WebElement placeOrderButton;
    @FindBy(id = "totalp")
    private WebElement totalPrice;

    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isVisibleSamsungGalaxyS6Image(){
        return samsungGalaxyS6Image.isDisplayed();
    }
    public boolean isVisibleSamsungGalaxyS6Title(){
        return samsungGalaxyS6Title.isDisplayed();
    }
    public boolean isVisibleSamsungGalaxyS6Price(){
        return samsungGalaxyS6Price.isDisplayed();
    }
    public boolean isVisibleDeleteButton(){
        return deleteButton.isDisplayed();
    }
    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }
    public String getTotalPrice(){
        totalPrice.getText();
        return totalPrice.getText();
    }
}
