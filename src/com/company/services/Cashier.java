package com.company.services;

import com.company.entities.base.Product;

import java.time.LocalDateTime;
import java.util.List;

public class Cashier {

    private double subtotal;
    private double totalDiscount;

    public void printReceipt(List<CartItem> items, LocalDateTime dateTimeOfPurchase) {
        StringBuilder sb = new StringBuilder();
        sb.append("Date: ").append(dateTimeOfPurchase).append("\n");
        sb.append("---Products---" + "\n\n");

        for (CartItem item:items) {
            Product product = item.getProduct();
            double pricePerItem = product.getPrice();
            double totalItemPrice = pricePerItem * item.getQuantity();
            subtotal += totalItemPrice;

            sb.append(item.getProduct() + "\n");
            sb.append(item.getQuantity() + " x " + pricePerItem + " = " + totalItemPrice);

            calculateDiscount(dateTimeOfPurchase, sb, product, totalItemPrice);
            sb.append("\n\n");
        }
        sb.append("--------------------------------------------------");
        sb.append("\nSUBTOTAL: $" + subtotal);
        sb.append("\nDISCOUNT: -$" + totalDiscount);
        sb.append("\nTOTAL: $" + (subtotal-totalDiscount));

        System.out.println(sb);
    }

    private void calculateDiscount(LocalDateTime dateTimeOfPurchase, StringBuilder sb, Product product, double totalItemPrice) {
        double discountPercent = product.getDiscountPercent(totalItemPrice, dateTimeOfPurchase);
        if (discountPercent != 0) {
            double discount = totalItemPrice * discountPercent;
            totalDiscount += discount;
            sb.append("\n#discount " + (discountPercent * 100) + "%" + " - " + "$" + discount);
        }
    }
}
