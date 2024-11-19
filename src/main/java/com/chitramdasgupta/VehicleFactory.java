package com.chitramdasgupta;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType) {
        return switch (vehicleType) {
            case CAR -> new Car();
            case TRUCK -> new Truck();
            case VAN -> new Van();
        };
    }
}
