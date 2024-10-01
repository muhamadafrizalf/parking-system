package controller;

import service.ParkingService;
import util.InputUtil;

import java.util.List;

public class ParkingController {
    private final InputUtil inputUtil = new InputUtil();
    private final ParkingService parkingService = new ParkingService();

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println();
            List<String> input = inputUtil.commandInput();
            switch (input.get(0)) {
                case "create_parking_lot" -> {
                    parkingService.createParkingLot(input.subList(1, input.size()));
                }
                case "park" -> {
                    parkingService.park(input.subList(1, input.size()));
                }
                case "leave" -> {
                    parkingService.leave(input.subList(1, input.size()));
                }
                case "status" -> {
                    parkingService.status();
                }
                case "type_of_vehicles" -> {
                    parkingService.typeOfVehicles(input.subList(1, input.size()));
                }
                case "registration_numbers_for_vehicles_with_odd_plate" -> {
                    parkingService.getOddLicensePlate();
                }
                case "registration_numbers_for_vehicles_with_even_plate" -> {
                    parkingService.getEvenLicensePlate();
                }
                case "registration_numbers_for_vehicles_with_color" -> {
                    parkingService.getLicensePlateByColor(input.subList(1, input.size()));
                }
                case "slot_numbers_for_vehicles_with_color" -> {
                    parkingService.getSlotNumberByColor(input.subList(1, input.size()));
                }
                case "slot_number_for_registration_number" -> {
                    parkingService.getSlotNumberByLicensePlate(input.subList(1, input.size()));
                }
                case "help" -> {
                    help();
                }
                case "exit" -> {
                    exit = true;
                }
                default -> {
                    System.out.println("Wrong command, try again!");
                }
            }
        }
    }

    private void help() {
        System.out.println("List of commands (without square brackets)");
        System.out.println("=======================================================================================================================================");
        System.out.println("create_parking_lot [6]                              -> to create parking lot with [6] slots");
        System.out.println("park [XX-1234-ZZ] [White] [Car]                     -> to park [White] [Car] with license plate [XX-1234-ZZ]");
        System.out.println("leave [1]                                           -> to empty parking lot slot [1]");
        System.out.println("status                                              -> to check status of parking lot");
        System.out.println("type_of_vehicles [Car]                              -> to count [Car] type vehicle in parking lot");
        System.out.println("registration_numbers_for_vehicles_with_odd_plate    -> to show license plate with odd number in parking lot");
        System.out.println("registration_numbers_for_vehicles_with_even_plate   -> to show license plate with even number in parking lot");
        System.out.println("registration_numbers_for_vehicles_with_color [Red]  -> to show license plate of [Red] color vehicle in parking lot");
        System.out.println("slot_numbers_for_vehicles_with_color [Red]          -> to show slot number of [Red] color vehicle in parking lot");
        System.out.println("slot_number_for_registration_number [XX-1234-ZZ]    -> to show slot number of vehicle with license plate [XX-1234-ZZ] in parking lot");
        System.out.println("exit                                                -> to exit the program");
    }
}
