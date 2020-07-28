package pl.adamboguszewski.transactionservice.application;

import java.util.UUID;

import lombok.Value;

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
}
