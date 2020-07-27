package pl.adamboguszewski.transactionservice.application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private final List<Product> products;

    private final double totalPrice;

    private final String transactionId;

    private final String checkoutId;

    private final LocalTime transactionTime;

    private final LocalDate transactionDate;

    public Transaction(List<Product> products, String transactionId,
                       long totalPrice, String checkoutId,
                       LocalTime transactionTime, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.products = new ArrayList<>();
        this.products.addAll(products);
        this.totalPrice = totalPrice;
        this.checkoutId = checkoutId;
        this.transactionTime = transactionTime;
        this.transactionDate = transactionDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

}
