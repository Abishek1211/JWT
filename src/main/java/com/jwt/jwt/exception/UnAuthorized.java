package com.jwt.jwt.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UnAuthorized extends RuntimeException{

    private int statusCode;

    public UnAuthorized(int statusCode , String message){
        super(message);
        this.statusCode=statusCode;
    }
}
