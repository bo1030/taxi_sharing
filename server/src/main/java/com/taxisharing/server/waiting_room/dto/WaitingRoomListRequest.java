package com.taxisharing.server.waiting_room.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class WaitingRoomListRequest {
    private String departure_time;
    private String departure_boundary;
    private String destination_boundary;

    public WaitingRoomListRequest(String departure_time, String departure_boundary, String destination_boundary) {
        this.departure_time = Optional.ofNullable(departure_time).orElseGet(()-> "None");
        this.departure_boundary = departure_boundary;
        this.destination_boundary = Optional.ofNullable(destination_boundary).orElseGet(()-> "None");
    }

}