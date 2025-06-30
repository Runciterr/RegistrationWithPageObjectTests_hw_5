package unformatmail;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage
                .openPage()
                .setUserNameInput("Den")
                .setUserEmailInput("Den@cool.com")
                .setCurrentUserAddress("Elm Street 1")
                .setPermanentUserAddress("Other Street 1")
                .submitForm();

        textBoxPage
                .checkResult("Den", "Den@cool.com", "Elm Street 1", "Other Street 1");
    }
}