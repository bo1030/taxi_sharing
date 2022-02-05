package com.taxisharing.server.waiting_room.service;

import com.taxisharing.server.waiting_room.dto.WaitingRoomListRequest;
import com.taxisharing.server.waiting_room.dto.WaitingRoomListResponse;
import com.taxisharing.server.waiting_room.repository.WaitingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class WaitingRoomService {
    public final WaitingRoomRepository waitingRoomRepository;

    public WaitingRoomListResponse getWaitingRoomList(WaitingRoomListRequest waitingRoomListRequest) {
        String departureBoundary = waitingRoomListRequest.getDeparture_boundary();
        String[] departureCoordinates = departureBoundary.split(";");
        return new WaitingRoomListResponse(waitingRoomRepository.findByDepartureLatitudeBetweenAndDepartureLongitudeBetween());
    }
}
