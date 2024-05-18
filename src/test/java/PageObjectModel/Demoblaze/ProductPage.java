package PageObjectModel.Demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    @FindBy(xpath = "//a[@onclick='addToCart(1)']")
    private WebElement addToCartButton;

    WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }
}
