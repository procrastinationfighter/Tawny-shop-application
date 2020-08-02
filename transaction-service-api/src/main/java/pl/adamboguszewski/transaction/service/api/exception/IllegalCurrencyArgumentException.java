package pl.adamboguszewski.transaction.service.api.exception;

public class IllegalCurrencyArgumentException extends IllegalArgumentException {

    public IllegalCurrencyArgumentException(String value) {
        super("Currency named " + value + " does not exist.");
    }
}
