package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class ParkingLot {
    private int slot;
    private Vehicle vehicle;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private double price;

    public ParkingLot(int slot, Vehicle vehicle, LocalDateTime arrivalTime, LocalDateTime departureTime, double price) {
        this.slot = slot;
        this.vehicle = vehicle;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.price = price;
    }

    public ParkingLot() {
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return slot == that.slot && Double.compare(price, that.price) == 0 && Objects.equals(vehicle, that.vehicle) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(departureTime, that.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slot, vehicle, arrivalTime, departureTime, price);
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "slot=" + slot +
                ", vehicle=" + vehicle +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", price=" + price +
                '}';
    }
}
