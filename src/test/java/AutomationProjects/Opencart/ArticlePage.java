package AutomationProjects.Opencart;

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

public class ArticlePage extends OpencartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ArticlePage(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Step("Retrieve article name for: {0}")
    public ArticlePage getArticleName(String articleName, AtomicReference<String> strRef) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = String.format("//h1[contains(text(), '%s')]", articleName);
        WebElement article = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String retrievedArticleName = article.getText();
        strRef.set(retrievedArticleName);
        return this;
    }
    @Step("Retrieve article name for: {0}")
    public ArticlePage getArticlePrice(AtomicReference<String> strRef) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = String.format("//li//h2");
        WebElement article = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String retrievedArticlePrice = article.getText();
        strRef.set(retrievedArticlePrice);
        return this;
    }




}
