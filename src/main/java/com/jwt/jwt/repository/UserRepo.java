package com.jwt.jwt.repository;

import com.jwt.jwt.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserDetails , Integer> {
    UserDetails findByUser(String userName);
}
