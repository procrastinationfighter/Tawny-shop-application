package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.service.api.transaction.CreateTransactionRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class TransactionInformation {

    LocalDateTime transactionDateTime;
    String checkoutId;

    List<PaymentInformation> payments;

    private TransactionInformation(LocalDateTime transactionDateTime, String checkoutId, List<PaymentInformation> payments) {
        this.transactionDateTime = transactionDateTime;
        this.checkoutId = checkoutId;
        this.payments = payments;
    }

//    // immutable object bruh.. Please delete this after read
//    private void createPaymentsFromRequest(List<CreateTransactionRequest.TransactionInfo.TransactionPayment> requests) {
//        for(CreateTransactionRequest.TransactionInfo.TransactionPayment paymentRequest
//                : requests) {
//            this.payments.add(PaymentInformation.fromRequest(paymentRequest));
//        }
//    }

    public static TransactionInformation fromRequest(CreateTransactionRequest.TransactionInformation request) {
        List<PaymentInformation> payments;
        payments = request.getPaymentInformations()
                .stream()
                .map(PaymentInformation::fromRequest)
                .collect(Collectors.toList());

        return new TransactionInformation(
                request.getTransactionDateTime(),
                request.getCheckoutId(),
                payments
        );
    }
}
