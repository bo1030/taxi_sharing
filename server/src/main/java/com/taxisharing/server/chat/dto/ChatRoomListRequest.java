package com.taxisharing.server.chat.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomListRequest {
    @NotNull
    private Date departureTime;
    @NotBlank
    private String departureAddress;
    @NotNull
    private float departureLatitude;
    @NotNull
    private float departureLongitude;
    private String destinationAddress;
    private float destinationLatitude;
    private float destinationLongitude;

    public ChatRoomListRequest(Date departureTime, String departureAddress, float departureLatitude, float departureLongitude, String destinationAddress, float destinationLatitude, float destinationLongitude){
        this.departureTime = departureTime;
        this.departureAddress = departureAddress;
        this.departureLatitude = departureLatitude;
        this.departureLongitude = departureLongitude;
        this.destinationAddress = destinationAddress;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
    }
}
