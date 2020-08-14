package pl.adamboguszewski.transaction.service.application;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class IllegalCurrencyArgumentException extends IllegalArgumentException {

    String currency;

    public IllegalCurrencyArgumentException(String currency) {
        super("Currency named " + currency + " does not exist.");
        this.currency = currency;
    }
}
