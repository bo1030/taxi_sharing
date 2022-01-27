package com.taxisharing.server.user.repository;

import com.taxisharing.server.user.domain.MannerRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MannerRepository extends JpaRepository<MannerRecord, Integer> {

    List<MannerRecord> findByTarget_Id(int target);

    boolean existsByUser_IdAndTarget_Id(int userId, int targetId);
}
