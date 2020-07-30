package pl.adamboguszewski.transactionservice.application;

import lombok.Value;
import pl.adamboguszewski.transactionservice.service.api.transaction.CreateTransactionRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Value
public class TransactionInfo {

    LocalDateTime transactionDateTime;

    String checkoutId;

    List<TransactionPayment> transactionPayments;

    public TransactionInfo(CreateTransactionRequest.TransactionInfo request) {
        this.transactionDateTime = request.getTransactionDateTime();
        this.checkoutId = request.getCheckoutId();
        this.transactionPayments = new ArrayList<>();
        for(CreateTransactionRequest.TransactionInfo.TransactionPayment payment
                : request.getTransactionPayments()) {
            this.transactionPayments.add(new TransactionPayment(payment));
        }
    }
}
