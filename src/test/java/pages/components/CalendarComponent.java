package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private ElementsCollection selectDayOfBirth = $$(".react-datepicker__day");

    private SelenideElement
            selectMonthOfBirth = $(".react-datepicker__month-select"),
            selectYearOfBirth = $(".react-datepicker__year-select");


    public void setDate(String day, String month, String year) {
        selectMonthOfBirth.selectOption(month);
        selectYearOfBirth.selectOption(year);
        selectDayOfBirth.findBy(text(day)).click();
    }


}
