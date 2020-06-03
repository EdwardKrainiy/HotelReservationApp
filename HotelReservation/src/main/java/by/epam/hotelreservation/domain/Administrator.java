package by.epam.hotelreservation.domain;

public class Administrator extends Entity {
    public Administrator(String firstname, String secondname, int age, String login, String password) {
        super(firstname, secondname, age, login, password);
    }
    public Administrator(){
        super();
    }
}
