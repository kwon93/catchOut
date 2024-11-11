package com.catchout.exception.controller;

import com.catchout.exception.CatchOutException;
import com.catchout.exception.dto.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponse methodArgsHandler(MethodArgumentNotValidException exception) {
        ExceptionResponse response = buildDefaultExceptionResponse();
        extractValidationBy(exception, response);
        return response;
    }

    @ResponseBody
    @ExceptionHandler(CatchOutException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandler(CatchOutException catchOutException) {
        ExceptionResponse response = buildCatchOutExceptionResponse(catchOutException);
        return ResponseEntity.status(catchOutException.statusCode()).body(response);
    }


    private void extractValidationBy(MethodArgumentNotValidException e, ExceptionResponse response) {
        for (FieldError fieldError : e.getFieldErrors()) {
            response.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

    private ExceptionResponse buildDefaultExceptionResponse() {
        return ExceptionResponse.builder()
                .code("400")
                .errorMessage("잘못된 요청입니다.").build();
    }

    private ExceptionResponse buildCatchOutExceptionResponse(CatchOutException catchOutException) {
        return ExceptionResponse.builder()
                .code(String.valueOf(catchOutException.statusCode()))
                .errorMessage(catchOutException.getMessage())
                .validation(catchOutException.getValidation())
                .build();
    }
}
