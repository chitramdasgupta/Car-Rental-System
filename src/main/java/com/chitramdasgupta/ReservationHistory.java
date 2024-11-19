package com.chitramdasgupta;

import java.util.List;

public interface ReservationHistory {
    void addReservationRecord(ReservationRecord reservationRecord);

    List<ReservationRecord> getReservationRecordsByCustomer(Customer customer);

    List<ReservationRecord> getReservationRecordsByVehicle(Vehicle vehicle);

    void completeReservationRecord(ReservationRecord reservationRecord);

    void cancelReservation(ReservationRecord record);
}
