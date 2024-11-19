package com.chitramdasgupta;

public interface Reservation {
    void makeReservation(VehicleType vehicleType, Customer customer);

    ReservationRecord getReservationRecord(VehicleType vehicleType, Customer customer);

    void cancelReservation(ReservationRecord reservationRecord);

    void returnVehicle(ReservationRecord reservationRecord);
}
