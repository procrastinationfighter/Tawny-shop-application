package pl.adamboguszewski.transaction.service.application;

public interface ServiceLoggingMessageException {
    String getCustomizedMessage();
    String getLocalizedMessage();
    StackTraceElement[] getStackTrace();
}
