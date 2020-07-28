package pl.adamboguszewski.transactionservice.application;

import java.util.UUID;

public class Product {

    private final Long id;

    private final UUID productId;

    private final Long priceMultiplier;

    private final Long quantity;

    private final Long totalPrice;

    public Product(Long id, UUID productId, Long priceMultiplier, Long quantity, Long totalPrice) {
        this.id = id;
        this.productId = productId;
        this.priceMultiplier = priceMultiplier;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public UUID getProductId() {
        return productId;
    }

    public Long getPriceMultiplier() {
        return priceMultiplier;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }
}
