package com.chitramdasgupta;

public class InsuranceAddOn implements AddOn {
    private final double cost = 20.0;

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String geDescription() {
        return "Rental insurance";
    }
}
