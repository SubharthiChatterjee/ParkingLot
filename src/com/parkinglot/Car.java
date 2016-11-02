package com.parkinglot;

/**
 * Created by subharthi on 11/2/16.
 */
public class Car {

    private String registrationNumber;
    private String color;
    private String vehicleType;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("registrationNumber='").append(registrationNumber).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", vehicleType='").append(vehicleType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
