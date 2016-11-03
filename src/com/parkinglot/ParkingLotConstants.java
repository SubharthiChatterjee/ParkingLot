package com.parkinglot;

import java.util.List;

/**
 * Created by subharthi on 11/3/16.
 */
public class ParkingLotConstants {

    public enum ParkingLotCommand {
        CREATE_PARKING_LOT("create_parking_lot") {
            @Override
            public Integer getArguments() {
                return 1;
            }

            @Override
            public String successfulMessage(String param) {
                return "Created a parking lot with " + param + " slots";
            }

            @Override
            public String failMessage() {
                return "Error Occurred";
            }

            @Override
            public void execute(String... args) {
                String slotsCreated = parkingService.createParkingLot(Integer.valueOf(args[0]));
                System.out.println(successfulMessage(slotsCreated));
            }

        },
        PARK("park") {
            @Override
            public Integer getArguments() {
                return 2;
            }

            @Override
            public String successfulMessage(String param) {
                return "Allocated slot number: " + param;
            }

            @Override
            public String failMessage() {
                return "Sorry, parking lot is full";
            }

            @Override
            public void execute(String... args) {
                String parkingSlotNumber = parkingService.parkVehicle(new Car(args[0], args[1]));
                if(parkingSlotNumber == null)
                    System.out.println(failMessage());
                else
                    System.out.println(successfulMessage(parkingSlotNumber));
            }
        },
        LEAVE("leave") {
            @Override
            public Integer getArguments() {
                return 1;
            }

            @Override
            public String successfulMessage(String param) {
                return "Slot number " + param + " is free";
            }

            @Override
            public String failMessage() {
                return "No Car Parked";
            }

            @Override
            public void execute(String... args) {
                String vacateSlot = parkingService.vacateParkingSlot(Integer.valueOf(args[0]));
                System.out.println(successfulMessage(vacateSlot));
            }
        },
        STATUS("status"){
            @Override
            public String successfulMessage(String param) {
                return param;
            }

            @Override
            public String failMessage() {
                return "No Status";
            }

            @Override
            public void execute(String... args) {
                List<ParkingSlotInfo> parkingSlotInfos =  parkingService.getStatus();
                if(parkingSlotInfos.isEmpty())
                    System.out.println(failMessage());
                else{
                    StringBuilder strBuilder = new StringBuilder();
                    strBuilder.append("Slot No.").append("\t").append("Registration No.").append("\t").append("Color").append("\n");
                    for(ParkingSlotInfo parkingSlotInfo:parkingSlotInfos){
                        if(parkingSlotInfo != null) {
                            strBuilder.append(parkingSlotInfo.getSlotNumber()).append("\t")
                                    .append(parkingSlotInfo.getCar().getRegistrationNumber()).append("\t")
                                    .append(parkingSlotInfo.getCar().getColor()).append("\n");
                        }
                    }
                    System.out.print(successfulMessage(strBuilder.toString()));
                }

            }
        },
        REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR("registration_numbers_for_cars_with_colour") {
            @Override
            public Integer getArguments() {
                return 1;
            }

            @Override
            public String successfulMessage(String param) {
                return param;
            }

            @Override
            public String failMessage() {
                return "Not Found";
            }

            @Override
            public void execute(String... args) {
                List<Car> cars = parkingService.getVehicle(args[0]);
                if(cars == null || cars.isEmpty())
                    System.out.println(failMessage());
                else {
                    StringBuilder strBuilder = new StringBuilder();
                    for (Car car : cars)
                        strBuilder.append(car.getRegistrationNumber()).append(", ");
                    strBuilder.substring(0,strBuilder.lastIndexOf(", "));
                    System.out.println(successfulMessage(strBuilder.substring(0,strBuilder.lastIndexOf(", ")).toString()));
                }

            }
        },
        SLOT_NUMBERS_FOR_CARS_WITH_COLOR("slot_numbers_for_cars_with_colour") {
            @Override
            public Integer getArguments() {
                return 1;
            }

            @Override
            public String successfulMessage(String param) {
                return param;
            }

            @Override
            public String failMessage() {
                return "Not Found";
            }

            @Override
            public void execute(String... args) {
                List<Integer> slotNumbers = parkingService.getSlotNumbers(args[0]);
                if(slotNumbers == null)
                    System.out.println(failMessage());
                else{
                    StringBuilder strBuilder = new StringBuilder();
                    for(Integer slotNumber:slotNumbers)
                        strBuilder.append(slotNumber).append(", ");
                    System.out.println(successfulMessage(strBuilder.substring(0,strBuilder.lastIndexOf(", ")).toString()));
                }
            }
        },
        SLOT_NUMBER_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number") {
            @Override
            public Integer getArguments() {
                return 1;
            }

            @Override
            public String successfulMessage(String param) {
                return param;
            }

            @Override
            public String failMessage() {
                return "Not Found";
            }

            @Override
            public void execute(String... args) {
                Integer slotNumber = parkingService.getSlotNumber(args[0]);
                if(slotNumber == -1)
                    System.out.println(failMessage());
                else
                    System.out.println(successfulMessage(String.valueOf(slotNumber)));

            }
        };

        ParkingLotCommand(String value) {
            this.value = value;
        }

        private String value;
        private static final ParkingService parkingService = new ParkingServiceImpl();

        public String getValue() {
            return value;
        }

        public Integer getArguments() {
            return 0;
        }

        public abstract String successfulMessage(String param);

        public abstract String failMessage();

        public abstract void execute(String... args);

        public static ParkingLotCommand getParkingLotCommand(String value){
            for(ParkingLotCommand parkingLotCommand:ParkingLotCommand.values()){
                if(parkingLotCommand.getValue().equalsIgnoreCase(value))
                    return parkingLotCommand;
            }
            return null;
        }
    }
}
