package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    @FindBy(xpath = "//span[@data-test='title']")
            private WebElement title;
    @FindBy(id = "cancel")
    private WebElement cancelButton;
    @FindBy(id = "finish")
    private WebElement finishButton;
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
            private WebElement productName;
    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    private WebElement productPrice;
    //Utilisation du contains dans un xpath
    @FindBy(xpath = "//div[contains(@class, 'summary_total_label')]")
    private WebElement totalPrice;


    WebDriver driver;
    public CheckoutOverviewPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String getProductName(){
        return productName.getText();
    }
    public String getProductPrice(){
        return productPrice.getText();
    }
    public String getTotalPrice(){
        return totalPrice.getText();
    }
    public String getUrlWebPage(){
        return driver.getCurrentUrl();
    }
    public void clickCancel(){
        cancelButton.click();
    }
    public void clickFinish(){
        finishButton.click();
    }
    public String getTitle(){
        return title.getText();
    }

}
