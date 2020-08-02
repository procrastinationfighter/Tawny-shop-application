package pl.adamboguszewski.transaction.service.api.exception;

public class IllegalPaymentTypeArgumentException extends IllegalArgumentException {

    public IllegalPaymentTypeArgumentException(String value) {
        super("Payment type named " + value + " does not exist.");
    }
}
