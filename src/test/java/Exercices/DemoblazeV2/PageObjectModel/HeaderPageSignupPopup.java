package Exercices.DemoblazeV2.PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPageSignupPopup {
    @FindBy(id = "sign-username")
    private WebElement usernameInput;
    @FindBy(id = "sign-password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(), 'Sign up')]")
    private WebElement signUpButton;
    @FindBy(id = "signInModalLabel")
    private WebElement title;
    public HeaderPageSignupPopup setUsername(String username){
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys(username);
        return this;
    }
    public HeaderPageSignupPopup setPassword(String password){
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }
    public HeaderPageSignupPopup clickSignup(){
        signUpButton.click();
        return this;
    }
    public HeaderPageSignupPopup isVisibleSignupButton() {
        if (signUpButton.isDisplayed()) {
            return this;
        }
        throw new RuntimeException("Sign up button is not visible");
    }
    public HeaderPageSignupPopup isTitleCorrect(String expectedTitle) {
        String actualTitle = title.getText();
        if (actualTitle.equals(expectedTitle)){
            return this;
        }
        throw new RuntimeException("Title is not correct");
    }
}
