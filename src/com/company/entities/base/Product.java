package com.company.entities.base;

public abstract class Product {

    private String name;
    private String brand;
    private double price;

    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }
}
