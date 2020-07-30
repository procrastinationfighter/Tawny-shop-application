package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.service.api.transaction.CreateTransactionRequest;

@Value
public class TransactionPayment {

    Long amountPaid;

    Long multiplier;

    TransactionCurrency transactionCurrency;

    TransactionPaymentType transactionPaymentType;

    public TransactionPayment(Long amountPaid, Long multiplier, TransactionCurrency transactionCurrency,
                              TransactionPaymentType transactionPaymentType) {
        this.amountPaid = amountPaid;
        this.multiplier = multiplier;
        this.transactionCurrency = transactionCurrency;
        this.transactionPaymentType = transactionPaymentType;
    }

    public static TransactionPayment fromRequest(CreateTransactionRequest.TransactionInfo.TransactionPayment request) {
        return new TransactionPayment(request.getAmountPaid(), request.getMultiplier(),
                TransactionCurrency.labelToType(request.getCurrency().name().toLowerCase()),
                TransactionPaymentType.labelToType(request.getPaymentType().name().toLowerCase()));
    }

}
