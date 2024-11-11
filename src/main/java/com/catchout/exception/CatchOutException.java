package com.catchout.exception;

import java.util.HashMap;
import java.util.Map;

public abstract class CatchOutException extends RuntimeException {

    private final Map<String, String> validation = new HashMap<>();

    public CatchOutException(String message) {
        super(message);
    }

    public CatchOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int statusCode();

    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }

    public Map<String, String> getValidation() {
        return validation;
    }
}
