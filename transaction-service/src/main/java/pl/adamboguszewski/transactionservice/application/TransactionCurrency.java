package pl.adamboguszewski.transactionservice.application;

public enum TransactionCurrency {
    PLN("pln"),
    USD("usd"),
    EUR("eur");

    public final String label;

     TransactionCurrency(String label) {
        this.label = label;
    }
}
