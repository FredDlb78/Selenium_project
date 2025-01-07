package AutomationProjects.Demoblaze.PageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

public class CartPage extends HeaderPage{
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@id='page-wrapper']//button[@type='button']")
    private WebElement placeOrderButton;
    @FindBy(id = "totalp")
    private WebElement totalPrice;

    public PlaceOrderPopup clickPlaceOrder() throws InterruptedException {
        WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        Thread.sleep(1000); // Pause d'une seconde
        placeOrderBtn.click();
        return new PlaceOrderPopup(driver);
    }

    @Step("Click on delete button")
    public CartPage clickDelete(Integer index) {
        String xpath = String.format("(//a[contains(text(),'Delete')])[%d]", index);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        deleteButton.click();
        return this;
    }

    public CartPage calculateTotalPrice(AtomicReference<Integer> totalRef) {
        int total = 0;
        String xpathTemplate = "//*[@id='tbodyid']/tr[%d]/td[3]";
        int index = 1;

        while (true) {
            try {
                String currentXPath = String.format(xpathTemplate, index);
                WebElement priceElement = driver.findElement(By.xpath(currentXPath));
                total += Integer.parseInt(priceElement.getText().trim());
                index++;
            } catch (NoSuchElementException e) {
                break;
            } catch (NumberFormatException e) {
                System.err.println("Erreur de formatage du prix à l'index : " + index);
                break;
            }
        }

        totalRef.set(total);
        return this;
    }


    public CartPage getTotalPrice(AtomicReference<Integer> intRef) {
        String priceText = wait.until(ExpectedConditions.visibilityOf(totalPrice)).getText().trim();
        try {
            int price = Integer.parseInt(priceText);
            intRef.set(price);
        } catch (NumberFormatException e) {
            System.err.println("Erreur lors de la conversion du prix en entier: " + priceText);
        }
        return this;
    }


}