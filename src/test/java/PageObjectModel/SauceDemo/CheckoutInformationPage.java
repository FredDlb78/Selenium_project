package PageObjectModel.SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {
    @FindBy(id = "first-name")
            private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(id = "cancel")
    private WebElement cancelButton;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(xpath = "//span[@data-test='title']")

    WebDriver driver;
    public CheckoutInformationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String getUrlWebPage(){
        return driver.getCurrentUrl();
    }
    public void setFirstName(){
        firstNameInput.click();
        firstNameInput.sendKeys("Marco");
    }
    public void setLastName(){
        lastNameInput.click();
        lastNameInput.sendKeys("Verratti");
    }
    public void setPostalCode(){
        postalCodeInput.click();
        postalCodeInput.sendKeys("78300");
    }
    public void clickContinue(){
        continueButton.click();
    }
    public void cancelContinue(){
        cancelButton.click();
    }
    public String getPageName(){
        return driver.getTitle();
    }
}
