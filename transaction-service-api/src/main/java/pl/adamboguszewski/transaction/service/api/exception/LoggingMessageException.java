package pl.adamboguszewski.transaction.service.api.exception;

public interface LoggingMessageException {

    String getCustomizedMessage();
    String getLocalizedMessage();
    StackTraceElement[] getStackTrace();
}
