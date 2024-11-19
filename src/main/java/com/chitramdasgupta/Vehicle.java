package com.chitramdasgupta;

public abstract class Vehicle {
    private String barcode;
    private int parkingSpotNumber;
    private VehicleType vehicleType;
    private boolean isAvailable;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
