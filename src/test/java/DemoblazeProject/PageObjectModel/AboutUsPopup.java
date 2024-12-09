package DemoblazeProject.PageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutUsPopup {
    private WebDriver driver;
    private WebDriverWait wait;

    public AboutUsPopup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "videoModalLabel")
    private WebElement title;
    @FindBy(xpath = "//div[@id='videoModal']//div[@class='modal-content']//span[contains(text(), '×')]")
    private WebElement crossButton;
    @FindBy(xpath = "//div[@id='videoModal']//button[contains(text(), 'Close')]")
    private WebElement closeButton;
    @FindBy(xpath = "//div[@class='modal-body']//span[contains(text(), 'Video Player is loading.')]")
    private WebElement playVideoButton;

    @Step("Assert title {0}")
    public AboutUsPopup assertTitleEquals(String expectedTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(title));
        assertEquals(expectedTitle, title.getText(), "Wrong title");
        return this;
    }
    @Step("Click on X button")
    public HeaderPage clickXButton() {
        crossButton.click();
        return new HeaderPage(driver);
    }
    @Step("Click on close button")
    public HeaderPage clickCloseButton() {
        closeButton.click();
        return new HeaderPage(driver);
    }
    @Step("Click on close button")
    public AboutUsPopup clickPlayVideoButton() {
        playVideoButton.click();
        return this;
    }

}
