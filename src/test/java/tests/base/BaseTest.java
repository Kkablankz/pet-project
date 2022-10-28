package tests.base;

import common.CommonActions;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.authorization.Authorization;
import base.BasePage;

import pages.pop_up.AddPopUp;
import pages.pop_up.SearchButtonSelectPopUp;
import pages.static_pages.StaticButton;
import pages.tab.Tab;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.*;
import static contants.Contants.BASE_URL;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //Annotation for executing all classes every start tests
public class BaseTest {
    protected final WebDriver driver;
    protected final BasePage basePage;

    protected final Authorization authorization;
    protected final StaticButton staticButton;
    protected final AddPopUp addPopUp;
    protected final Tab tab;
    protected final SearchButtonSelectPopUp searchButtonSelectPopUp;

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    /** Output message to the console*/
    static {
        try {
            LOGGER.info("START TIME:" + LocalTime.now());
            LOGGER.info("Start clear reports dir: build/reports ...");
            File allureResults = new File("allure-results");
            if (allureResults.isDirectory() && allureResults.exists()) {
                for (File item : Objects.requireNonNull(allureResults.listFiles()))
                    item.delete();
            }
            if (CLEAR_REPORT_DIRECTORY) {
                File allureScreenShots = new File("build/reports/tests");
                if (allureScreenShots.exists()) {
                    for (File item : Objects.requireNonNull(allureScreenShots.listFiles()))
                        item.delete();
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
            throw new RuntimeException("Инициализация статического блока не удалась!", t);
        }
    }

    public BaseTest() {
        try {
            driver = CommonActions.createDriver();
            basePage = new BasePage(driver);
            authorization = new Authorization(driver);
            staticButton = new StaticButton(driver);
            addPopUp = new AddPopUp(driver);
            tab = new Tab(driver);
            searchButtonSelectPopUp = new SearchButtonSelectPopUp(driver);
        } catch (Throwable t) {
            t.printStackTrace();
            throw new RuntimeException("Инициализация клсса BaseTest не удалась!", t);
        }
    }

    /**
     * Auxiliary methods for test life cycle:
     */

    @BeforeAll
    @Owner(value = "Kabylanbek")
    void authenticationToSite() {
        basePage.goToUrl(BASE_URL);
        authorization
                .enterNameAuthorization("unknown")
                .enterPasswordAuthorization("unknown")
                .clickButtonSignIn();
    }

    @AfterEach
    /**Clearing cookies and local storage*/
    void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    /**Browser opening and closing control*/
    void close() {
        if (!HOLD_BROWSER_OPEN) {
            driver.close();
        }
    }
}
