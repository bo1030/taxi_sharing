package com.taxisharing.server.waiting_room.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingRoomListResponse {
    private String result;

    public WaitingRoomListResponse(String result) {
        this.result = result;
    }
}
