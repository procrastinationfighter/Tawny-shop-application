package pl.adamboguszewski.transactionservice.application;

import java.util.UUID;

// [TODO]: Read abut project lombok https://projectlombok.org/
// [TODO]: Important lombok annotations that you need for now:
//  Constructors https://projectlombok.org/features/constructor
//  @Getter @Setter https://projectlombok.org/features/GetterSetter
//  @Data https://projectlombok.org/features/Data
//  @Value https://projectlombok.org/features/Value
// [TODO]: I will hint where you need to use it but I won't tell you which one is correct in this case (of course one should be used on this class)
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
