package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class AutomationPracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillAutomationFormTest() {

        registrationPage
                .openPage()
                .closeAdBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setUserNumber(userNumber)
                .setGender(gender)
                .setDateOfBirth(day, month, year)
                .setCurrentAddress(currentAddress)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setState(state)
                .setCity(city)
                .submitForm();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city)
                .checkResultTableAppears();
    }

    @Test
    void positiveMinFormTest() {

        registrationPage
                .openPage()
                .closeAdBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .submitForm();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResultTableAppears();
    }

    @Test
    void negativeFillFormTest() {
        registrationPage
                .openPage()
                .closeAdBanners()
                .setFirstName(firstName)
                .setLastName("")
                .setGender(gender)
                .setUserNumber(userNumber)
                .submitForm();

        registrationPage
                .checkResultTableNotAppears();
    }
}
