package com.jwt.jwt.exception;

import com.jwt.jwt.model.ErrorResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {


    @ExceptionHandler(value = {UnAuthorized.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResource internalServerError(Exception ex) {
        return new ErrorResource(401,"UnAuthorized");
    }
}