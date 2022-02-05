package com.taxisharing.server.waiting_room.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.Optional;

@Data
@NoArgsConstructor
public class WaitingRoomListRequest {
    private String departure_time;

    @Pattern(regexp = "^(\\d+[.]\\d+[;]\\s){3}(\\d+[.]\\d+[;])")
    private String departure_boundary;
    @Pattern(regexp = "^(\\d+[.]\\d+[;]\\s){3}(\\d+[.]\\d+[;])")
    private String destination_boundary;

    public WaitingRoomListRequest(String departure_time, String departure_boundary, String destination_boundary) {
        this.departure_time = departure_time;
        this.departure_boundary = departure_boundary;
        this.destination_boundary = destination_boundary;
    }

}