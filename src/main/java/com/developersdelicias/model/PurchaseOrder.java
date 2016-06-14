package com.developersdelicias.model;

public class PurchaseOrder {
    private double acquisitionCost;
    private int quantityPerPackage;

    public PurchaseOrder(double acquisitionCost, int quantity) {
        this.acquisitionCost = acquisitionCost;
        this.quantityPerPackage = quantity;
    }

    public void setAcquisitionCost(double acquisitionCost) {
        this.acquisitionCost = acquisitionCost;
    }

    public void setQuantityPerPackage(int quantityPerPackage) {
        this.quantityPerPackage = quantityPerPackage;
    }

    public double getAcquisitionCost() {
        return acquisitionCost;
    }

    public int getQuantityPerPackage() {
        return quantityPerPackage;
    }

    public double getUnitCost() {
        return acquisitionCost / quantityPerPackage;
    }
}
