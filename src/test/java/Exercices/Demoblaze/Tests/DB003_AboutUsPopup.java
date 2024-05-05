package Exercices.Demoblaze.Tests;

import PageObjectModel.Demoblaze.HeaderPage;
import PageObjectModel.Demoblaze.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB003_AboutUsPopup {
    static FirefoxDriver driver;
    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();

    }
    @Test
    @DisplayName("About us popup - 01")
    @Description("Passing case - Lecture/Pause/Agrandir/Rétrécir/Pip/NoPip/Mute/Unmute/Fullscen/Unfullscreen/Fermer")

    public void AboutUsPopup01() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        objHeaderPage.clickAboutUsButton();
        objHeaderPage.clickPlayVideoButton();
        objHeaderPage.clickPauseVideoButton();
        objHeaderPage.clickMutebutton();
        objHeaderPage.clickUnMuteButton();
        objHeaderPage.clickPipbutton();
        objHeaderPage.clickNonPipButton();
        objHeaderPage.clickFullScreenButton();
        objHeaderPage.clickNonFullScreenButton();
        objHeaderPage.clickClosePopupButton();

    }
}
