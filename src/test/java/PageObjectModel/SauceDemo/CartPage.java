package PageObjectModel.SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
            private WebElement articleInCart;
    @FindBy(id = "checkout")
            private WebElement checkoutButton;

    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String getUrlWebPage(){
        return driver.getCurrentUrl();
    }
    public String getArticleInCart(){
        return articleInCart.getText();
    }
    public void clickCheckout(){
        checkoutButton.click();
    }

}
