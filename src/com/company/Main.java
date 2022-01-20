package com.company;

import com.company.entities.Appliances;
import com.company.entities.Beverage;
import com.company.entities.Clothes;
import com.company.entities.Food;
import com.company.entities.base.Product;
import com.company.enums.Size;
import com.company.services.CartItem;
import com.company.services.Cashier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Cashier cashier = new Cashier();
        Product apple = new Food("apple", "BrandA",
                1.50, LocalDate.of(2021,6,14));
        Product milk = new Beverage("milk", "BrandM", 0.99,
                LocalDate.of(2022,2,2));
        Product tShirt = new Clothes("T-shirt", "BrandT", 15.99, Size.M, "violet");
        Product laptop = new Appliances("laptop", "BrandL", 2345, "ModelL",
                LocalDate.of(2021,3,3), 1.125);

        List<CartItem> items = new ArrayList<>();
        items.add(new CartItem(apple, 2.45));
        items.add(new CartItem(milk, 3));
        items.add(new CartItem(tShirt, 2));
        items.add(new CartItem(laptop, 1));

        cashier.printReceipt(items, LocalDateTime.of(2021,6,14,12,34,56));
    }
}
