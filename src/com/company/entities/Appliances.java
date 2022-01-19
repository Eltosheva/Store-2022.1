package com.company.entities;

import com.company.entities.base.Product;

import java.time.LocalDate;

public class Appliances extends Product {

    private String model;
    private LocalDate productionDate;
    private double weight;

    public Appliances(String name, String brand, double price, String model, LocalDate productionDate, double weight) {
        super(name, brand, price);
        this.model = model;
        this.productionDate = productionDate;
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public Appliances setModel(String model) {
        this.model = model;
        return this;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public Appliances setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public Appliances setWeight(double weight) {
        this.weight = weight;
        return this;
    }
}