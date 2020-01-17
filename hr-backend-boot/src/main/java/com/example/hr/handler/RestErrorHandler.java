package com.example.hr.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.hr.dto.RestErrorMessage;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestErrorHandler {
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    public RestErrorMessage handleRuntimeException(
    		RuntimeException e) {
        return new RestErrorMessage(
                e.getMessage(),
                e.getMessage(),
                e.getMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorMessage handleValidationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        String message = violations.stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("|"));
        return new RestErrorMessage(message, message, "95b49f5c-5b2e-43de-8967-fed414a96dc0");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("|"));
        return new RestErrorMessage(message, message, "0d3a5eed-ee48-4d23-985e-99d2ac3afacb");
    }


}
