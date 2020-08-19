package pl.adamboguszewski.transaction.service.api.exception;

public interface LogMessage {

    String getCustomizedMessage();
    String getLocalizedMessage();
    StackTraceElement[] getStackTrace();
}
