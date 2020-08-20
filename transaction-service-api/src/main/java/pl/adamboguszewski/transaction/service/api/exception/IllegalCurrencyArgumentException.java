package pl.adamboguszewski.transaction.service.api.exception;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class IllegalCurrencyArgumentException extends IllegalArgumentException implements LoggingMessageException {

    String currency;
    String customizedMessage;

    public IllegalCurrencyArgumentException(String currency) {
        super();
        this.currency = currency;
        this.customizedMessage = "Currency named " + currency + " does not exist.";
    }
}
