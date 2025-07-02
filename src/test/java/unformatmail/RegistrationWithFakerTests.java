package unformatmail;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithFakerTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterAll
    static void tearDown() {
        closeWebDriver();
    }

    @Test
    void fillAutomationFormTest() {

        Faker faker = new Faker();

        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton
        String userEmail = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue("89104054060");
        $("#genterWrapper").$(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day.react-datepicker__day--026").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("af75334fb974303ac203acd513435cc2.jpg");
        $("#currentAddress").setValue(streetAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(streetAddress));




//        $(".table-responsive").shouldHave(Condition.text("Student Email DedWhite@example.com"));
//        $(".table-responsive").shouldHave(Condition.text("Gender Male"));
//        $(".table-responsive").shouldHave(Condition.text("Mobile 8910405406"));
//        $(".table-responsive").shouldHave(Condition.text("Date of Birth 26 February,1990"));
//        $(".table-responsive").shouldHave(Condition.text("Subjects English"));
//        $(".table-responsive").shouldHave(Condition.text("Hobbies Reading"));
//        $(".table-responsive").shouldHave(Condition.text("Picture af75334fb974303ac203acd513435cc2.jpg"));
//        $(".table-responsive").shouldHave(Condition.text("Address Russia, Moscow"));
//        $(".table-responsive").shouldHave(Condition.text("State and City Rajasthan Jaipur"));


    }

}
