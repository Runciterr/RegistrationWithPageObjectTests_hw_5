package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private SelenideElement assertionTable = $(".table-responsive");

    public void resultTable(String key, String value) {
        assertionTable.$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkResultTableNotAppears() {
        assertionTable.shouldNot(appear);
    }
}
