package com.chitramdasgupta;

import java.util.List;

public class ReservationHistoryManager implements ReservationHistory {
    private static ReservationHistoryManager instance = null;
    List<ReservationRecord> history;

    public static ReservationHistoryManager getInstance() {
        if (instance == null) {
            instance = new ReservationHistoryManager();
        }

        return instance;
    }

    @Override
    public void addReservationRecord(ReservationRecord reservationRecord) {
        history.add(reservationRecord);
    }

    @Override
    public List<ReservationRecord> getReservationRecordsByCustomer(Customer customer) {
        return history.stream().filter(record -> record.getCustomer().equals(customer)).toList();
    }

    @Override
    public List<ReservationRecord> getReservationRecordsByVehicle(Vehicle vehicle) {
        return history.stream().filter(record -> record.getVehicle().equals(vehicle)).toList();
    }

    @Override
    public void completeReservationRecord(ReservationRecord reservationRecord) {
        reservationRecord.setReservationStatus(ReservationStatus.COMPLETED);
    }

    @Override
    public void cancelReservation(ReservationRecord reservationRecord) {
        reservationRecord.setReservationStatus(ReservationStatus.CANCELLED);
    }
}
