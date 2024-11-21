package com.chitramdasgupta;

import java.util.ArrayList;

public class CarReservationSystem {
    private final InventoryManager inventoryManager;
    private final ReservationManager reservationManager;
    private final NotificationManager notificationManager;

    public CarReservationSystem(NotificationManager notificationManager) {
        this.inventoryManager = new InventoryManager();
        this.notificationManager = notificationManager;
        this.reservationManager = new ReservationManager(inventoryManager, notificationManager);
    }

    public void addCar(VehicleType vehicleType) {
        inventoryManager.addVehicleType(vehicleType);
    }

    public void removeCar(Vehicle vehicle) {
        inventoryManager.removeVehicle(vehicle);
    }

    public void makeReservation(VehicleType vehicleType, Customer customer) {
        reservationManager.makeReservation(vehicleType, customer, new ArrayList<>());
    }

    public void cancelReservation(VehicleType vehicleType, Customer customer) {
        ReservationRecord reservationRecord = reservationManager.getReservationRecord(vehicleType, customer);
        reservationManager.cancelReservation(reservationRecord);
    }

    public void returnVehicle(ReservationRecord reservationRecord) {
        reservationManager.returnVehicle(reservationRecord);
    }

    public void registerNotifier(Notifier notifier) {
        notificationManager.registerNotifier(notifier);
    }

    public void checkReservations() {
        reservationManager.checkForUpcomingEvents();
    }
}
