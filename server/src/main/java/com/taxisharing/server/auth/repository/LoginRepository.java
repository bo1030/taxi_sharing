package com.taxisharing.server.auth.repository;

import com.taxisharing.server.auth.domain.LoginInfo;
import com.taxisharing.server.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<User,Integer> {

    Optional<LoginInfo> findByUsername(String username);
}
