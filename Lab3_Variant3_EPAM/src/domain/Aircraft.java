package domain;

import java.util.List;
import java.util.Objects;

public class Aircraft {
    private String name;
    private int price;
    private int capacity;
    private List<Owner> stores;

    public Aircraft(String name, int price, int capacity, List<Owner> stores) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.stores = stores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Owner> getStores() {
        return stores;
    }

    public void setStores(List<Owner> stores) {
        this.stores = stores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return price == aircraft.price &&
                capacity == aircraft.capacity &&
                Objects.equals(name, aircraft.name) &&
                Objects.equals(stores, aircraft.stores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, capacity, stores);
    }

    @Override
    public String toString() {
        return "Name: '" + name +
                ", Price: " + price +
                ", Capacity: " + capacity +
                ", Stores: " + stores;
    }

    public static int compare(Aircraft aircraft, Aircraft aircraft1) {
        if(aircraft.getCapacity() > aircraft1.getCapacity())
            return 1;
        return -1;
    }
}
