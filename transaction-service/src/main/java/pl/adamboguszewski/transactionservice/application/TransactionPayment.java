package pl.adamboguszewski.transactionservice.application;

public class TransactionPayment {

    public enum Currency {
        PLN,
        USD,
        EUR
    }

    public enum PaymentType {
        CASH,
        CARD,
        GOOGLE_PAY
    }

    private final Long amount;

    private final Currency currency;

    private final Long multiplier;

    private final PaymentType paymentType;

    public TransactionPayment(Long amount, Currency currency,
                              Long multiplier, PaymentType paymentType) {
        this.amount = amount;
        this.currency = currency;
        this.multiplier = multiplier;
        this.paymentType = paymentType;
    }

    public Long getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Long getMultiplier() {
        return multiplier;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
