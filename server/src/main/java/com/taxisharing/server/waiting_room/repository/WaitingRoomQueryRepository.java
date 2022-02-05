package com.taxisharing.server.waiting_room.repository;

import com.taxisharing.server.waiting_room.domain.WaitingRoom;

import java.time.LocalDateTime;
import java.util.List;

public interface WaitingRoomQueryRepository {
    List<WaitingRoom> findByDepartureTime(LocalDateTime departureTime, BoundaryCoordinate departureBoundary);
    List<WaitingRoom> findByDeparture(BoundaryCoordinate departureBoundary);
    List<WaitingRoom> findByDestination(BoundaryCoordinate destinationBoundary);
    List<WaitingRoom> findByDepartureAndDestination(BoundaryCoordinate departureBoundary, BoundaryCoordinate destinationBoundary);
    List<WaitingRoom> findByAllInfo(LocalDateTime departureTime, BoundaryCoordinate departureBoundary, BoundaryCoordinate destinationBoundary);
}
