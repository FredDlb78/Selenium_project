package pageObjectModelDemoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    @FindBy(id = "nava")
            private WebElement productStoreButton;
    @FindBy(xpath = "//a[@href='index']")
            private WebElement homeButton;
    @FindBy(xpath = "//a[contains(text(), 'Contact')]")
    private WebElement contactButton;

    WebDriver driver;
    public HeaderPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void clickProductStoreButton(){
        productStoreButton.click();
    }
    public void clickHomeButton(){
        homeButton.click();
    }
    public void clickContactButton(){
        contactButton.click();
    }
}
