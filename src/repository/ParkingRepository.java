package repository;

import entity.LicensePlate;
import entity.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingRepository {
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    private int slots = 0;

    public ParkingRepository(List<ParkingLot> parkingLots, int slots) {
        this.parkingLots = parkingLots;
        this.slots = slots;
    }

    public ParkingRepository() {
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public ParkingLot findBySlotAndActive(int slot) {
        if (slot < 1 && slot > slots) {
            throw new IllegalArgumentException("Slot must be between 1 and " + slots);
        }
        ParkingLot findParkingLot = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getSlot() == slot && parkingLot.getIsActive()) {
                findParkingLot = parkingLot;
                break;
            }
        }
        return findParkingLot;
    }

    public int countAvailableSlots() {
        int count = 0;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getIsActive()) {
                count++;
            }
        }
        return slots - count;
    }

    public void create(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public void update(ParkingLot parkingLot) {
        for (int i = 0; i < parkingLots.size(); i++) {
            if (parkingLots.get(i).equals(parkingLot)) {
                parkingLots.set(i, parkingLot);
            }
        }
    }

    public int countByTypeAndActive(String type) {
        int count = 0;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getIsActive() && parkingLot.getVehicle().getType().equals(type)) {
                count++;
            }
        }
        return count;
    }

    public List<LicensePlate> getOddLicenseAndActive() {
        List<LicensePlate> licensePlates = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getIsActive() && parkingLot.getVehicle().getLicensePlate().getPoliceNumber() % 2 == 1) {
                licensePlates.add(parkingLot.getVehicle().getLicensePlate());
            }
        }
        return licensePlates;
    }

    public List<LicensePlate> getEvenLicenseAndActive() {
        List<LicensePlate> licensePlates = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getIsActive() && parkingLot.getVehicle().getLicensePlate().getPoliceNumber() % 2 == 0) {
                licensePlates.add(parkingLot.getVehicle().getLicensePlate());
            }
        }
        return licensePlates;
    }

    public List<Integer> getSlotNumberByColorAndActive(String color) {
        List<Integer> slotList = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getIsActive() && parkingLot.getVehicle().getColor().equals(color)) {
                slotList.add(parkingLot.getSlot());
            }
        }
        return slotList;
    }

    public List<LicensePlate> getLicenseByColorAndActive(String color) {
        List<LicensePlate> licensePlates = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getIsActive() && parkingLot.getVehicle().getColor().equals(color)) {
                licensePlates.add(parkingLot.getVehicle().getLicensePlate());
            }
        }
        return licensePlates;
    }

    public int getSlotNumberByLicensePlateAndActive(LicensePlate licensePlate) {
        int slotNumber = 0;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getIsActive() && parkingLot.getVehicle().getLicensePlate().equals(licensePlate)) {
                slotNumber = parkingLot.getSlot();
            }
        }
        return slotNumber;
    }
}
