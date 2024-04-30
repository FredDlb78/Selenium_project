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
    @FindBy( )
    private WebElement samsungGalaxy6;
    @FindBy( )
    private WebElement nokiaLumia1520;
    @FindBy( )
    private WebElement nexus6;
    @FindBy( )
    private WebElement samsungGalaxyS7;
    @FindBy( )
    private WebElement iphone632gb;
    @FindBy( )
    private WebElement sonyXperiaZ5;
    @FindBy( )
    private WebElement htcOneM9;
    @FindBy( )
    private WebElement sonyVaioI5;
    @FindBy( )
    private WebElement sonyVaioI7;
    @FindBy(id = "prev2")
            private WebElement previousButton;
    @FindBy(id = "next2")
    private WebElement nextButton;


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
    public void clickSamsungGalaxys6(){
        samsungGalaxy6.click();
    }
    public void clickNokiaLumia1520(){
        nokiaLumia1520.click();
    }
    public void clickPreviousButton(){
        previousButton.click();
    }
    public void clickNextButton(){
        nextButton.click();
    }

}
