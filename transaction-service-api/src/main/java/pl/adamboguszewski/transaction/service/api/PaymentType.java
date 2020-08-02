package pl.adamboguszewski.transaction.service.api;

import pl.adamboguszewski.transaction.service.api.exception.IllegalPaymentTypeArgumentException;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PaymentType {

    CASH("cash"),
    CARD("card"),
    GOOGLE_PAY("google_pay")
    ;

    private final String value;

    private static final Map<String, PaymentType> FORMAT_MAP = Stream
            .of(PaymentType.values())
            .collect(Collectors.toMap(s -> s.value, Function.identity()));

    PaymentType(final String value) {
        this.value = value.toLowerCase();
    }

    public String getValue() {
        return value;
    }

    public static PaymentType fromString(String value) {
        return Optional
                .ofNullable(FORMAT_MAP.get(value.toLowerCase()))
                .orElseThrow(() -> new IllegalPaymentTypeArgumentException(value));
    }
}
