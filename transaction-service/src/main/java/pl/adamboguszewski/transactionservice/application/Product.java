package pl.adamboguszewski.transactionservice.application;

import java.util.UUID;

public class Product {

    private final Long id;

    private final UUID productId;

    private final Long priceMultiplier;

    private final Long quantity;

    private final Long totalPrice;

    private final String productName;

    private final String description;

    private final String category;

    public Product(Long id, UUID productId, Long priceMultiplier,
                   Long quantity, Long totalPrice, String productName,
                   String description, String category) {
        this.id = id;
        this.productId = productId;
        this.priceMultiplier = priceMultiplier;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.productName = productName;
        this.description = description;
        this.category = category;
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

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
