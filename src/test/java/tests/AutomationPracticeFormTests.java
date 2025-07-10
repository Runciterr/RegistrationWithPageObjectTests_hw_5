package tests;

import data.SuitTestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static data.TestData.*;

public class AutomationPracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SuitTestData data = new SuitTestData();

    @Test
    void fillAutomationFormTest() {

        registrationPage
                .openPage()
                .closeAdBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.emailAddress)
                .setUserNumber(data.userNumber)
                .setGender(data.gender)
                .setDateOfBirth(data.day, data.month, data.year)
                .setCurrentAddress(data.currentAddress)
                .setSubject(data.subject)
                .setHobby(data.hobby)
                .uploadPicture(data.picture)
                .setState(data.state)
                .setCity(data.city)
                .submitForm();

        registrationPage
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.emailAddress)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", data.picture)
                .checkResult("Address", data.currentAddress)
                .checkResult("State and City", data.state + " " + data.city)
                .checkResultTableAppears();
    }

    @Test
    void positiveMinFormTest() {

        registrationPage
                .openPage()
                .closeAdBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .submitForm();

        registrationPage
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResultTableAppears();
    }

    @Test
    void negativeFillFormTest() {
        registrationPage
                .openPage()
                .closeAdBanners()
                .setFirstName(data.firstName)
                .setLastName("")
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .submitForm();

        registrationPage
                .checkResultTableNotAppears();
    }
}
