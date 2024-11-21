package com.chitramdasgupta;

import java.util.List;

public interface Reservation {
    void makeReservation(VehicleType vehicleType, Customer customer, List<AddOn> addOns);

    ReservationRecord getReservationRecord(VehicleType vehicleType, Customer customer);

    void cancelReservation(ReservationRecord reservationRecord);

    void returnVehicle(ReservationRecord reservationRecord);
}
