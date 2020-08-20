package pl.adamboguszewski.transaction.service.api.exception;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class IllegalPaymentTypeArgumentException extends IllegalEnumArgumentException {

    String paymentType;

    public IllegalPaymentTypeArgumentException(String type) {
        super("Payment type named " + type + " does not exist.");
        this.paymentType = type;
    }

}
