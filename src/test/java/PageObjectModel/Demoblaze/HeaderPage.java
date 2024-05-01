package PageObjectModel.Demoblaze;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderPage {
    @FindBy(id = "nava")
            private WebElement productStoreButton;
    @FindBy(xpath = "//a[@href='index']")
            private WebElement homeButton;
    @FindBy(xpath = "//a[contains(text(), 'Contact')]")
    private WebElement contactButton;
    @FindBy(xpath = "//a[contains(text(), 'About us')]")
    private WebElement AboutUsButton;
    @FindBy(id = "cartur")
    private WebElement cartButton;
    @FindBy(id = "logout2")
    private WebElement logoutButton;
    @FindBy(id = "login2")
    private WebElement loginButton;
    @FindBy(id = "nameofuser")
    private WebElement welcomeUser;
    @FindBy(id = "signin2")
    private WebElement signUpbutton;
    @FindBy(id = "sign-username")
    private WebElement signUpPopupUsernameInput;
    @FindBy(id = "sign-password")
    private WebElement signUpPopupPasswordInput;
    @FindBy(xpath = "//button[contains(text(), 'Close')]")
    private WebElement signUpPopupCloseButton;
    @FindBy(xpath = "//button[contains(text(), 'Sign up')]")
    private WebElement signUpPopupSignUpButton;
    @FindBy(xpath = "//button[@aria-label=Close]")
    private WebElement signUpPopupCrossButton;
    @FindBy(id = "signInModalLabel")
    private WebElement signupPopupTitle;

    WebDriver driver;
    public HeaderPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void clickProductStoreButton(){
        productStoreButton.click();
    }
    public void clickHomeButton(){
        homeButton.click();
    }
    public void clickContactButton(){
        contactButton.click();
    }
    public void clickSignUpButton(){
        signUpbutton.click();
    }
    public String setUsernameSignUpPopup(String username){
        signUpPopupUsernameInput.click();
        signUpPopupUsernameInput.clear();
        signUpPopupUsernameInput.sendKeys(username);
        return username;
    }
    public String setPasswordSignUpPopup(String password){
        signUpPopupPasswordInput.click();
        signUpPopupPasswordInput.clear();
        signUpPopupPasswordInput.sendKeys(password);
        return password;
    }
    public void clickSignupButtonSignupPopup(){
        signUpPopupSignUpButton.click();
    }
    public Boolean isVisibleSignupButton(){
        if(signUpPopupSignUpButton.isDisplayed()){
            return true;
        }
        return false;
    }
    public void clickSignupPopupCrossButton(){
        signUpPopupCrossButton.click();
    }

    public Boolean isTitleCorrect(String expectedTitle) {
        String actualTitle = signupPopupTitle.getText();
        if (actualTitle.equals(expectedTitle)){
            return true;
        }
        return false;
    }
}
