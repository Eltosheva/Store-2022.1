package com.company.entities;

import com.company.entities.base.PerishableProduct;

import java.time.LocalDate;

public class Food extends PerishableProduct {
    public Food(String name, String brand, double price, LocalDate expirationDate) {
        super(name, brand, price, expirationDate);
    }
}
