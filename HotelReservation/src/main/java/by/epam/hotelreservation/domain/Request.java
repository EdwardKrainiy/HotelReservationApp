package by.epam.hotelreservation.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "request")
public class Request {
    @Column(name = "roomsAmount")
    private int roomsAmount;

    @Column(name = "comfortLevel")
    private int comfortLevel;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "requestId")
    private int requestId;

    @Column(name = "price")
    private int price;

    @Column(name = "daysAmount")
    private int daysAmount;

    public Request(int roomsAmount, int comfortLevel, int requestId, int price, int requiredAmountOfDays) {
        this.roomsAmount = roomsAmount;
        this.comfortLevel = comfortLevel;
        this.requestId = requestId;
        this.price = price;
        this.daysAmount = requiredAmountOfDays;
    }

    public Request(){
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(int roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(int comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDaysAmount() {
        return daysAmount;
    }

    public void setDaysAmount(int daysAmount) {
        this.daysAmount = daysAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return requestId == request.requestId &&
                price == request.price &&
                daysAmount == request.daysAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, price, daysAmount);
    }

    @Override
    public String toString() {
        return "request{" +
                "requestId=" + requestId +
                ", price=" + price +
                ", roomsAmount=" +
                ", requiredAmountOfDays=" + daysAmount +
                '}';
    }
}
