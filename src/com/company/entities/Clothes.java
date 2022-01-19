package com.company.entities;

import com.company.entities.base.Product;
import com.company.enums.Size;

public class Clothes extends Product {

    private Size size;
    private String color;

    public Clothes(String name, String brand, double price, Size size, String color) {
        super(name, brand, price);
        this.size = size;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public Clothes setSize(Size size) {
        this.size = size;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Clothes setColor(String color) {
        this.color = color;
        return this;
    }
}
