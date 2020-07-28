package pl.adamboguszewski.transactionservice.application;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Value
public class Transaction {

    List<TransactionProduct> products;

    Long totalPrice;

    Long id;

    UUID transactionId;

    UUID checkoutId;

    TransactionInfo transactionInfo;

    public Transaction(List<TransactionProduct> products, Long id, UUID transactionId,
                       Long totalPrice, UUID checkoutId, TransactionInfo transactionInfo) {
        // [TODO]: If product has a list with objects like this transaction, this will cause problems.
        this.id = id;
        this.products = new ArrayList<>();
        this.products.addAll(products);
        this.transactionId = transactionId;
        this.totalPrice = totalPrice;
        this.checkoutId = checkoutId;
        this.transactionInfo = transactionInfo;
    }

}
