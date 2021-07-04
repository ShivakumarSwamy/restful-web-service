package com.example.restfulwebservice.global;

import java.util.UUID;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.restfulwebservice.dto.Error;

@RestControllerAdvice
public class RestControllerAdviceExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestControllerAdviceExceptionHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
        var error = new Error();
        error.setMessage(constraintViolationException.getLocalizedMessage());
        error.setRequestId(UUID.randomUUID());

        LOGGER.info("{} with stacktrace\n{}", error, constraintViolationException.getStackTrace());
        return error;
    }
}
