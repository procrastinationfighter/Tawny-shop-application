package pl.adamboguszewski.transactionservice.application;

import java.util.HashMap;
import java.util.Map;

public enum TransactionCurrency {
    PLN("pln"),
    USD("usd"),
    EUR("eur");

    private static final Map<String, TransactionCurrency> LABEL = new HashMap<>();

    static {
        for(TransactionCurrency type : values()) {
            LABEL.put(type.label, type);
        }
    }

    public final String label;

    TransactionCurrency(String label) {
        this.label = label;
    }

    public static TransactionCurrency labelToType(String label) {
        return LABEL.get(label);
    }
}
