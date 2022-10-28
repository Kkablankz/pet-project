package pages.pop_up;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.BasePage;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class SearchButtonSelectPopUp extends BasePage {
    public SearchButtonSelectPopUp(WebDriver driver) {
        super(driver);
    }

    private final By searchButton = xpath("//div[@class='deleteted']//span[@class ='input-group-btn']");
    private final By selectButton = cssSelector("button.unknown");
    private final By addButton = cssSelector("button.unknown");

    private static final String VALUE_IN_FIELD = "//div[@class = 'unknown']//td[@unknown = '%s']";

    @Step("Это кнопка поиска в : {0}(иконка)")
    public SearchButtonSelectPopUp searchButton(int count) {
        List<WebElement> buttonSearchList = driver.findElements(searchButton);
        buttonSearchList.get(count - 1).click();
        return this;
    }


    @Step("Выбор значение по  на поле")
    public SearchButtonSelectPopUp selectValueInField(String valueName){
        driver.findElement(xpath(format(VALUE_IN_FIELD,valueName))).click();
        return this;
    }

    @Step("Кнопка: Выбрать")
    public void clickButtonSelect() {
        driver.findElement(selectButton).click();
    }

    @Step("Кнопка: Добавить")
    public void clickButtonAdd() {
        driver.findElement(addButton).click();
    }

}
