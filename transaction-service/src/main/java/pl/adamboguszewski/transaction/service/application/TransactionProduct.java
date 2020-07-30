package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.service.api.transaction.CreateTransactionRequest;

import java.util.UUID;

@Value
public class TransactionProduct {

    Long id;

    UUID productId;
    String productName;

    Long price;
    Long quantity;
    Long priceMultiplier;
    String description;
    String category;

    private TransactionProduct(UUID productId, String productName, Long price, Long quantity, Long priceMultiplier, String description, String category) {
        // [TODO] Temporary solution for assigning id.
        this.id = -1L;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.priceMultiplier = priceMultiplier;
        this.description = description;
        this.category = category;
    }

    public static TransactionProduct fromRequest(CreateTransactionRequest.TransactionProduct request) {
        return new TransactionProduct(
                request.getProductId(),
                request.getProductName(),
                request.getTotalPrice(),
                request.getQuantity(),
                request.getPriceMultiplier(),
                request.getDescription(),
                request.getCategory()
        );
    }
}
