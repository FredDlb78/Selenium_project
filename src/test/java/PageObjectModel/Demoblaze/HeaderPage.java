package PageObjectModel.Demoblaze;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {
    @FindBy(id = "nava")
            private WebElement productStoreButton;
    @FindBy(xpath = "//a[@href='index']")
            private WebElement homeButton;
    @FindBy(xpath = "//a[contains(text(), 'Contact')]")
    private WebElement contactButton;
    @FindBy(xpath = "//a[contains(text(), 'About us')]")
    private WebElement aboutUsButton;
    @FindBy(id = "cartur")
    private WebElement cartButton;
    @FindBy(id = "logout2")
    private WebElement logoutButton;
    @FindBy(id = "login2")
    private WebElement loginButton;
    @FindBy(id = "loginusername")
    private WebElement loginPopupUsernameInput;
    @FindBy(id = "loginpassword")
    private WebElement loginPopupPasswordInput;
    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    private WebElement logInPopupLogInButton;
    @FindBy(id = "nameofuser")
    private WebElement welcomeUserButton;
    @FindBy(id = "signin2")
    private WebElement signUpbutton;
    @FindBy(id = "sign-username")
    private WebElement signUpPopupUsernameInput;
    @FindBy(id = "sign-password")
    private WebElement signUpPopupPasswordInput;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[3]/button")
    private WebElement closePopupButton;
    @FindBy(xpath = "//button[contains(text(), 'Sign up')]")
    private WebElement signUpPopupSignUpButton;
    @FindBy(xpath = "//button[@aria-label=\"Close\"]")
    private WebElement crossPopupButton;
    @FindBy(id = "signInModalLabel")
    private WebElement signupPopupTitle;
    @FindBy(xpath = "//button[@title='Play']")
            private WebElement playVideoButton;
    @FindBy(xpath = "//button[@title='Pause']")
    private WebElement pauseVideoButton;
    @FindBy(xpath = "//button[@title='Unmute']")
    private WebElement unMuteVideoButton;
    @FindBy(xpath = "//button[@title='Mute']")
    private WebElement muteVideoButton;
    @FindBy(id = "example-video_html5_api")
            private WebElement video;
    @FindBy(xpath = "//button[@title='Picture-in-Picture']")
            private WebElement pictureInPictureButton;
    @FindBy(xpath = "//button[@title='Exit Picture-in-Picture']")
    private WebElement exitPictureInPictureButton;
    @FindBy(xpath = "//button[@title='Non-Fullscreen']")
            private WebElement nonFullScreenButton;
    @FindBy(xpath = "//button[@title='Fullscreen']")
    private WebElement fullScreenButton;
    @FindBy(id = "videoModalLabel")
            private WebElement aboutUsPopupTitle;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/form/div/div/button/span[1]")
            private WebElement onVideoButton;
    @FindBy(id = "exampleModalLabel")
            private WebElement contactPopUpTitle;
    @FindBy(id = "recipient-email")
            private WebElement contactEmailContactPopUpInput;
    @FindBy(id = "recipient-name")
    private WebElement contactNameContactPopUpInput;
    @FindBy(id = "message-text")
    private WebElement messageContactPopUpInput;
    @FindBy(xpath = "//button[contains(text(), 'Send message')]")
            private WebElement sendMessageContactPopupButton;

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
    public void clickLogInButton(){
        loginButton.click();
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
    public void clickCrossPopupButton(){
        crossPopupButton.click();
    }

    public Boolean isSignupPopupTitleCorrect(String expectedTitle) {
        String actualTitle = signupPopupTitle.getText();
        if (actualTitle.equals(expectedTitle)){
            return true;
        }
        return false;
    }
    public void verifyAlertText(String expectedAlertText, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Attendre jusqu'à 10 secondes
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            Assertions.assertEquals(expectedAlertText, alertText);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            Assertions.fail("No alert found");
        }
    }
    public String setUsernameLoginPopup(String username){
        loginPopupUsernameInput.click();
        loginPopupUsernameInput.clear();
        loginPopupUsernameInput.sendKeys(username);
        return username;
    }
    public String setPasswordLoginPopup(String password){
        loginPopupPasswordInput.click();
        loginPopupPasswordInput.clear();
        loginPopupPasswordInput.sendKeys(password);
        return password;
    }
    public void clickLogInButtonLogInPopUp(){
        logInPopupLogInButton.click();
    }
    public boolean isVisibleLogOutButton(){
        if(logoutButton.isDisplayed()){
            return true;
        }
        return false;
    }
    public WebElement getLogoutButton() {
        return logoutButton;
    }
    public boolean welcomeUserButtonContainsText(String username) {
        String buttonText = welcomeUserButton.getText();
        return buttonText.equals("Welcome " + username);
    }
    public void clickAboutUsButton(){
        aboutUsButton.click();
    }
    public Boolean isAboutUsTitle(String expectedTitle){
        String actualTitle =aboutUsPopupTitle.getText();
        if (actualTitle.equals(expectedTitle)){
            return true;
        } else {
        return false;
    }}
    public void clickPlayVideoButton() {
        playVideoButton.click();
    }

    public void clickPauseVideoButton(){
        pauseVideoButton.click();
    }
    public void clickClosePopupButton(){
        closePopupButton.click();
    }
    public void clickMuteButton(){
        muteVideoButton.click();
    }
    public void clickUnMuteButton(){
        unMuteVideoButton.click();
    }
    public void clickPipButton(){
        pictureInPictureButton.click();
    }
    public void clickNonPipButton(){
        exitPictureInPictureButton.click();
    }
    public void clickFullScreenButton(){
        fullScreenButton.click();
    }
    public void clickNonFullScreenButton(){
        nonFullScreenButton.click();
    }
    public void clickOnVideo(){
        onVideoButton.click();
    }
    public boolean isPauseVideoButtonVisible(){
        if (pauseVideoButton.isDisplayed());
        return true;}
    public boolean isPlayVideoButtonVisible(){
        if (playVideoButton.isDisplayed());
        return true;}
    public boolean isMuteButtonVisible(){
        if (muteVideoButton.isDisplayed());
        return true;}
    public boolean isFullScreenButtonVisible(){
        if (fullScreenButton.isDisplayed());
        return true;}
    public boolean isNonFullScreenButtonVisible(){
        if (nonFullScreenButton.isDisplayed());
        return true;}
    public boolean isUnMuteButtonVisible(){
        if (unMuteVideoButton.isDisplayed());
        return true;}
    public void setContactEmailContactPopup(String contactEmail){
        contactEmailContactPopUpInput.click();
        contactEmailContactPopUpInput.clear();
        contactEmailContactPopUpInput.sendKeys(contactEmail);
    }
    public void setContactNameContactPopup(String contactName){
        contactNameContactPopUpInput.click();
        contactNameContactPopUpInput.clear();
        contactNameContactPopUpInput.sendKeys(contactName);
    }
    public void setMessageContactPopup(String message){
        messageContactPopUpInput.click();
        messageContactPopUpInput.clear();
        messageContactPopUpInput.sendKeys(message);
    }
    public void clickSendMessageButton(){
        sendMessageContactPopupButton.click();
    }

    public boolean isCorrectContactPopupTitle(){
        String contactTitle = "New message";
        return contactPopUpTitle.getText().equals(contactTitle);
    }
}
