package com.chitramdasgupta;

public class VanFeeCalculationStrategy implements FeeCalculationStrategy {
    @Override
    public int calculateCost(int days) {
        return days * 250;
    }
}
