package data;


public class SuitTestData {
    TestDataGenerator data = new TestDataGenerator();

    public String firstName = data.firstName();
    public String lastName = data.lastName();
    public String emailAddress = data.email();
    public String userNumber = data.userNumber();
    public String currentAddress = data.currentAddress();
    public String gender = data.gender();
    public String day = data.day();
    public String month = data.month();
    public String year = data.year();
    public String subject = data.subject();
    public String hobby = data.hobby();
    public String state = data.state();
    public String city = data.city();
    public String picture = data.picture();
}
