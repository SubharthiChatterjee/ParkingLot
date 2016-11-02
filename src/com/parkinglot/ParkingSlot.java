package com.parkinglot;

/**
 * Created by subharthi on 11/2/16.
 */
public class ParkingSlot {

    private Boolean isEmpty = Boolean.TRUE;
    private Integer parkingSlotNumber;
    private ParkingSlotInfo parkingSlotInfo;

    public Boolean getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(Boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public Integer getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public void setParkingSlotNumber(Integer parkingSlotNumber) {
        this.parkingSlotNumber = parkingSlotNumber;
    }

    public ParkingSlotInfo getParkingSlotInfo() {
        return parkingSlotInfo;
    }

    public void setParkingSlotInfo(ParkingSlotInfo parkingSlotInfo) {
        this.parkingSlotInfo = parkingSlotInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParkingSlot{");
        sb.append("isEmpty=").append(isEmpty);
        sb.append(", parkingSlotNumber=").append(parkingSlotNumber);
        sb.append(", parkingSlotInfo=").append(parkingSlotInfo);
        sb.append('}');
        return sb.toString();
    }
}
