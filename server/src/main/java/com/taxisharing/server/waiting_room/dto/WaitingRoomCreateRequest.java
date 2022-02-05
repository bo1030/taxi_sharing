package com.taxisharing.server.waiting_room.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class WaitingRoomCreateRequest {
    private String wname;

    private String hostName;
    private String departureTime;

    private String departureAddress;
    @Pattern(regexp = "^(\\d+[.]\\d+[;]\\s){3}(\\d+[.]\\d+[;])")
    private String departureBoundary;

    private String destinationAddress;
    @Pattern(regexp = "^(\\d+[.]\\d+[;]\\s){3}(\\d+[.]\\d+[;])")
    private String destinationBoundary;

    private Integer maximumNumber;

    public WaitingRoomCreateRequest(String wname, String hostName, String departureTime, String departureBoundary, String destinationBoundary) {
        this.wname = wname;
        this.hostName = hostName;
        this.departureTime = departureTime;
        this.departureBoundary = departureBoundary;
        this.destinationBoundary = destinationBoundary;
    }
}
