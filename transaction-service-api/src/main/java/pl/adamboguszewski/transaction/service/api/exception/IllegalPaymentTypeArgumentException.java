package pl.adamboguszewski.transaction.service.api.exception;

// [TODO]: Add to ExceptionHandler
public class IllegalPaymentTypeArgumentException extends IllegalArgumentException {

    public IllegalPaymentTypeArgumentException(String value) {
        super("Payment type named " + value + " does not exist.");
    }
}
