package com.parkinglot;

/**
 * Created by subharthi on 11/2/16.
 */
public class ParkingSlotInfo {

    private Car car;
    private Integer slotNumber;

    ParkingSlotInfo(){

    }

    public ParkingSlotInfo(Integer slotNumber,Car car){
        this.car = car;
        this.slotNumber = slotNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParkingSlotInfo{");
        sb.append("car=").append(car);
        sb.append(", slotNumber=").append(slotNumber);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingSlotInfo that = (ParkingSlotInfo) o;

        if (!slotNumber.equals(that.slotNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return slotNumber.hashCode();
    }
}
