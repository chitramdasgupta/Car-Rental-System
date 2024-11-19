package com.chitramdasgupta;

public class CarReservationSystem {
    private final InventoryManager inventoryManager;
    private final ReservationManager reservationManager;

    public CarReservationSystem() {
        this.inventoryManager = new InventoryManager();
        this.reservationManager = new ReservationManager(inventoryManager);
    }

    public void addCar(VehicleType vehicleType) {
        inventoryManager.addVehicleType(vehicleType);
    }

    public void removeCar(Vehicle vehicle) {
        inventoryManager.removeVehicle(vehicle);
    }

    public void makeReservation(VehicleType vehicleType, Customer customer) {
        reservationManager.makeReservation(vehicleType, customer);
    }

    public void cancelReservation(VehicleType vehicleType, Customer customer) {
        ReservationRecord reservationRecord = reservationManager.getReservationRecord(vehicleType, customer);
        reservationManager.cancelReservation(reservationRecord);
    }

    public void returnVehicle(ReservationRecord reservationRecord) {
        reservationManager.returnVehicle(reservationRecord);
    }
}
