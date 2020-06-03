package by.epam.hotelreservation.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "roomsAmount")
    private int roomsAmount;

    @Column(name = "comfortLevel")
    private int comfortLevel;

    public Room(int roomsAmount, int comfortLevel){
        this.roomsAmount = roomsAmount;
        this.comfortLevel = comfortLevel;
    }

    public Room(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomsAmount == room.roomsAmount &&
                comfortLevel == room.comfortLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomsAmount, comfortLevel);
    }

    @Override
    public String toString() {
        return "room{" +
                "roomsAmount=" + roomsAmount +
                ", comfortLevel=" + comfortLevel +
                '}';
    }
}
