package org.practice.example.backoffstrategy.responses;

public class RepeaterResult<T> {
    private final boolean success;
    private final T result;
    private final Exception exception;

    public RepeaterResult(boolean success, T result, Exception exception) {
        this.success = success;
        this.result = result;
        this.exception = exception;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public String toString() {
        if (success) {
            return "Success: " + result;
        } else {
            return "Failed: " + (exception != null ? exception.getMessage() : "Unknown reason");
        }
    }
}

