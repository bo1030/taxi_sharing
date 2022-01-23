package com.taxisharing.server.waiting_room.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ListRequest {
    private String departureTime;
    private String departureAddress;
    private String departureLatitude;
    private String departureLongitude;
    private String destinationAddress;
    private String destinationLatitude;
    private String destinationLongitude;

    public ListRequest(String result) {

    }
}