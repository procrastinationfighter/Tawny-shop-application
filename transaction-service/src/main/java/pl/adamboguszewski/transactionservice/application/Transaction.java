package pl.adamboguszewski.transactionservice.application;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private final List<Product> products;

    private double totalPrice;

    private final String id;

    public Transaction(List<Product> products, String id) {
        this.id = id;
        this.products = new ArrayList<>();
        for(Product product : products) {
            this.products.add(product);
            totalPrice += product.getPriceMultiplier();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getId() {
        return id;
    }

}
