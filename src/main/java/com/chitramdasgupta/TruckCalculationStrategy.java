package com.chitramdasgupta;

public class TruckCalculationStrategy implements FeeCalculationStrategy {
    @Override
    public int calculateCost(int days) {
        return days * 200;
    }
}
