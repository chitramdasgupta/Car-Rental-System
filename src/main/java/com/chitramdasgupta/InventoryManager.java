package com.chitramdasgupta;

import java.util.List;

public class InventoryManager implements Inventory {
    private List<Vehicle> vehicles;

    @Override
    public void addVehicleType(VehicleType vehicleType) {
        Vehicle vehicle = VehicleFactory.createVehicle(vehicleType);
        vehicles.add(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public boolean containsVehicle(Vehicle vehicle) {
        return vehicles.contains(vehicle);
    }

    @Override
    public boolean containsVehicleType(VehicleType vehicleType) {
        return vehicles.stream().anyMatch(vehicle -> vehicle.getVehicleType() == vehicleType);
    }

    @Override
    public Vehicle getVehicle(VehicleType vehicleType) {
        return vehicles.stream().filter(vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.isAvailable())
                .findFirst().orElse(null);
    }
}
