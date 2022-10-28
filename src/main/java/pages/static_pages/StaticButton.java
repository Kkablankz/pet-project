package pages.static_pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.BasePage;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.*;


public class StaticButton extends BasePage {
    public StaticButton(WebDriver driver) {
        super(driver);
    }

    private final By buttonAdd = cssSelector("button.unknown");
    private final By buttonSave = cssSelector("button.unknown");


    @Step("Кнопка: Добавить")
    public StaticButton submitAddButton() {
        WebElement button = driver.findElement(buttonAdd);
        button.isEnabled();
        driver.findElement(buttonAdd).click();
        return this;
    }

    @Step("Сохранение данных")
    public StaticButton submitSaveButton() {
        WebElement button = driver.findElement(buttonSave);
            button.click();
        return this;
    }

    private final String ENTRY_NAME_XPATH_TEMPLATE_TREE = "//td[@title= '%s']/..//*[@class = 'unknown']";

    @Step("Открытие записи  номеру в таблице {0}")
    public StaticButton openEntryInListFieldByName(String entryName) {
        //Main page open entry by code use Name
        driver.findElement(xpath(format(ENTRY_NAME_XPATH_TEMPLATE_TREE,entryName))).click();
        return this;
    }
}
