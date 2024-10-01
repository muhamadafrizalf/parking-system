package util;

import entity.LicensePlate;
import entity.Vehicle;

public class ValidationUtil {
    public LicensePlate validateLicensePlate(String strLicensePlate) {
        try {
            String[] licensePlateArr = strLicensePlate.split("-");
            return new LicensePlate(licensePlateArr[0], Integer.parseInt(licensePlateArr[1]), licensePlateArr[2]);
        } catch (Exception e) {
            throw new RuntimeException("Invalid license plate format.");
        }
    }
}
