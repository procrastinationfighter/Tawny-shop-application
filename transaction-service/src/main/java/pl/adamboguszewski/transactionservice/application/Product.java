package pl.adamboguszewski.transactionservice.application;

public class Product {

    private final Long id;

    private final Long priceMultiplier;

    private final Long quantity;

    private final Long totalPrice;

    public Product(Long id, Long priceMultiplier, Long quantity, Long totalPrice) {
        this.id = id;
        this.priceMultiplier = priceMultiplier;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
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
