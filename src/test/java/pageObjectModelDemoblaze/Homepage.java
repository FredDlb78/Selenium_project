package pageObjectModelDemoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    @FindBy(id = "cat")
    private WebElement categories;
    @FindBy(xpath = "//a[@id='itemc' and text()='Phones']")
    private WebElement phonesCategorie;
    @FindBy(xpath = "//a[@id='itemc' and text()='Laptops']")
    private WebElement laptopsCategorie;
    @FindBy(xpath = "//a[@id='itemc' and text()='Monitors']")
    private WebElement monitorsCategorie;

    WebDriver driver;
    public Homepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCategories(){
        categories.click();
    }
    public void clickPhonesCategory(){
        phonesCategorie.click();
    }
    public void clickLaptopsCategory(){
        laptopsCategorie.click();
    }
    public void clickMonitorsCategory(){
        monitorsCategorie.click();
    }

}
