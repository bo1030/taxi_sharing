package com.taxisharing.server.waiting_room.service;

import com.taxisharing.server.user.domain.User;
import com.taxisharing.server.user.service.UserService;
import com.taxisharing.server.waiting_room.domain.WaitingRoom;
import com.taxisharing.server.waiting_room.dto.WaitingRoomCreateRequest;
import com.taxisharing.server.waiting_room.dto.WaitingRoomCreateResponse;
import com.taxisharing.server.waiting_room.dto.WaitingRoomListRequest;
import com.taxisharing.server.waiting_room.dto.WaitingRoomListResponse;
import com.taxisharing.server.waiting_room.repository.BoundaryCoordinate;
import com.taxisharing.server.waiting_room.repository.WaitingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class WaitingRoomService {
    public final WaitingRoomRepository waitingRoomRepository;
    public final UserService userService;

    public WaitingRoomListResponse getWaitingRoomList(WaitingRoomListRequest waitingRoomListRequest) {
        String departureBoundary = waitingRoomListRequest.getDeparture_boundary();
        String destinationBoundary = waitingRoomListRequest.getDestination_boundary();
        String departureTime = waitingRoomListRequest.getDeparture_time();

        BoundaryCoordinate departureCoordinates = new BoundaryCoordinate(departureBoundary.split(";"));

        if(destinationBoundary != null && departureTime != null) {
            LocalDateTime time = LocalDateTime.parse(departureTime);
            BoundaryCoordinate destinationCoordinates = new BoundaryCoordinate(destinationBoundary.split(";"));
            return new WaitingRoomListResponse(waitingRoomRepository.findByAllInfo(time, departureCoordinates, destinationCoordinates));
        }

        if(destinationBoundary != null)
        {
            BoundaryCoordinate destinationCoordinates = new BoundaryCoordinate(destinationBoundary.split(";"));
            return new WaitingRoomListResponse(waitingRoomRepository.findByDepartureAndDestination(departureCoordinates, destinationCoordinates));
        }

        if(departureTime != null)
        {
            LocalDateTime time = LocalDateTime.parse(departureTime);
            return new WaitingRoomListResponse(waitingRoomRepository.findByDepartureTime(time, departureCoordinates));
        }

        return new WaitingRoomListResponse(waitingRoomRepository.findByDeparture(departureCoordinates));
    }

    public WaitingRoomCreateResponse createWaitingRoom(int uid, WaitingRoomCreateRequest request) {
        User host = userService.findUser(uid);
        String[] departureCoordinates = request.getDepartureBoundary().split(";");
        String[] destinationCoordinates = request.getDestinationBoundary().split(";");

        WaitingRoom newRoom = new WaitingRoom(host, LocalDateTime.now(), LocalDateTime.parse(request.getDepartureTime()), request.getDepartureAddress(), Float.parseFloat(departureCoordinates[0]), Float.parseFloat(departureCoordinates[1]), request.getDestinationAddress(), Float.parseFloat(destinationCoordinates[0]), Float.parseFloat(destinationCoordinates[1]), request.getMaximumNumber());
        WaitingRoom saveRoom = waitingRoomRepository.save(newRoom);
        return new WaitingRoomCreateResponse(saveRoom);
    }
}
