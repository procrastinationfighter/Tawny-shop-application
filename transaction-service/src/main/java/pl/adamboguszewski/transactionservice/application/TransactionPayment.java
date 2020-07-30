package pl.adamboguszewski.transactionservice.application;

import lombok.Value;
import pl.adamboguszewski.transactionservice.service.api.transaction.CreateTransactionRequest;

@Value
public class TransactionPayment {

    Long amountPaid;

    TransactionCurrency transactionCurrency;

    Long multiplier;

    TransactionPaymentType transactionPaymentType;

    public TransactionPayment(CreateTransactionRequest.TransactionInfo.TransactionPayment request) {
        this.amountPaid = request.getAmountPaid();
        this.multiplier = request.getMultiplier();
        // [TODO] Solve problem with same enums in two classes from different modules.
        this.transactionCurrency = TransactionCurrency.PLN;
        this.transactionPaymentType = TransactionPaymentType.CARD;
    }

}
