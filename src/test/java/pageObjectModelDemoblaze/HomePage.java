package pageObjectModelDemoblaze;

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
    @FindBy(xpath = "//a[contains(text(), 'Apple monitor 24')]")
    private WebElement appleMonitor24;
    @FindBy(xpath = "//a[contains(text(), 'MacBook air')]")
    private WebElement macBookAir;
    @FindBy(xpath = "//a[contains(text(), 'Dell i7 8gb')]")
    private WebElement dellI78gb;
    @FindBy(xpath = "//a[contains(text(), '2017 Dell 15.6 Inch')]")
    private WebElement dell2017_156Inch;
    @FindBy(xpath = "//a[contains(text(), 'ASUS Full HD')]")
    private WebElement asusFullHD;
    @FindBy(xpath = "//a[contains(text(), 'MacBook Pro')]")
    private WebElement macBookPro;
    @FindBy(id = "prev2")
            private WebElement previousButton;
    @FindBy(id = "next2")
    private WebElement nextButton;


    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean getCurrentUrlWeb(){
        return driver.getCurrentUrl().equals("https://www.demoblaze.com/index.html");
    }

    public void clickCategories(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(categories)).click();
    }
    public void clickPhonesCategory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(phonesCategorie)).click();
    }
    public void clickLaptopsCategory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(laptopsCategorie)).click();
    }
    public void clickMonitorsCategory(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(monitorsCategorie)).click();
    }
    public void clickSamsungGalaxyS6(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(samsungGalaxyS6)).click();
    }
    public void clickNokiaLumia1520(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nokiaLumia1520)).click();
    }
    public void clickNexus6(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nexus6)).click();
    }
    public void clickSamsungGalaxyS7(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(samsungGalaxyS7)).click();
    }
    public void clickIPhone632gb(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(iphone632gb)).click();
    }
    public void clickSonyXperiaZ5(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sonyXperiaZ5)).click();
    }
    public void clickHtcOneM9(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(htcOneM9)).click();
    }
    public void clickSonyVaioI5(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sonyVaioI5)).click();
    }
    public void clickSonyVaioI7(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sonyVaioI7)).click();
    }
    public void clickAppleMonitor24(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nokiaLumia1520)).click();
    }
    public void clickMacBookAir(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nokiaLumia1520)).click();
    }
    public void clickDellI78gb(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nokiaLumia1520)).click();
    }
    public void click2017Dell156Inch(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nokiaLumia1520)).click();
    }
    public void clickAsusFullHD(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nokiaLumia1520)).click();
    }
    public void clickMacBookrPro(){
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
