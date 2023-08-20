package com.jwt.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResource {

    private int code;
    private Object message;

    public ErrorResource(int code, Object message) {
        this.code = code;
        this.message = message;
    }
}
