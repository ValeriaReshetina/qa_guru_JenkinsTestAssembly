package checks;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPageChecks {

    public RegistrationPageChecks checkResult(String columnName, String expectedValue) {
        compareValueInTableResult(columnName, expectedValue);
        return this;
    }

    //CHECKS FOR THE TABLE THAT APPEARS AFTER CLICKING SUBMIT BUTTON

    private void compareValueInTableResult(String columnName, String expectedValue) {
        $x("//td[contains(text(), '" + columnName + "')]/following-sibling::td[1]")
                .shouldHave(text(expectedValue));
    }
}
