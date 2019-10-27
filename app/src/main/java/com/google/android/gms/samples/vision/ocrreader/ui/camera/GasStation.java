package com.google.android.gms.samples.vision.ocrreader.ui.camera;

public class GasStation {

    double regPrice;
    double diesalPrice;

    String stationName;
    double longitude;
    double latitude;

    @Override
    public String toString() {
        return "GasStation{" +
                "regPrice=" + regPrice +
                ", diesalPrice=" + diesalPrice +
                ", stationName='" + stationName + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public GasStation(double regPrice, double diesalPrice, String stationName, double longitude, double latitude) {
        this.regPrice = regPrice;
        this.diesalPrice = diesalPrice;
        this.stationName = stationName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getRegPrice() {
        return regPrice;
    }

    public void setRegPrice(double regPrice) {
        this.regPrice = regPrice;
    }

    public double getDiesalPrice() {
        return diesalPrice;
    }

    public void setDiesalPrice(double diesalPrice) {
        this.diesalPrice = diesalPrice;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}

