package com.chitramdasgupta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationRecord {
    private final LocalDate issueDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;
    private final Customer customer;
    private final Vehicle vehicle;
    private ReservationStatus reservationStatus;
    private final List<AddOn> addOns;

    public ReservationRecord(LocalDate issueDate, LocalDate dueDate, Customer customer, Vehicle vehicle) {
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.customer = customer;
        this.vehicle = vehicle;
        this.reservationStatus = ReservationStatus.ISSUED;
        addOns = new ArrayList<>();
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

    public void addAddOn(AddOn addOn) {
        addOns.add(addOn);
    }

    public List<AddOn> getAddOns() {
        return addOns;
    }
}
