package data;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    public static Faker faker = new Faker();

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option(TestDataConstants.GENDER_OPTIONS);
    }

    public String getUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getCurrentAddress() {
        return faker.address().streetAddress();
    }

    public String getDay() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public String getMonth() {
        return faker.options().option(TestDataConstants.MONTH_OPTIONS);
    }

    public String getYear() {
        return String.format("%s", faker.number().numberBetween(1920, 2024));
    }

    public String getSubject() {
        return faker.options().option(TestDataConstants.SUBJECT_OPTIONS);
    }

    public String getHobby() {
        return faker.options().option(TestDataConstants.HOBBY_OPTIONS);
    }

    public String getPicture() {
        return faker.options().option(TestDataConstants.PICTURE);
    }

    public String getState() {
        return faker.options().option(TestDataConstants.STATE_OPTIONS);
    }


    public String getCity(String state) {
        return getCityForState(state);
    }


    public static String getCityForState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option(TestDataConstants.CITY_NCR);
            case "Uttar Pradesh" -> faker.options().option(TestDataConstants.CITY_UTTAR_PRADESH);
            case "Haryana" -> faker.options().option(TestDataConstants.CITY_HARYANA);
            case "Rajasthan" -> faker.options().option(TestDataConstants.CITY_RAJASTHAN);
            default -> null;
        };
    }
}
