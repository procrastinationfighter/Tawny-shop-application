package pl.adamboguszewski.transaction.service.api.transaction;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Value
public class GetTransactionSuccessResponse implements GetTransactionResponse {
    UUID transactionId;

    Long totalPrice;

    List<TransactionProduct> products;

    LocalDateTime transactionDateTime;

    public GetTransactionSuccessResponse(UUID transactionId,
                                 Long totalPrice,
                                 List<TransactionProduct> products,
                                 LocalDateTime transactionDateTime) {
        this.transactionId = transactionId;
        this.totalPrice = totalPrice;
        this.products = products;
        this.transactionDateTime = transactionDateTime;
    }

    static class TransactionProduct {
        UUID productId;

        String name;

        Long price;

        Long quantity;

        Long priceMultiplier;

        String description;

        String category;

        public TransactionProduct(UUID productId,
                                      String name,
                                      Long price,
                                      Long quantity,
                                      Long priceMultiplier,
                                      String description,
                                      String category) {
            this.productId = productId;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.priceMultiplier = priceMultiplier;
            this.description = description;
            this.category = category;
        }
    }
}
