package pl.adamboguszewski.transaction.service.api.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class IllegalEnumArgumentException extends IllegalArgumentException implements ApiLoggingMessageException {

    private final String customizedMessage;

    public IllegalEnumArgumentException(String customizedMessage) {
        super();
        this.customizedMessage = customizedMessage;
    }

    @Override
    public String getCustomizedMessage() {
        return customizedMessage;
    }
}
