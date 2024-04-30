package pageObjectModelDemoblaze;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    @FindBy(id = "cat")
    private WebElement categories;
    @FindBy(xpath = "//a[@id='itemc' and text()='Phones']")
    private WebElement phonesCategorie;
    @FindBy(xpath = "//a[@id='itemc' and text()='Laptops']")
    private WebElement laptopsCategorie;
    @FindBy(xpath = "//a[@id='itemc' and text()='Monitors']")
    private WebElement monitorsCategorie;
    @FindBy(xpath = "//a[contains(text(), 'Samsung galaxy s6')]")
    private WebElement samsungGalaxyS6;
    @FindBy(xpath = "//a[contains(text(), 'lumia')]")
    private WebElement nokiaLumia1520;
    @FindBy(xpath = "//a[contains(text(), 'Nexus 6')]")
    private WebElement nexus6;
    @FindBy(xpath = "//a[contains(text(), 'Samsung galaxy s7')]")
    private WebElement samsungGalaxyS7;
    @FindBy(xpath = "//a[contains(text(), 'Iphone 6 32gb')]")
    private WebElement iphone632gb;
    @FindBy(xpath = "//a[contains(text(), 'Sony xperia z5')]")
    private WebElement sonyXperiaZ5;
    @FindBy(xpath = "//a[contains(text(), 'HTC One M9')]")
    private WebElement htcOneM9;
    @FindBy(xpath = "//a[contains(text(), 'Sony vaio i5')]")
    private WebElement sonyVaioI5;
    @FindBy(xpath = "//a[contains(text(), 'Sony vaio i7')]")
    private WebElement sonyVaioI7;
    @FindBy(id = "prev2")
            private WebElement previousButton;
    @FindBy(id = "next2")
    private WebElement nextButton;


    WebDriver driver;
    public HomePage(WebDriver driver){
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
    public void clickSamsungGalaxyS6(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(samsungGalaxyS6)).click();
    }
    public void clickNokiaLumia1520(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nokiaLumia1520)).click();
    }
    public void clickPreviousButton(){
        previousButton.click();
    }
    public void clickNextButton(){
        nextButton.click();
    }

}
