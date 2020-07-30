package pl.adamboguszewski.transactionservice.application;

public enum TransactionPaymentType {

    CASH("cash"),
    CARD("card"),
    GOOGLE_PAY("google_pay");

    public final String label;

    TransactionPaymentType(String label) {
        this.label = label;
    }
}
