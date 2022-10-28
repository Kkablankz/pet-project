package pages.tab;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BasePage;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;


public class Tab extends BasePage {
    public Tab(WebDriver driver) {
        super(driver);
    }

    /**
     * Section Tabs Container
     */
    private static final String TAB_BY_TEXT_XPATH_TEMPLATE = "//li[@role = 'unknown']//span[contains(text(), '%s')]";
    private static final String TAB_BY_BUTTON_XPATH_TEMPLATE = "//div[contains(@class, 'unknown') and contains(@class, 'unknown')]//button[contains(text(), '%s')][not(@disabled)]";

    @Step("Навигация на {nameTab}")
    public Tab navigateSectionTab(String nameTab) {
        driver.findElement(xpath(format(TAB_BY_TEXT_XPATH_TEMPLATE, nameTab))).click();
        return this;
    }


    @Step("Переход по одной из кнопок: ")
    public Tab clickOneOfTheButtonsInActivityTaB(int buttonNumber) {
        List<WebElement> buttons = driver.findElements(xpath(format(TAB_BY_BUTTON_XPATH_TEMPLATE, "Добавить")));
        WebElement addButton = buttons.get(buttonNumber - 1);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
        return this;
    }

    @Step("Переход по одной из кнопок: {0}")
    public Tab clickDisabledButton(String buttonName) {
        WebElement disabledButton = driver.findElement(xpath(format(TAB_BY_BUTTON_XPATH_TEMPLATE, buttonName)));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(disabledButton));
        disabledButton.click();
        return this;
    }
}
