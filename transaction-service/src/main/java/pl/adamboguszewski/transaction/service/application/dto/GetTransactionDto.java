package pl.adamboguszewski.transaction.service.application.dto;

import lombok.Value;
import pl.adamboguszewski.transaction.service.application.Transaction;
import pl.adamboguszewski.transaction.service.application.TransactionProduct;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class GetTransactionDto {

    UUID transactionId;

    Long totalPrice;

    List<TransactionProductDto> products;

    LocalDateTime transactionDateTime;

    private GetTransactionDto(UUID transactionId,
                              Long totalPrice,
                              List<TransactionProductDto> products,
                              LocalDateTime transactionDateTime) {
        this.transactionId = transactionId;
        this.totalPrice = totalPrice;
        this.products = products;
        this.transactionDateTime = transactionDateTime;
    }

    public static GetTransactionDto fromTransaction(Transaction transaction) {
        List<TransactionProductDto> products = transaction.getProducts()
                .stream()
                .map(TransactionProductDto::fromTransaction)
                .collect(Collectors.toList());

        return new GetTransactionDto(
                transaction.getTransactionId(),
                transaction.getTotalPrice(),
                products,
                transaction.getTransactionDateTime());
    }


    @Value
    public static class TransactionProductDto {

        UUID productId;

        String name;

        Long price;

        Long quantity;

        Long priceMultiplier;

        String description;

        String category;

        private TransactionProductDto(UUID productId,
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

        public static TransactionProductDto fromTransaction(TransactionProduct product) {
            return new TransactionProductDto(
                    product.getProductId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getPriceMultiplier(),
                    product.getDescription(),
                    product.getCategory());
        }
    }
}
