package Exercices.Demoblaze.Tests;

import PageObjectModel.Demoblaze.HeaderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

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

    public void AboutUsPopup01() throws InterruptedException {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        objHeaderPage.clickAboutUsButton();
        objHeaderPage.clickOnVideo();
        assertTrue(objHeaderPage.isPauseVideoButtonVisible());
        objHeaderPage.clickPauseVideoButton();
        assertTrue(objHeaderPage.isPlayVideoButtonVisible());
        objHeaderPage.clickPlayVideoButton();
        assertTrue(objHeaderPage.isMuteButtonVisible());
        objHeaderPage.clickMuteButton();
        assertTrue(objHeaderPage.isUnMuteButtonVisible());
        objHeaderPage.clickUnMuteButton();
        assertTrue(objHeaderPage.isFullScreenButtonVisible());
        objHeaderPage.clickFullScreenButton();
        assertTrue(objHeaderPage.isNonFullScreenButtonVisible());
        objHeaderPage.clickNonFullScreenButton();
        objHeaderPage.clickClosePopupButton();

    }
    @AfterEach

    public void tearDown(){

        driver.quit();
    }
}
