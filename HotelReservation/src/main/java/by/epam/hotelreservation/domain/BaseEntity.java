package by.epam.hotelreservation.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Objects;

public class BaseEntity {
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "age")
    private int age;

    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public BaseEntity(String firstName, String secondName, int age, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.login = login;
        this.password = password;
    }

    public BaseEntity(){
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
        BaseEntity baseEntity = (BaseEntity) o;
        return age == baseEntity.age &&
                Objects.equals(firstName, baseEntity.firstName) &&
                Objects.equals(secondName, baseEntity.secondName) &&
                Objects.equals(login, baseEntity.login) &&
                Objects.equals(password, baseEntity.password);
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
