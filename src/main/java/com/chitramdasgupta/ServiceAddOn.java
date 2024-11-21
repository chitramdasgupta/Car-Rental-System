package com.chitramdasgupta;

public class ServiceAddOn implements AddOn {
    private final String serviceName;
    private final double cost;

    public ServiceAddOn(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String geDescription() {
        return serviceName;
    }
}
