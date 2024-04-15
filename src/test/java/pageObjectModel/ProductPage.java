package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.html.CSS;
import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    //Page Factory

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
            private WebElement filterButton;
    @FindBy(xpath = "//option[@value='lohi']")
            private WebElement filterLoHi;
    @FindBy(xpath ="//div[@class='inventory_item_price'")
            private List<WebElement> listPrice;

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
        public Boolean isListInOrder(){
            //Liste String vide où on va récupérer tous les éléments de notre liste de WebElements
            List<String> list = new ArrayList<>();
            //Créer une boucle FOR, permet de lire chaque élément de ListPrice pour les ajouter dans list
            for(WebElement orderList: listPrice){
                list.add(orderList.getText().replaceAll("[^\\d]",""));
            }
            return false;

        }
    }
