package com.parkinglot;

import java.util.*;

/**
 * Created by subharthi on 11/2/16.
 */
public class ParkingServiceImpl implements ParkingService {

    private static final Map<Integer, ParkingSlot> parkingSlotMap = new TreeMap<>();
    private static final List<ParkingSlot> emptyParkingSlots = new ArrayList<>();
    private static final Map<String, List<ParkingSlotInfo>> colorVsParkingSlotInfo = new HashMap<>();
    private static final Map<String, ParkingSlotInfo> registeryNumberVsParkingSlotInfo = new HashMap<>();

    public static List<ParkingSlot> getEmptyParkingSlots(){
        return emptyParkingSlots;
    }

    @Override
    public String parkVehicle(Car car) {
        if(emptyParkingSlots.isEmpty())
            return null;

        ParkingSlot parkingSlot = emptyParkingSlots.get(0);
        ParkingSlotInfo parkingSlotInfo = new ParkingSlotInfo(parkingSlot.getParkingSlotNumber(),car);
        parkingSlot.setParkingSlotInfo(parkingSlotInfo);
        parkingSlot.setIsEmpty(Boolean.FALSE);
        emptyParkingSlots.remove(parkingSlot);
        parkingSlotMap.put(parkingSlot.getParkingSlotNumber(), parkingSlot);

        List<ParkingSlotInfo> parkingSlotInfos = colorVsParkingSlotInfo.get(car.getColor().toLowerCase());
        if(parkingSlotInfos == null)
            parkingSlotInfos = new ArrayList<>();
        parkingSlotInfos.add(parkingSlotInfo);
        colorVsParkingSlotInfo.put(car.getColor().toLowerCase(),parkingSlotInfos);
        registeryNumberVsParkingSlotInfo.put(car.getRegistrationNumber().toLowerCase(), parkingSlotInfo);
        return String.valueOf(parkingSlot.getParkingSlotNumber());
    }

    @Override
    public String createParkingLot(Integer noOfslots) {
        for(int index = 0; index<noOfslots; index++) {
            ParkingSlot parkingSlot = new ParkingSlot();
            parkingSlot.setParkingSlotNumber(index+1);
            parkingSlotMap.put(index+1,parkingSlot);
            emptyParkingSlots.add(parkingSlot);
        }
        return String.valueOf(noOfslots);
    }

    @Override
    public String vacateParkingSlot(Integer slot) {
        ParkingSlot parkingSlot = parkingSlotMap.get(slot);
        parkingSlot.setIsEmpty(Boolean.TRUE);
        parkingSlot.setParkingSlotInfo(null);
        parkingSlotMap.put(parkingSlot.getParkingSlotNumber(), parkingSlot);
        for (int index = 0; index < emptyParkingSlots.size(); index++) {
            ParkingSlot parkingSlot1 = emptyParkingSlots.get(index);
            if(parkingSlot1.getParkingSlotNumber() > slot){
                emptyParkingSlots.add(index, parkingSlot);
                return String.valueOf(slot);
            }
        }
        emptyParkingSlots.add(parkingSlot);
        return String.valueOf(slot);
    }

    @Override
    public List<ParkingSlotInfo> getStatus() {
        List<ParkingSlotInfo> parkingSlotInfos = new ArrayList<>();
        for(Map.Entry<Integer, ParkingSlot> parkingSlotEntry:parkingSlotMap.entrySet()){
            parkingSlotInfos.add(parkingSlotEntry.getValue().getParkingSlotInfo());
        }
        return parkingSlotInfos;
    }

    @Override
    public List<Car> getVehicle(String color) {
        List<ParkingSlotInfo> parkingSlotInfos = colorVsParkingSlotInfo.get(color.toLowerCase());
        if(parkingSlotInfos != null){
            List<Car> cars = new ArrayList<>();
            for(ParkingSlotInfo parkingSlotInfo:parkingSlotInfos){
                cars.add(parkingSlotInfo.getCar());
            }
            return cars;
        }
        return null;
    }

    @Override
    public List<Integer> getSlotNumbers(String color) {
        List<ParkingSlotInfo> parkingSlotInfos = colorVsParkingSlotInfo.get(color.toLowerCase());
        if(parkingSlotInfos != null){
            List<Integer> parkingSlotNumbers = new ArrayList<>();
            for(ParkingSlotInfo parkingSlotInfo:parkingSlotInfos){
                parkingSlotNumbers.add(parkingSlotInfo.getSlotNumber());
            }
            return parkingSlotNumbers;
        }
        return null;
    }

    @Override
    public Integer getSlotNumber(String registrationNumber) {
        ParkingSlotInfo parkingSlotInfo = registeryNumberVsParkingSlotInfo.get(registrationNumber.toLowerCase());
        if(parkingSlotInfo != null){
            return parkingSlotInfo.getSlotNumber();
        }
        return -1;
    }

}
