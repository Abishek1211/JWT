package com.jwt.jwt.config;


import com.jwt.jwt.exception.UnAuthorized;
import com.jwt.jwt.model.UserDetails;
import com.jwt.jwt.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class Interceptor implements HandlerInterceptor {

    @Autowired
    TokenManager tokenManager;

    @Autowired
    UserRepo userRepo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       log.info("INSIDE INTERCEPTOR") ;
       String token =  request.getHeader("Authorization");
        if(tokenManager.validateJwtToken(token)){
            return true;
        }
        else {
            throw new UnAuthorized(401, "UNAUTHORIZED");
        }
    }
}
