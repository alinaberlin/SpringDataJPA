package com.github.alinaberlin.security.repositories;

import com.github.alinaberlin.restate.models.Property;
import com.github.alinaberlin.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends  JpaRepository<User, Integer> {
    User findByUsername(String username);
}
