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

    private final Long amountPaid;

    private final Currency currency;

    private final Long multiplier;

    private final PaymentType paymentType;

    public TransactionPayment(Long amountPaid, Currency currency,
                              Long multiplier, PaymentType paymentType) {
        this.amountPaid = amountPaid;
        this.currency = currency;
        this.multiplier = multiplier;
        this.paymentType = paymentType;
    }

    public Long getAmountPaid() {
        return amountPaid;
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
