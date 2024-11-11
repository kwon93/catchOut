package com.catchout.exception.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionResponse {

    private LocalDateTime timeStamp;
    private String code;
    private String errorMessage;
    private Map<String, String> validation = new HashMap<>(); //TODO map쓸지  객체 할지

    @Builder
    public ExceptionResponse(LocalDateTime timeStamp, String code, String errorMessage, Map<String, String> validation) {
        this.timeStamp = LocalDateTime.now();
        this.code = code;
        this.errorMessage = errorMessage;
        this.validation = validation != null ? validation : new HashMap<>();
    }

    public void addValidation(String field, String defaultMessage) {
        validation.put(field, defaultMessage);
    }


}
