package com.google.android.gms.samples.vision.ocrreader.ui.camera;

public class GasStation {

    double minPrice;
    String stationName;
    String geolocation;

    public GasStation(double minPrice, String stationName, String geolocation) {
        this.minPrice = minPrice;
        this.stationName = stationName;
        this.geolocation = geolocation;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "minPrice=" + minPrice +
                ", stationName='" + stationName + '\'' +
                ", geolocation='" + geolocation + '\'' +
                '}';
    }
}

