package com.taxisharing.server.chat.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModifyChatInfoRequest {
    private String cname;
    private String hostName;
    private Date departureTime;
    private String departureAddress;
    private float departureLatitude;
    private float departureLongitude;
    private String destinationAddress;
    private float destinationLatitude;
    private float destinationLongitude;
    private Integer maximumNumber;

    public ModifyChatInfoRequest(String cname, String hostName, Date departureTime, String departureAddress, float departureLatitude, float departureLongitude, String destinationAddress, float destinationLatitude, float destinationLongitude, Integer maximumNumber){
        this.cname = cname;
        this.hostName = hostName;
        this.departureTime = departureTime;
        this.departureAddress = departureAddress;
        this.departureLatitude = departureLatitude;
        this.departureLongitude = departureLongitude;
        this.destinationAddress = destinationAddress;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
        this.maximumNumber = maximumNumber;
    }
}
