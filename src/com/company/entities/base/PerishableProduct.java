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
    public double calculateDiscount(LocalDateTime dateTimeOfOrder) {

        LocalDate startDate = expirationDate.minusDays(5);
        LocalDate dateOfOrder = dateTimeOfOrder.toLocalDate();

        if (!dateOfOrder.isBefore(startDate) && dateOfOrder.isBefore(expirationDate)) {
            return this.getPrice() * 0.1;
        } else if (dateOfOrder.equals(expirationDate)) {
            return this.getPrice() * 0.5;
        }
        return 0;
    }
}
