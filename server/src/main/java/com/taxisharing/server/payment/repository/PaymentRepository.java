package com.taxisharing.server.payment.repository;

import com.taxisharing.server.payment.domain.Payment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @EntityGraph(attributePaths = "user")
    Optional<Payment> findByMerchantUid(UUID merchantUid);

}
