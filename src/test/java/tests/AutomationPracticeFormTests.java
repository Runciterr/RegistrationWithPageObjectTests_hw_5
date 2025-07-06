package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationPracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillAutomationFormTest() {

        registrationPage
                //.openPage()
                .setFirstName("Den")
                .setLastName("White")
                .setEmail("DedWhite@example.com")
                .setUserNumber("89104054060")
                .setGender("Male")
                .setDateOfBirth("26", "March", "1990")
                .setCurrentAddress("Russia, Moscow")
                .setSubject("English")
                .setHobbie("Reading")
                .uploadPicture()
                .setState("Rajasthan")
                .setCity("Jaipur")
                .submitForm();

        registrationPage
                .checkResult("Student Name", "Den White")
                .checkResult("Student Email", "DedWhite@example.com")
                .checkResult("Student Email", "DedWhite@example.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8910405406")
                .checkResult("Date of Birth", "26 February,1990")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "af75334fb974303ac203acd513435cc2.jpg")
                .checkResult("Address", "Russia, Moscow")
                .checkResult("State and City", "Rajasthan Jaipur")
                .checkResultTableAppears();
    }

    @Test
    void positiveMinFormTest() {

        registrationPage
                //.openPage()
                .setFirstName("Den")
                .setLastName("White")
                .setGender("Male")
                .setUserNumber("89104054060")
                .submitForm();

        registrationPage
                .checkResult("Student Name", "Den White")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8910405406")
                .checkResultTableAppears();
    }

    @Test
    void negativeFillFormTest() {
        registrationPage
                //.openPage()
                .setFirstName("Den")
                .setLastName("")
                .setGender("Male")
                .setUserNumber("89104054060")
                .submitForm();

        registrationPage
                .checkResultTableNotAppears();
    }
}
