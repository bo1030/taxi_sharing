package com.taxisharing.server.waiting_room.repository;

import com.taxisharing.server.waiting_room.domain.WaitingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface WaitingRoomRepository extends JpaRepository<WaitingRoom, Integer> {
    List<WaitingRoom> findByDepartureLatitudeBetweenAndDepartureLongitudeBetween(Float leftLatitude,Float rightLatitude,Float leftLongitude,Float rightLongitude);
    List<WaitingRoom> findByDestinationLatitudeBetweenAndDestinationLongitudeBetween(Float leftLatitude,Float rightLatitude,Float leftLongitude,Float rightLongitude);

}