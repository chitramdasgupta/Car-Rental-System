package com.chitramdasgupta;

import java.time.temporal.ChronoUnit;

public class FeeManager {
    public int getTotalCost(ReservationRecord reservationRecord) {
        int days = (int) ChronoUnit.DAYS.between(reservationRecord.getIssueDate(), reservationRecord.getDueDate());

        FeeCalculationStrategy strategy = reservationRecord.getVehicle().getVehicleType().getStrategy();

        return strategy.calculateCost(days);
    }
}

