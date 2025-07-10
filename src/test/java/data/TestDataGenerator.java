package data;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    public static Faker faker = new Faker();

    public String firstName() {
        return faker.name().firstName();
    }

    public String lastName() {
        return faker.name().lastName();
    }

    public String email() {
        return faker.internet().emailAddress();
    }

    public String gender() {
        return faker.options().option(TestData.GENDER_OPTIONS);
    }

    public String userNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String currentAddress() {
        return faker.address().streetAddress();
    }

    public String day() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public String month() {
        return faker.options().option(TestData.MONTH_OPTIONS);
    }

    public String year() {
        return String.format("%s", faker.number().numberBetween(1920, 2024));
    }

    public String subject() {
        return faker.options().option(TestData.SUBJECT_OPTIONS);
    }

    public String hobby() {
        return faker.options().option(TestData.HOBBY_OPTIONS);
    }

    public String picture() {
        return faker.options().option(TestData.PICTURE);
    }

    public String state() {
        return faker.options().option(TestData.STATE_OPTIONS);
    }

    public static String
            state = faker.options().option(TestData.STATE_OPTIONS);

    public String city() {
        return getCityForState (state);
    }

    public static String getCityForState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option(TestData.CITY_NCR);
            case "Uttar Pradesh" -> faker.options().option(TestData.CITY_UTTAR_PRADESH);
            case "Haryana" -> faker.options().option(TestData.CITY_HARYANA);
            case "Rajasthan" -> faker.options().option(TestData.CITY_RAJASTHAN);
            default -> null;
        };
    }
}
