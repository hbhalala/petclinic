package com.project.petclinic.api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errorMap = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(e->errorMap.put(e.getField(), e.getDefaultMessage()));
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleUserNotFoundException(UserNotFoundException unfe) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", unfe.getMessage());
        return errorMap;
    }

}
