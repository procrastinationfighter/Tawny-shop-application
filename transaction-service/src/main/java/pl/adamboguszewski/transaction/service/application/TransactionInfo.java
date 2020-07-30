package pl.adamboguszewski.transaction.service.application;

import lombok.Value;
import pl.adamboguszewski.transaction.service.service.api.transaction.CreateTransactionRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class TransactionInfo {

    LocalDateTime transactionDateTime;
    String checkoutId;

    List<PaymentInformation> payments;

    private TransactionInfo(LocalDateTime transactionDateTime, String checkoutId, List<PaymentInformation> payments) {
        this.transactionDateTime = transactionDateTime;
        this.checkoutId = checkoutId;
        this.payments = payments;
    }

//    // immutable object bruh..
//    private void createPaymentsFromRequest(List<CreateTransactionRequest.TransactionInfo.TransactionPayment> requests) {
//        for(CreateTransactionRequest.TransactionInfo.TransactionPayment paymentRequest
//                : requests) {
//            this.payments.add(PaymentInformation.fromRequest(paymentRequest));
//        }
//    }

    public static TransactionInfo fromRequest(CreateTransactionRequest.TransactionInfo request) {
        List<PaymentInformation> payments;
        payments = request.getTransactionPayments()
                .stream()
                .map(PaymentInformation::fromRequest)
                .collect(Collectors.toList());

        return new TransactionInfo(
                request.getTransactionDateTime(),
                request.getCheckoutId(),
                payments
        );
    }
}
