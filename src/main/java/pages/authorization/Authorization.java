package pages.authorization;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class Authorization extends BasePage {
    public Authorization(WebDriver driver) {
        super(driver);
    }

    private final By nameAuthorization = By.name("username");
    private final By passwordAuthorization = By.name("password");
    private final By buttonSignIn = By.xpath("//button[contains(@class, 'recaptcha')]");

    @Step("Ввод: Имя пользователя")
    public Authorization enterNameAuthorization(String name) {
        driver.findElement(nameAuthorization).sendKeys(name);
        return this;
    }

    @Step("Ввод: Пароль")
    public Authorization enterPasswordAuthorization(String password) {
        driver.findElement(passwordAuthorization).sendKeys(password);
        return this;
    }

    @Step("Клик: Кнопка Входа")
    public Authorization clickButtonSignIn() {
        driver.findElement(buttonSignIn).click();
        return this;
    }
}

