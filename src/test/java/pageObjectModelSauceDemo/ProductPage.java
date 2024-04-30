package pageObjectModelSauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductPage {
    //Page Factory

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    private WebElement filterButton;
    @FindBy(xpath = "//option[@value='lohi']")
    private WebElement filterLoHi;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> listPrice;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCartBikeLight;
    @FindBy(id = "remove-sauce-labs-bike-light")
            private WebElement removeToCartBikeLight;

    WebDriver driver;

    //Constructeur
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Page Object
    public String getProductPageUrl() {
        return driver.getCurrentUrl();
    }

    public void setFilterLoHi() {
        filterButton.click();
        filterLoHi.click();
    }

    public Boolean isListInOrder() {
        //Liste String vide où on va récupérer tous les éléments de notre liste de WebElements
        List<String> list = new ArrayList<>();
        //Créer une boucle FOR, permet de lire chaque élément de ListPrice pour les ajouter dans list
        for (WebElement orderList : listPrice) {
            list.add(orderList.getText().replaceAll("[^\\d]", ""));
        }
        Iterator<String> iterator = list.iterator();
        // Convertir le premier élément d'un itérateur en un entier (int)
        int current, previous = Integer.parseInt(iterator.next());
        while (iterator.hasNext()) {
            current = Integer.parseInt((iterator.next()));
            if (previous > current) {
                return false;
            }
            previous = current;
        }
        ;
        return true;
    }
    public void clickAddToCartBikeLight() {
        addToCartBikeLight.click();
    }
    public boolean isVisibleRemoveToCartBikeLight(){
        return removeToCartBikeLight.isDisplayed();
    }
    public boolean isVisibleAddToCartBikeLight(){
        return addToCartBikeLight.isDisplayed();
    }

}
