package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.service.api.transaction.CreateTransactionRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Value
public class TransactionInfo {

    LocalDateTime transactionDateTime;

    String checkoutId;

    List<PaymentInformation> paymentInformations;

    private TransactionInfo(LocalDateTime dateTime, String checkoutId) {
        this.transactionDateTime = dateTime;
        this.checkoutId = checkoutId;
        this.paymentInformations = new ArrayList<>();
    }

    private void createPaymentsFromRequest(List<CreateTransactionRequest.TransactionInfo.TransactionPayment> requests) {
        for(CreateTransactionRequest.TransactionInfo.TransactionPayment paymentRequest
                : requests) {
            this.paymentInformations.add(PaymentInformation.fromRequest(paymentRequest));
        }
    }

    public static TransactionInfo fromRequest(CreateTransactionRequest.TransactionInfo request) {
        TransactionInfo info = new TransactionInfo(request.getTransactionDateTime(), request.getCheckoutId());
        info.createPaymentsFromRequest(request.getTransactionPayments());
        return info;
    }
}
