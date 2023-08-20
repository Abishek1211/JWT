package com.jwt.jwt.service;

import com.jwt.jwt.config.TokenManager;
import com.jwt.jwt.model.UserDetails;
import com.jwt.jwt.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class AuthServiceImpl {

    @Autowired
    UserRepo userRepo;

    @Autowired
    TokenManager tokenManager;

    public String getToken(UserDetails userDetails){
        userRepo.save(userDetails);
        return tokenManager.generateJwtToken(userDetails);
    }

    public List<UserDetails> getUserDetails() {
        log.error("fetching user Details");
        return userRepo.findAll();
    }
}
