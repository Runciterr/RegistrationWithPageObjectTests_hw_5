package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.ResultTableComponent;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {


    private SelenideElement
            userNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAdressInput = $("#currentAddress"),
            permamentAdressInput = $("#permanentAddress"),
            submitFormButton = $("#submit"),
            formResultName = $("#output #name"),
            formResultEmail = $("#output #email"),
            formResultCurrentAddress = $("#output").$("#currentAddress"),
            formResultPermanentAddress = $("#output").$("#permanentAddress");


    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setUserNameInput(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmailInput(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentUserAddress(String value) {
        currentAdressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentUserAddress(String value) {
        permamentAdressInput.setValue(value);

        return this;
    }

    public TextBoxPage submitForm() {
        submitFormButton.click();

        return this;
    }

    public TextBoxPage checkResult(String username, String email, String currentAddress, String permanentAddress) {
        formResultName.shouldHave(text(username));
        formResultEmail.shouldHave(text(email));
        formResultCurrentAddress.shouldHave(text(currentAddress));
        formResultPermanentAddress.shouldHave(text(permanentAddress));

        return this;
    }
}
