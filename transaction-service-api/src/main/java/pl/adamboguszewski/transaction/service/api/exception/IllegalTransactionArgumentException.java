package pl.adamboguszewski.transaction.service.api.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class IllegalTransactionArgumentException extends IllegalArgumentException implements LoggingMessageException {

    private final String customizedMessage;

    public IllegalTransactionArgumentException(String customizedMessage) {
        super();
        this.customizedMessage = customizedMessage;
    }

    @Override
    public String getCustomizedMessage() {
        return customizedMessage;
    }
}
