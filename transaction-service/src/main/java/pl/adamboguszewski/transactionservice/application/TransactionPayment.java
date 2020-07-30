package pl.adamboguszewski.transactionservice.application;

import lombok.Value;
import pl.adamboguszewski.transactionservice.service.api.transaction.CreateTransactionRequest;

@Value
public class TransactionPayment {

    Long amountPaid;

    Currency currency;

    Long multiplier;

    PaymentType paymentType;

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

    public TransactionPayment(CreateTransactionRequest.TransactionInfo.TransactionPayment request) {
        this.amountPaid = request.getAmountPaid();
        this.multiplier = request.getMultiplier();
        // [TODO] Solve problem with same enums in two classes from different modules.
        this.currency = Currency.PLN;
        this.paymentType = PaymentType.CARD;
    }

}
