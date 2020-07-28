package pl.adamboguszewski.transactionservice.application;

import lombok.Value;

@Value
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

    Long amountPaid;

    Currency currency;

    Long multiplier;

    PaymentType paymentType;

}
