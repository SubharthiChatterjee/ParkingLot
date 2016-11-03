package com.parkinglot;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by subharthi on 11/2/16.
 */
public class ParkingLotManager {

    private static final String INPUT_FILE = "input.txt";

    public static void main(String[] args) {
        InputStream is = ParkingLotManager.class.getClassLoader().getResourceAsStream(INPUT_FILE);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;
        try {
            while ((line = br.readLine()) != null) {
                if (line.equals(""))
                    continue;
                String[] command = line.split(" ");
                ParkingLotConstants.ParkingLotCommand parkingLotCommand = ParkingLotConstants.ParkingLotCommand
                        .getParkingLotCommand(command[0]);
                if (parkingLotCommand == null) {
                    System.out.println("Unrecognized Command!");
                    continue;
                }
                List<String> parkingLotCommandArgs = new ArrayList<>();
                for (int index = 1; index <= parkingLotCommand.getArguments(); index++)
                    parkingLotCommandArgs.add(command[index]);
                parkingLotCommand.execute(parkingLotCommandArgs.toArray(new String[parkingLotCommandArgs.size()]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
