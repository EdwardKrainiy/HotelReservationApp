package domain;

import java.util.Objects;

public class Request {
    private int requestId;
    private int price;
    private int roomsAmount;
    private int comfortLevel;
    private int daysAmount;

    public Request(int requestId, int price, int roomsAmount, int comfortLevel, int requiredAmountOfDays) {
        this.requestId = requestId;
        this.price = price;
        this.roomsAmount = roomsAmount;
        this.comfortLevel = comfortLevel;
        this.daysAmount = requiredAmountOfDays;
    }

    public Request(){

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
                roomsAmount == request.roomsAmount &&
                comfortLevel == request.comfortLevel &&
                daysAmount == request.daysAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, price, roomsAmount, comfortLevel, daysAmount);
    }

    @Override
    public String toString() {
        return "request{" +
                "requestId=" + requestId +
                ", price=" + price +
                ", roomsAmount=" + roomsAmount +
                ", comfortLevel=" + comfortLevel +
                ", requiredAmountOfDays=" + daysAmount +
                '}';
    }
}
