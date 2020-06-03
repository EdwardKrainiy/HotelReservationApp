package by.epam.hotelreservation.domain;

import java.util.Objects;

public class Entity {
    private String firstName;
    private String secondName;
    private int age;
    private String login;
    private String password;

    public Entity(String firstName, String secondName, int age, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.login = login;
        this.password = password;
    }

    public Entity(){
        this.firstName = "";
        this.secondName = "";
        this.age = -1;
        this.login = "";
        this.password = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return age == entity.age &&
                Objects.equals(firstName, entity.firstName) &&
                Objects.equals(secondName, entity.secondName) &&
                Objects.equals(login, entity.login) &&
                Objects.equals(password, entity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age, login, password);
    }

    @Override
    public String toString() {
        return "entity{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
