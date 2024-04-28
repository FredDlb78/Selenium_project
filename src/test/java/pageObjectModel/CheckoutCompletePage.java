package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    //Utilisation du FindBy tagName
    @FindBy(tagName = "h2")
            private WebElement titlePage;
    @FindBy(xpath = "//h2[@data-test='complete-header']")
            private WebElement validationOrderMessage;
    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    WebDriver driver;
    public CheckoutCompletePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String getUrlWebPage(){
        return driver.getCurrentUrl();
    }
    public String getTitlePage(){
        return titlePage.getText();
    }
    public String getValidationOrderMessage(){
        return validationOrderMessage.getText();
    }
    public void clickBackHome(){
        backHomeButton.click();
    }
}
