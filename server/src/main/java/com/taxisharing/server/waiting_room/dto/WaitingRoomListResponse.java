package com.taxisharing.server.waiting_room.dto;

import com.taxisharing.server.waiting_room.domain.WaitingRoom;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingRoomListResponse {
    private List<WaitingRoom> waitingRooms;

    public WaitingRoomListResponse(List<WaitingRoom> waitingRooms) {
        this.waitingRooms = waitingRooms;
    }
}
