package pl.adamboguszewski.transaction.service.api;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Currency {

    PLN("pln"),
    USD("usd"),
    EUR("eur")
    ;

    private final String value;

    private static final Map<String, Currency> FORMAT_MAP = Stream
            .of(Currency.values())
            .collect(Collectors.toMap(s -> s.value, Function.identity()));

    Currency(final String value) {
        this.value = value.toLowerCase();
    }

    public String getValue() {
        return value;
    }

    public static Currency fromString(String value) {
        return Optional
                .ofNullable(FORMAT_MAP.get(value.toLowerCase()))
                .orElseThrow(() -> new IllegalArgumentException(value)); // [TODO]: Add IllegalCurrencyArgumentException
    }
}