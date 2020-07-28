package pl.adamboguszewski.transactionservice.application;

public class Product {

    private final String id;

    private final Long priceMultiplier;

    private final Long quantity;

    private final Long totalPrice;

    public Product(String id, Long priceMultiplier, Long quantity, Long totalPrice) {
        this.id = id;
        this.priceMultiplier = priceMultiplier;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public long getPriceMultiplier() {
        return priceMultiplier;
    }

    public long getQuantity() {
        return quantity;
    }

    public long getTotalPrice() {
        return totalPrice;
    }
}
