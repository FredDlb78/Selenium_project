package pageObjectModelSauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;
    WebDriver driver;
    public HeaderPage(WebDriver driver){
                this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public Boolean isArticleAddedInCart(){
        if (shoppingCart.getText().equals("1"))
            return true;
        else return false;
    }
    public void clickOnCart(){
        shoppingCart.click();
    }
}
