package pl.adamboguszewski.transactionservice.application;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Value
public class TransactionInfo {

    LocalDateTime transactionDateTime;

    UUID checkoutId;

    List<TransactionPayment> transactionPayments;

    public TransactionInfo(LocalDateTime transactionDateTime, UUID checkoutId,
                           List<TransactionPayment> transactionPayments) {
        // [TODO]: This way of adding things to list can cause problems.
        this.transactionDateTime = transactionDateTime;
        this.checkoutId = checkoutId;
        this.transactionPayments = new ArrayList<>();
        this.transactionPayments.addAll(transactionPayments);
    }
}
