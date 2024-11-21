package com.chitramdasgupta;

public class EquipmentAddOn implements AddOn {
    private final String equipmentName;
    private final double cost;

    public EquipmentAddOn(String equipmentName, double cost) {
        this.equipmentName = equipmentName;
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String geDescription() {
        return equipmentName;
    }
}
