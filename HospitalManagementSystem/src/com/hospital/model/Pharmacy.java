package com.hospital.model;

public class Pharmacy {
    private String drugName;
    private int quantity;

    public Pharmacy(String drugName, int quantity) {
        this.drugName = drugName;
        this.quantity = quantity;
    }

    public String getDrugName() {
        return drugName;
    }

    public int getQuantity() {
        return quantity;
    }
}
