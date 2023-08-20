package com.jwt.jwt.controller;

import com.jwt.jwt.config.TokenManager;
import com.jwt.jwt.model.UserDetails;
import com.jwt.jwt.service.AuthServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class AuthenticationController {


    @Autowired
    AuthServiceImpl authService;

    @Autowired
    TokenManager tokenManager;


    @PostMapping("/getToken")
    public String getToken(@RequestBody UserDetails userDetails){
        log.error("userDetails = {}",userDetails.getUser());
        return authService.getToken(userDetails);
    }

    @GetMapping("/getUserDetails")
    public List<UserDetails> userDetails(HttpServletRequest request){
        return authService.getUserDetails();
    }
}
