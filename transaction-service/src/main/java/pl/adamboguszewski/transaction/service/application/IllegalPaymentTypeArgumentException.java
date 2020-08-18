package pl.adamboguszewski.transaction.service.application;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class IllegalPaymentTypeArgumentException extends IllegalArgumentException {

    String paymentType;

    public IllegalPaymentTypeArgumentException(String type) {
        super("Payment type named " + type + " does not exist.");
        this.paymentType = type;
    }
}
