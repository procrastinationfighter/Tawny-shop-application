package pl.adamboguszewski.transaction.service.application;

import java.util.HashMap;
import java.util.Map;

public enum TransactionPaymentType {

    CASH("cash"),
    CARD("card"),
    GOOGLE_PAY("google_pay");

    private static final Map<String, TransactionPaymentType> LABEL = new HashMap<>();

    static {
        for(TransactionPaymentType type : values()) {
            LABEL.put(type.label, type);
        }
    }

    public final String label;

    TransactionPaymentType(String label) {
        this.label = label;
    }

    public static TransactionPaymentType labelToType(String label) {
        return LABEL.get(label);
    }
}
