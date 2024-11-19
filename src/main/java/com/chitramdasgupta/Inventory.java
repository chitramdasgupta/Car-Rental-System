package com.chitramdasgupta;

import java.util.List;

public interface Inventory {
    void addVehicleType(VehicleType vehicle)Type;

    void removeVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    boolean containsVehicle(Vehicle vehicle);

    boolean containsVehicleType(VehicleType vehicleType);

    Vehicle getVehicle(VehicleType vehicle);
}
