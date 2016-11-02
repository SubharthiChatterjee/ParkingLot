package com.parkinglot;

import junit.framework.Assert;

public class ParkingServiceImplTest {

    private static final ParkingService PARKING_SERVICE = new ParkingServiceImpl();

    public void testCreateParkingLot() throws Exception {
        PARKING_SERVICE.createParkingLot(6);
        Assert.assertEquals(PARKING_SERVICE.getStatus().size(),6);
    }

    @org.junit.Test
    public void testParkVehicle() throws Exception {
        PARKING_SERVICE.createParkingLot(6);
        Assert.assertEquals(PARKING_SERVICE.getStatus().size(),6);

        Car car1 = new Car();
        car1.setColor("White");
        car1.setRegistrationNumber("KA\u00AD01\u00ADHH\u00AD1234");
        PARKING_SERVICE.parkVehicle(car1);

        Car car2 = new Car();
        car2.setColor("White");
        car2.setRegistrationNumber("KA\u00AD01\u00ADHH\u00AD9999");
        PARKING_SERVICE.parkVehicle(car2);

        Car car3 = new Car();
        car3.setColor("Black");
        car3.setRegistrationNumber("KA\u00AD01\u00ADBB\u00AD0001");
        PARKING_SERVICE.parkVehicle(car3);

        Car car4 = new Car();
        car4.setColor("Red");
        car4.setRegistrationNumber("KA\u00AD01\u00ADHH\u00AD7777");
        PARKING_SERVICE.parkVehicle(car4);

        Car car5 = new Car();
        car5.setColor("Blue");
        car5.setRegistrationNumber("KA\u00AD01\u00ADHH\u00AD2701");
        PARKING_SERVICE.parkVehicle(car5);

        Car car6 = new Car();
        car6.setColor("Black");
        car6.setRegistrationNumber("KA\u00AD01\u00ADHH\u00AD3141");
        PARKING_SERVICE.parkVehicle(car6);

        Assert.assertEquals(Boolean.TRUE.booleanValue(), ParkingServiceImpl.getEmptyParkingSlots().isEmpty());

        PARKING_SERVICE.vacateParkingSlot(4);
        PARKING_SERVICE.vacateParkingSlot(2);
        PARKING_SERVICE.vacateParkingSlot(6);
        PARKING_SERVICE.getStatus();

        Car car7 = new Car();
        car7.setColor("White");
        car7.setRegistrationNumber("KA\u00AD01\u00ADP\u00AD333");
        PARKING_SERVICE.parkVehicle(car7);

        Car car8 = new Car();
        car8.setColor("White");
        car8.setRegistrationNumber("DL\u00AD12\u00ADAA\u00AD9999");
        PARKING_SERVICE.parkVehicle(car8);

        PARKING_SERVICE.getStatus();
    }

    @org.junit.Test
    public void testVacateParkingSlot() throws Exception {

    }

    @org.junit.Test
    public void testGetVehicle() throws Exception {

    }

    @org.junit.Test
    public void testGetSlotNumbers() throws Exception {

    }

    @org.junit.Test
    public void testGetSlotNumber() throws Exception {

    }
}