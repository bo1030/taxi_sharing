package com.taxisharing.server.waiting_room.dto;

import com.taxisharing.server.waiting_room.domain.WaitingRoom;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingRoomCreateResponse {
    private WaitingRoom waitingRoom;

    public WaitingRoomCreateResponse(WaitingRoom waitingRoom) {
        this.waitingRoom = waitingRoom;
    }
}
