package com.taxisharing.server.waiting_room.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingRoomParticipantId implements Serializable {
    private int user;
    private int waitingRoom;

    public WaitingRoomParticipantId(int user, int waitingRoom) {
        this.user = user;
        this.waitingRoom = waitingRoom;
    }
}
