package service;

import entity.LicensePlate;
import entity.ParkingLot;
import entity.Vehicle;
import repository.ParkingRepository;
import util.ValidationUtil;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingService {
    private final ParkingRepository parkingRepository = new ParkingRepository();
    private final ValidationUtil validationUtil = new ValidationUtil();

    private void isParkingLotReady() {
        if (parkingRepository.getSlots() == 0) {
            throw new RuntimeException("Please create a parking lot first!");
        }
    }

    private void isParkingLotAvailable() {
        if (parkingRepository.countAvailableSlots() == 0) {
            throw new RuntimeException("Sorry, parking lot is full.");
        }
    }


    public void createParkingLot(List<String> input) {
        try {
            int slot = Integer.parseInt(input.get(0));
            if (slot < 1) {
                throw new RuntimeException("Slots number can only contains positive integers.");
            }
            parkingRepository.setSlots(slot);
            System.out.println("Created a parking lot with " + parkingRepository.getSlots() + " slots.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Please enter a valid slots number!");
        }
    }

    public void park(List<String> input) {
        try {
            isParkingLotReady();
            isParkingLotAvailable();
            for (int i = 1; i <= parkingRepository.getSlots(); i++) {
                if (parkingRepository.findBySlotAndActive(i) == null) {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setSlot(i);
                    LicensePlate licensePlate = validationUtil.validateLicensePlate(input.get(0));
                    Vehicle vehicle = new Vehicle(licensePlate, input.get(1), input.get(2));
                    parkingLot.setVehicle(vehicle);
                    parkingLot.setIsActive(true);
                    parkingLot.setArrivalTime(LocalDateTime.now());

                    parkingRepository.create(parkingLot);
                    System.out.println("Allocated slot number: " + parkingLot.getSlot());
                    break;
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void leave(List<String> input) {
        try {
            isParkingLotReady();
            int slot = Integer.parseInt(input.get(0));
            ParkingLot parkingLot = parkingRepository.findBySlotAndActive(slot);
            parkingLot.setIsActive(false);
            parkingLot.setDepartureTime(LocalDateTime.now());

            parkingRepository.update(parkingLot);
            System.out.println("Slot number " + slot + " is free");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Please enter a valid slot number!");
        }
    }

    public void status() {
        try {
            isParkingLotReady();
            System.out.println("Slot\tLicense Plate\tType\tColor");
            for (int i = 1; i <= parkingRepository.getSlots(); i++) {
                ParkingLot parkingLot = parkingRepository.findBySlotAndActive(i);
                if (parkingLot != null) {
                    System.out.println(i + "\t\t" + parkingLot.getVehicle().getLicensePlate() + "\t" + parkingLot.getVehicle().getType() + "\t" + parkingLot.getVehicle().getColor());
                } else {
                    System.out.println(i + "\t\t" + "Empty parking lot");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void typeOfVehicles(List<String> input) {
        try {
            isParkingLotReady();
            String type = input.get(0);
            int count = parkingRepository.countByTypeAndActive(type);
            System.out.println("There are " + count + " " + type + " in parking lot.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getOddLicensePlate() {
        try {
            isParkingLotReady();
            List<LicensePlate> licensePlateList = parkingRepository.getOddLicenseAndActive();
            for (LicensePlate license : licensePlateList) {
                System.out.print(license + ", ");
            }
            System.out.println();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getEvenLicensePlate() {
        try {
            isParkingLotReady();
            List<LicensePlate> licensePlateList = parkingRepository.getEvenLicenseAndActive();
            for (LicensePlate license : licensePlateList) {
                System.out.print(license + ", ");
            }
            System.out.println();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getSlotNumberByColor(List<String> input) {
        try {
            isParkingLotReady();
            String color = input.get(0);
            List<Integer> slotList = parkingRepository.getSlotNumberByColorAndActive(color);
            if (!slotList.isEmpty()) {
                for (Integer slot : slotList) {
                    System.out.print(slot + ", ");
                }
            } else {
                System.out.println("Not found");
            }
            System.out.println();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getLicensePlateByColor(List<String> input) {
        try {
            isParkingLotReady();
            String color = input.get(0);
            List<LicensePlate> licensePlateList = parkingRepository.getLicenseByColorAndActive(color);
            if (!licensePlateList.isEmpty()) {
                for (LicensePlate license : licensePlateList) {
                    System.out.print(license + ", ");
                }
            } else {
                System.out.println("Not found");
            }
            System.out.println();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getSlotNumberByLicensePlate(List<String> input) {
        try {
            isParkingLotReady();
            LicensePlate licensePlate = validationUtil.validateLicensePlate(input.get(0));
            int slot = parkingRepository.getSlotNumberByLicensePlateAndActive(licensePlate);
            if (slot != 0) {
                System.out.println(slot);
            } else {
                System.out.println("Not found");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
