package data;


public class SuitTestData {
    TestDataGenerator data = new TestDataGenerator();

    public String firstName = data.getFirstName();
    public String lastName = data.getLastName();
    public String emailAddress = data.getEmail();
    public String userNumber = data.getUserNumber();
    public String currentAddress = data.getCurrentAddress();
    public String gender = data.getGender();
    public String day = data.getDay();
    public String month = data.getMonth();
    public String year = data.getYear();
    public String subject = data.getSubject();
    public String hobby = data.getHobby();
    public String state = data.getState();
    public String city = data.getCity(state);
    public String picture = data.getPicture();
}
