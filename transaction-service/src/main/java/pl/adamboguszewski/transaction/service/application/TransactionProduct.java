package pl.adamboguszewski.transaction.service.application;

import java.util.UUID;

import lombok.Value;
import pl.adamboguszewski.transaction.service.service.api.transaction.CreateTransactionRequest;

@Value
public class TransactionProduct {

    Long id;

    UUID productId;

    Long priceMultiplier;

    Long quantity;

    Long totalPrice;

    String productName;

    String description;

    String category;

    public TransactionProduct(CreateTransactionRequest.TransactionProduct request) {
        // [TODO] Temporary solution for assigning id.
        this.id = -1L;
        this.productId = request.getProductId();
        this.priceMultiplier = request.getPriceMultiplier();
        this.quantity = request.getQuantity();
        this.totalPrice = request.getTotalPrice();
        this.productName = request.getProductName();
        this.description = request.getDescription();
        this.category = request.getCategory();
    }
}
