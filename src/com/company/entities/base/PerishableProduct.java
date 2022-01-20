package com.company.entities.base;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class PerishableProduct extends Product {

    private LocalDate expirationDate;

    public PerishableProduct(String name, String brand, double price, LocalDate expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public PerishableProduct setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    @Override
    public double getDiscountPercent(double price, LocalDateTime dateTimeOfOrder) {

        LocalDate startDate = expirationDate.minusDays(5);
        LocalDate dateOfOrder = dateTimeOfOrder.toLocalDate();

        if (!dateOfOrder.isBefore(startDate) && dateOfOrder.isBefore(expirationDate)) {
            return 0.1;
        } else if (dateOfOrder.equals(expirationDate)) {
            return 0.5;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getBrand();
    }
}
