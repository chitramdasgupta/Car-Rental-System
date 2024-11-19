package com.chitramdasgupta;

public class CarFeeCalculationStrategy implements FeeCalculationStrategy {
    @Override
    public int calculateCost(int days) {
        return days * 100;
    }
}
