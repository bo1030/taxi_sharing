package com.taxisharing.server.chat.repository;

import com.taxisharing.server.chat.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom,Integer> {
    Optional<ChatRoom> findByDepartureTimeAndDepartureLatitudeBetweenAndDepartureLongitudeBetween(Date time, float x1, float x2, float y1, float y2);
}
