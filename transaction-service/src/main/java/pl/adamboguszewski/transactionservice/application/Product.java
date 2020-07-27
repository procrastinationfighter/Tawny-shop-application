package pl.adamboguszewski.transactionservice.application;

public class Product {

    private final String id;

    private final long priceMultiplier;

    private final long quantity;

    private final long totalPrice;

    public Product(String id, long priceMultiplier, long quantity, long totalPrice) {
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
