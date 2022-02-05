package com.taxisharing.server.waiting_room.repository;

import com.taxisharing.server.waiting_room.domain.WaitingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface WaitingRoomRepository extends JpaRepository<WaitingRoom, Integer>, WaitingRoomQueryRepository {

}