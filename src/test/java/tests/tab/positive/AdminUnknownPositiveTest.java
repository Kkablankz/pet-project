package tests.tab.positive;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import tests.base.BaseTest;


import static contants.Contants.BASE_URL;

@Epic(value = "Вкладка: unknown")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminUnknownPositiveTest extends BaseTest {
    String PAGE_URL = BASE_URL + "/unknown";
    public static final int REPEATS = 20;

    CounterClass counter = CounterClass.getInstance(REPEATS);

    @DisplayName("Добавление unknown")
    @RepeatedTest(REPEATS)
    public void addUnknownWithStatusApproved() throws InterruptedException {
        Thread.sleep(60);
        basePage.goToUrl(PAGE_URL);
        staticButton.submitAddButton();
        addPopUp
                .enterInputValue("unknown", "test-unknown-" + counter.getIndex())
                .enterInputValue("unknown", "test-unknown-" + counter.getIndex());
        searchButtonSelectPopUp
                .searchButton(1)
                .selectValueInField("unknown")
                .clickButtonSelect();
        searchButtonSelectPopUp
                .searchButton(2);

        searchButtonSelectPopUp.selectValueInField("unknown")
                .clickButtonSelect();
        staticButton.submitSaveButton();
        Thread.sleep(500);

        tab
                .navigateSectionTab("unknown")
                .clickOneOfTheButtonsInActivityTaB(2);
        searchButtonSelectPopUp
                .selectValueInField("unknown")
                .clickButtonAdd();

        tab
                .navigateSectionTab("unknown")
                .clickOneOfTheButtonsInActivityTaB(2);
        searchButtonSelectPopUp
                .selectValueInField("unknown")
                .clickButtonAdd();

        //Генерация Skus
        tab
                .navigateSectionTab("unknown")
                .clickDisabledButton("unknown");

        counter.increment();
    }

}
