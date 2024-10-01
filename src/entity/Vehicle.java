package entity;

import java.util.Objects;

public class Vehicle {
    private LicensePlate licensePlate;
    private String color;
    private String type;

    public Vehicle(LicensePlate licensePlate, String color, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.color = color;
    }

    public Vehicle() {
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(licensePlate, vehicle.licensePlate) && Objects.equals(type, vehicle.type) && Objects.equals(color, vehicle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, type, color);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate=" + licensePlate +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
