package com.taxisharing.server.auth.repository;

import com.taxisharing.server.auth.domain.LoginInfo;
import com.taxisharing.server.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Member,Integer> {

    Optional<LoginInfo> findByUsername(String username);
}
