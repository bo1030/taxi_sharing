package com.taxisharing.server.waiting_room.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ListResponse {
    private String result;

    public ListResponse(String result) {
        this.result = result;
    }
}
