package tests.tab.positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;

import tests.base.BaseTest;



import static contants.Contants.BASE_URL;

public class AdminPositiveTest extends BaseTest {

    String PAGE_URL = BASE_URL + "unknown";

    @DisplayName("Добавить: unknown")
    @ParameterizedTest(name = "{index} с данным: {0}, тип: {1}")
    @CsvSource(value = {
            "A,5",
            "B,6",
            "C,7",
            "D,8",
            "E,9",
            "F,10",
            "G,11",
            "H,12"
    })
    public void addOptionUnknown(String nameOptionValue, String displayOrder){
        basePage.goToUrl(PAGE_URL);
        staticButton.openEntryInListFieldByName("unknown");
        tab
                .clickOneOfTheButtonsInActivityTaB(1);
        addPopUp
                .enterInputValue("unknown", nameOptionValue)
                .enterInputValue("unknown", nameOptionValue)
                .enterInputValue("unknown", displayOrder)
                .submitButtonSave();
    }
}
