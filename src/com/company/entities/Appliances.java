package com.company.entities;

import com.company.entities.base.Product;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Override
    public double getDiscountPercent(double price, LocalDateTime dateTimeOfOrder) {
        if (price > 999 &&
                (dateTimeOfOrder.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                        || dateTimeOfOrder.getDayOfWeek().equals(DayOfWeek.SUNDAY))) {
            return 0.05;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getBrand() + " " + this.getModel();
    }
}