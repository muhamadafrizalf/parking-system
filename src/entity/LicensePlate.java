package entity;

import java.util.Objects;

public class LicensePlate {
    private String regionCode;
    private int policeNumber;
    private String seriesCode;

    public LicensePlate(String regionCode, int policeNumber, String seriesCode) {
        this.regionCode = regionCode;
        this.policeNumber = policeNumber;
        this.seriesCode = seriesCode;
    }

    public LicensePlate() {
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public int getPoliceNumber() {
        return policeNumber;
    }

    public void setPoliceNumber(int policeNumber) {
        this.policeNumber = policeNumber;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicensePlate that = (LicensePlate) o;
        return policeNumber == that.policeNumber && Objects.equals(regionCode, that.regionCode) && Objects.equals(seriesCode, that.seriesCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionCode, policeNumber, seriesCode);
    }

    @Override
    public String toString() {
        return regionCode + '-' + policeNumber + '-' + seriesCode;
    }
}
