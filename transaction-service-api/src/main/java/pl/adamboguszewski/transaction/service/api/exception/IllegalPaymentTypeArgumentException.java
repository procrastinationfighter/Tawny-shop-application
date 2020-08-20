package pl.adamboguszewski.transaction.service.api.exception;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class IllegalPaymentTypeArgumentException extends IllegalArgumentException implements LoggingMessageException {

    String paymentType;

    String customizedMessage;

    public IllegalPaymentTypeArgumentException(String type) {
        super();
        this.paymentType = type;
        this.customizedMessage = "Payment type named " + type + " does not exist.";
    }

    @Override
    public String getCustomizedMessage() {
        return null;
    }
}
