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

    private TransactionInfo(LocalDateTime dateTime, String checkoutId) {
        this.transactionDateTime = dateTime;
        this.checkoutId = checkoutId;
        this.transactionPayments = new ArrayList<>();
    }

    private void createPaymentsFromRequest(List<CreateTransactionRequest.TransactionInfo.TransactionPayment> requests) {
        for(CreateTransactionRequest.TransactionInfo.TransactionPayment paymentRequest
                : requests) {
            this.transactionPayments.add(TransactionPayment.fromRequest(paymentRequest));
        }
    }

    public static TransactionInfo fromRequest(CreateTransactionRequest.TransactionInfo request) {
        TransactionInfo info = new TransactionInfo(request.getTransactionDateTime(), request.getCheckoutId());
        info.createPaymentsFromRequest(request.getTransactionPayments());
        return info;
    }
}
