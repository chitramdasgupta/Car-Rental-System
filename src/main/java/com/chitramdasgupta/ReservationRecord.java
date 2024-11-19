package com.chitramdasgupta;

import java.time.LocalDate;

public class ReservationRecord {
    private final LocalDate issueDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;
    private final Customer customer;
    private final Vehicle vehicle;
    private ReservationStatus reservationStatus;

    public ReservationRecord(LocalDate issueDate, LocalDate dueDate, Customer customer, Vehicle vehicle) {
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.customer = customer;
        this.vehicle = vehicle;
        this.reservationStatus = ReservationStatus.ISSUED;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
