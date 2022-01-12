package com.taxisharing.server.member.repository;

import com.taxisharing.server.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByUsername(String username);

    boolean existsByNickname(String nickname);
}
