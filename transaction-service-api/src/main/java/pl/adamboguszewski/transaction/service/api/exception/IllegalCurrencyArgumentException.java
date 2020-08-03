package pl.adamboguszewski.transaction.service.api.exception;

// [TODO]: Add to ExceptionHandler
public class IllegalCurrencyArgumentException extends IllegalArgumentException {

    public IllegalCurrencyArgumentException(String value) {
        super("Currency named " + value + " does not exist.");
    }
}
