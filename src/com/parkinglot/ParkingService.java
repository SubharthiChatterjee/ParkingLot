package com.parkinglot;

import java.util.List;

/**
 * Created by subharthi on 11/2/16.
 */
public interface ParkingService {

    /**
     *
     * @param car
     * @return
     */
    String parkVehicle(Car car);

    /**
     *
     * @param noOfslots
     * @return
     */
    String createParkingLot(Integer noOfslots);

    /**
     *
     * @param slot
     * @return
     */
    String vacateParkingSlot(Integer slot);

    /**
     *
     * @return
     */
    List<ParkingSlotInfo> getStatus();

    /**
     *
     * @param color
     * @return
     */
    List<Car> getVehicle(String color);

    /**
     *
     * @param color
     * @return
     */
    List<Integer> getSlotNumbers(String color);

    /**
     *
     * @param registrationNumber
     * @return
     */
    Integer getSlotNumber(String registrationNumber);
}
