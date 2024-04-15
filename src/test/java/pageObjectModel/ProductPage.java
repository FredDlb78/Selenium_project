package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.html.CSS;

public class ProductPage {
    //Page Factory

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
            private WebElement filterButton;
    @FindBy(xpath = "//option[@value='lohi']")
            private WebElement filterLoHi;

        WebDriver driver;
        //Constructeur
        public ProductPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }


        //Page Object
        public String getProductPageUrl(){
            return  driver.getCurrentUrl();
        }
        public void setFilterLoHi(){
            filterButton.click();
            filterLoHi.click();
        }
    }
