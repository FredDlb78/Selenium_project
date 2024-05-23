package PageObjectModel.Demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationOrderPopup {
    @FindBy(xpath = "//span[@class='sa-line sa-long animateSuccessLong']")
            private WebElement validationPicto;
    @FindBy(xpath = "//h2[contains(text(), 'Thank you for your purchase!')]")
            private WebElement validationMessage;
    @FindBy(xpath = "//p[@class='lead text-muted ']")
            private WebElement orderInformations;

    WebDriver driver;
    public ValidationOrderPopup(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isVisibleValidationPicto(){
        validationPicto.isDisplayed();
        return true;
    }
    public boolean isVisibleValidationMessage(){
        validationMessage.isDisplayed();
        return true;
    }
}
