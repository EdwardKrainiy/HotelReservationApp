package domain;

import java.util.Objects;

public class Client extends Entity {
    private int cost;
    private int id;

    public Client(String firstName, String secondName, int age, String login, String password, int cost, int id) {
        super(firstName, secondName, age, login, password);
        this.cost = cost;
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Client(){
        super();
    }

    public int getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return cost == client.cost &&
                id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cost, id);
    }

    @Override
    public String toString() {
        return "client{" +
                "cost=" + cost +
                ", requestId=" + id +
                '}';
    }
}
