package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static common.Config.BROWSER_AND_PLATFORM;
import static contants.Contants.TimeOutVariables.IMPLICIT_WAIT;

public class CommonActions {
    public static WebDriver createDriver(){
        WebDriver driver = null;
        switch (BROWSER_AND_PLATFORM) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options =new ChromeOptions();
                options.setHeadless(false);
                options.addArguments("window-size=1920,1080");
                driver = new ChromeDriver(options);
                break;
            case "mozilla":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                Assertions.fail("INCORRECT BROWSER NAME" + BROWSER_AND_PLATFORM);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

        return driver;
    }
}
