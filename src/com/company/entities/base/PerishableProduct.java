package com.company.entities.base;

import java.time.LocalDate;

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
}
