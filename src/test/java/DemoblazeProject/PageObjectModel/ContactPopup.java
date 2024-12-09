package DemoblazeProject.PageObjectModel;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPopup {
    private WebDriver driver;
    private WebDriverWait wait;

    public ContactPopup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "exampleModalLabel")
    private WebElement title;
    @FindBy(xpath = "//div[@class='modal-content']//button[@onclick='send()'])")
    private WebElement xButton;
    @FindBy(id = "recipient-email")
    private  WebElement emailInput;
    @FindBy(id = "recipient-name")
    private WebElement nameInput;
    @FindBy(id = "message-text")
    private WebElement messageInput;
    @FindBy(xpath = "//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]")
    private WebElement closeButton;
    @FindBy(xpath = "//div[@class=\"modal-content\"]//button[@onclick=\"send()\"]")
    private WebElement sendMessageButton;

    public String email = "James@gmail.com";
    public String name = "James";
    public String message = "Hello Moto";


    @Step("Title Verification")
    public ContactPopup checkTitleMenu() {
        title.getText();
        return this;
    }
    @Step("Click on X button")
    public HeaderPage clickXButton() {
        xButton.click();
        return new HeaderPage(driver);
    }
    @Step("Set contact email")
    public ContactPopup setContactEmail() {
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }
    @Step("Set contact name")
    public ContactPopup setContactName() {
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(name);
        return this;
    }
    @Step("Set contact message")
    public ContactPopup setContactMessage() {
        messageInput.click();
        messageInput.clear();
        messageInput.sendKeys(message);
        return this;
    }
    @Step("Click on Close button")
    public HeaderPage clickCloseButton() {
        closeButton.click();
        return new HeaderPage(driver);
    }
    @Step("Click on Send message button")
    public HeaderPage clickSendMessageButton() {
        sendMessageButton.click();
        return new HeaderPage(driver);
    }

}
