package AutomationProject.PageObjectModel;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactPopup extends DemoblazePage{
    private WebDriver driver;
    private WebDriverWait wait;

    public ContactPopup(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "exampleModalLabel")
    private WebElement title;
    @FindBy(id = "recipient-email")
    private  WebElement emailInput;
    @FindBy(id = "recipient-name")
    private WebElement nameInput;
    @FindBy(id = "message-text")
    private WebElement messageInput;
    @FindBy(xpath = "//div[@class='modal-content']//button[@onclick='send()']")
    private WebElement sendMessageButton;
    @FindBy(xpath = "//div[@id='exampleModal']//div[@class='modal-content']//span[contains(text(), '×')]")
    private WebElement crossButton;
    @FindBy(xpath = "//div[@id='exampleModal']//button[contains(text(), 'Close')]\n")
    private WebElement closeButton;

    @Step("Assert title {0}")
    public ContactPopup assertTitleEquals(String expectedTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(title));
        assertEquals(expectedTitle, title.getText(), "Wrong title");
        return this;
    }
    @Step("Set contact email")
    public ContactPopup setContactEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }
    @Step("Set contact name {0}")
    public ContactPopup setContactName(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(name);
        return this;
    }
    @Step("Set contact message")
    public ContactPopup setContactMessage(String message) {
        wait.until(ExpectedConditions.visibilityOf(messageInput));
        messageInput.click();
        messageInput.clear();
        messageInput.sendKeys(message);
        return this;
    }
    @Step("Click on Send message button")
    public ContactPopup clickSendMessageButton() {
        sendMessageButton.click();
        return this;
    }
    @Step("Click on x button")
    public HeaderPage clickXButton() {
        crossButton.click();
        return new HeaderPage(driver);
    }
    @Step("Click on close button")
    public HeaderPage clickCloseButton() {
        closeButton.click();
        return new HeaderPage(driver);
    }

}
