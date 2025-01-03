package AutomationProject.PageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

public class ArticlePage extends HeaderPage{
    private WebDriverWait wait;

    public ArticlePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@id='tbodyid']//h2")
    private WebElement articleName;
    @FindBy(xpath = "//div[@id='tbodyid']//h3[@class='price-container']")
    private WebElement articlePrice;
    @FindBy(xpath = "//div[@id='more-information']")
    private WebElement articleDescription;
    @FindBy(xpath = "//img[@src='imgs/galaxy_s6.jpg']")
    private WebElement articleImage;

    @Step("Check if the image with src contains '{0}' is displayed")
    public ArticlePage checkImageIsDisplayed(String partialSrc) {
        WebElement image = driver.findElement(By.xpath("//img[contains(@src, '" + partialSrc + "')]"));
        if (image.isDisplayed()) {
            System.out.println("L'image avec le src contenant '" + partialSrc + "' est affichée.");
        } else {
            System.out.println("L'image avec le src contenant '" + partialSrc + "' n'est pas affichée.");
        }
        return this;
    }

    @Step("Retrieve article description {0}")
    public ArticlePage retrieveArticleDescription(AtomicReference<String> strRef) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(articleDescription));

        String articleDescriptionText = articleDescription.getText();
        strRef.set(articleDescriptionText);
        return this;
    }
    @Step("Retrieve article price {0}")
    public ArticlePage retrieveArticlePrice(AtomicReference<String> strRef) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(articlePrice));

        String articlePriceText = articlePrice.getText();
        strRef.set(articlePriceText);
        return this;
    }
    @Step("Retrieve article name {0}")
    public ArticlePage retrieveArticleName(AtomicReference<String> strRef) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(articleName));

        String articleNameText = articleName.getText();
        strRef.set(articleNameText);
        return this;
    }

    @Step("Click on Add to cart button")
    public ArticlePage clickAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
        return this;
    }

}
