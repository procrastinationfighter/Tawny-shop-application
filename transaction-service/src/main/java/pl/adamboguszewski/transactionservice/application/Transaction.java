package pl.adamboguszewski.transactionservice.application;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// [TODO]: Lombok
public class Transaction {

    private final List<Product> products;

    private final Long totalPrice;

    private final Long id;

    private final UUID transactionId;

    private final String checkoutId;

    private final TransactionInfo transactionInfo;

    public Transaction(List<Product> products, Long id, UUID transactionId,
                       Long totalPrice, String checkoutId, TransactionInfo transactionInfo) {
        // [TODO]: If product has a list with objects like this transaction, this will cause problems.
        this.id = id;
        this.products = new ArrayList<>();
        this.products.addAll(products);
        this.transactionId = transactionId;
        this.totalPrice = totalPrice;
        this.checkoutId = checkoutId;
        this.transactionInfo = transactionInfo;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public Long getId() {
        return id;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public TransactionInfo getTransactionInfo() {
        return transactionInfo;
    }
}
