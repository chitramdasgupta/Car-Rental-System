package com.chitramdasgupta;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ReservationManager implements Reservation {
    private final List<ReservationRecord> reservations;
    private final InventoryManager inventoryManager;
    private final ReservationHistoryManager reservationHistoryManager;
    private final FeeManager feeManager;
    private final NotificationManager notificationManager;

    public ReservationManager(InventoryManager inventoryManager, NotificationManager notificationManager) {
        this.reservations = new ArrayList<>();
        this.inventoryManager = inventoryManager;
        this.reservationHistoryManager = ReservationHistoryManager.getInstance();
        this.feeManager = new FeeManager();
        this.notificationManager = notificationManager;
    }

    @Override
    public void makeReservation(VehicleType vehicleType, Customer customer, List<AddOn> addOns) {
        Vehicle vehicle = inventoryManager.getVehicle(vehicleType);
        ReservationRecord reservationRecord = new ReservationRecord(LocalDate.now(), LocalDate.now().plusDays(7), customer, vehicle);

        for (AddOn addOn : addOns) {
            reservationRecord.addAddOn(addOn);
        }

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
        reservationRecord.getVehicle().setAvailable(true);
        reservations.remove(reservationRecord);
        reservationHistoryManager.completeReservationRecord(reservationRecord);

        double totalFees = feeManager.getTotalCost(reservationRecord) +
                reservationRecord.getAddOns().stream().mapToDouble(AddOn::getCost).sum();

        System.out.println("The total fees including add-ons is " + totalFees);
    }

    public void checkForUpcomingEvents() {
        for (ReservationRecord record : reservations) {
            long daysUntilPickUp = ChronoUnit.DAYS.between(LocalDate.now(), record.getDueDate());
            if (daysUntilPickUp == 1) {
                notificationManager.notifyObservers("Reminder: Your reservation for " +
                        record.getVehicle().getVehicleType() + " is tomorrow!");
            }

            long daysUntilDue = ChronoUnit.DAYS.between(LocalDate.now(), record.getDueDate());
            if (daysUntilDue == 1) {
                notificationManager.notifyObservers("Reminder: Your reservation for " +
                        record.getVehicle().getVehicleType() + " is due tomorrow!");
            } else if (daysUntilDue < 0) {
                notificationManager.notifyObservers("Alert: Your reservation for " +
                        record.getVehicle().getVehicleType() + " is overdue!");
            }
        }
    }
}
