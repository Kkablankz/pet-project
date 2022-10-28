package pages.pop_up;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.BasePage;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.*;

public class AddPopUp extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public AddPopUp(WebDriver driver) {
        super(driver);
    }
    private static final String INPUT_BY_TEMPLATE_MODAL_IN = "//div[@class = \"unknown in\"]//input[@id = \"unknown'%s'.value\"]";

    private final By filterPopButton = xpath("//button[@class = 'unknown']");

    @Step("Поле: {0}. Ввод данных: {1} ")
    public AddPopUp enterInputValue(String fieldName, String value) {
        WebElement elementValue = driver.findElement(xpath(format(INPUT_BY_TEMPLATE_MODAL_IN, fieldName)));
        WebElement elementForScroll = driver.findElement(xpath("//div[@class = 'unknown'][last()]"));
        js.executeScript("arguments[0].scrollIntoView();", elementForScroll);
        elementValue.clear();
        elementValue.sendKeys(value);
        return this;
    }

    @Step("Кнопка")
    public AddPopUp clickFilterButtonInPopUp(){
        driver.findElement(filterPopButton).click();
        return this;
    }


    private final By saveButton = cssSelector("button.unknown");
    @Step("Клик по кнопке: ")
    public void submitButtonSave() {
        driver.findElement(saveButton).click();
    }
}