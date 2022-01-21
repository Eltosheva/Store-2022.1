package com.company.services;

import com.company.entities.base.Product;
import com.company.model.CartItem;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

public class CashierService {

    private double subtotal;
    private double totalDiscount;

    public void printReceipt(List<CartItem> items, LocalDateTime dateTimeOfPurchase) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");

        sb.append("Date: ").append(dateTimeOfPurchase).replace(16,17," ").append("\n");
        sb.append("---Products---" + "\n\n");

        for (CartItem item : items) {
            Product product = item.getProduct();
            double pricePerItem = product.getPrice();
            double totalItemPrice = pricePerItem * item.getQuantity();
            subtotal += totalItemPrice;

            sb.append(item.getProduct() + "\n");
            sb.append(item.getQuantity() + " x $" + df.format(pricePerItem) + " = $" + df.format(totalItemPrice));

            calculateDiscount(dateTimeOfPurchase, sb, product, totalItemPrice);
            sb.append("\n\n");
        }
        sb.append("------------------------------------------");
        sb.append("\nSUBTOTAL: $" + df.format(subtotal));
        sb.append("\nDISCOUNT: -$" + df.format(totalDiscount));
        sb.append("\nTOTAL: $" + df.format(subtotal - totalDiscount));

        System.out.println(sb);
    }

    private void calculateDiscount(LocalDateTime dateTimeOfPurchase, StringBuilder sb, Product product, double totalItemPrice) {
        double discountPercent = product.getDiscountPercent(totalItemPrice, dateTimeOfPurchase);
        DecimalFormat dfTwoSymbols = new DecimalFormat("#.##");
        DecimalFormat df = new DecimalFormat("#");
        if (discountPercent != 0) {
            double discount = totalItemPrice * discountPercent;
            totalDiscount += discount;
            sb.append("\n#discount " + df.format(discountPercent * 100) + "%" + " -" + "$" + dfTwoSymbols.format(discount));
        }
    }
}
