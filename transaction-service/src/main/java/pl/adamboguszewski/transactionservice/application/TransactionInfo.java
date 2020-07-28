package pl.adamboguszewski.transactionservice.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionInfo {

    private final LocalDateTime transactionDateTime;

    private final UUID checkoutId;

    private final List<TransactionPayment> transactionPayments;

    public TransactionInfo(LocalDateTime transactionDateTime, UUID checkoutId,
                           List<TransactionPayment> transactionPayments) {
        // [TODO]: This way of adding things to list can cause problems.
        this.transactionDateTime = transactionDateTime;
        this.checkoutId = checkoutId;
        this.transactionPayments = new ArrayList<>();
        this.transactionPayments.addAll(transactionPayments);
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public UUID getCheckoutId() {
        return checkoutId;
    }

    public List<TransactionPayment> getTransactionPayments() {
        return transactionPayments;
    }
}
