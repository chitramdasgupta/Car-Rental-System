package com.chitramdasgupta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationManager implements Reservation {
    private final List<ReservationRecord> reservations;
    private final InventoryManager inventoryManager;
    private final ReservationHistoryManager reservationHistoryManager;
    private final FeeManager feeManager;

    public ReservationManager(InventoryManager inventoryManager) {
        this.reservations = new ArrayList<>();
        this.inventoryManager = inventoryManager;
        this.reservationHistoryManager = ReservationHistoryManager.getInstance();
        this.feeManager = new FeeManager();
    }

    @Override
    public void makeReservation(VehicleType vehicleType, Customer customer) {
        Vehicle vehicle = inventoryManager.getVehicle(vehicleType);
        ReservationRecord reservationRecord = new ReservationRecord(LocalDate.now(), LocalDate.now(), customer, vehicle);

        vehicle.setAvailable(false);
        reservations.add(reservationRecord);
        reservationHistoryManager.addReservationRecord(reservationRecord);
    }

    @Override
    public ReservationRecord getReservationRecord(VehicleType vehicleType, Customer customer) {
        return reservations.stream()
                .filter(record -> record.getCustomer()
                        .equals(customer) && record.getVehicle().getVehicleType().equals(vehicleType))
                .findFirst().orElse(null);
    }

    @Override
    public void cancelReservation(ReservationRecord reservationRecord) {
        ReservationRecord record = this.getReservationRecord(reservationRecord.getVehicle().getVehicleType(),
                reservationRecord.getCustomer());
        record.getVehicle().setAvailable(true);
        reservations.remove(reservationRecord);
        reservationHistoryManager.cancelReservation(record);
    }

    @Override
    public void returnVehicle(ReservationRecord reservationRecord) {
        reservationRecord.getVehicle().setAvailable(false);
        reservations.remove(reservationRecord);
        reservationHistoryManager.completeReservationRecord(reservationRecord);

        int fees = feeManager.getTotalCost(reservationRecord);

        System.out.println("The total fees is " + fees);
    }
}
