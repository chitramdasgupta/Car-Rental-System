package com.chitramdasgupta;

public enum VehicleType {
    CAR(new CarFeeCalculationStrategy()),
    TRUCK(new TruckCalculationStrategy()),
    VAN(new VanFeeCalculationStrategy());

    private final FeeCalculationStrategy strategy;

    VehicleType(FeeCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public FeeCalculationStrategy getStrategy() {
        return strategy;
    }
}
