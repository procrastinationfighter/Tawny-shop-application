package pl.adamboguszewski.transaction.service.api.exception;

public interface ApiLoggingMessageException {

    String getCustomizedMessage();
    String getLocalizedMessage();
    StackTraceElement[] getStackTrace();
}
