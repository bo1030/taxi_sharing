package com.taxisharing.server.chat.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MakeChatRoomResponse {
    private Integer cid;
    private String cname;
    private Integer status;
    private Date generateTime;
    private Date departureTime;
    private String departureAddress;
    private float departureLatitude;
    private float departureLongitude;
    private String destinationAddress;
    private float destinationLatitude;
    private float destinationLongitude;
    private Integer currentNumber;
    private Integer maximumNumber;

    public MakeChatRoomResponse(Integer cid, String cname, Integer status, Date generateTime, Date departureTime, String departureAddress, float departureLatitude, float departureLongitude, String destinationAddress, float destinationLatitude, float destinationLongitude, Integer currentNumber, Integer maximumNumber){
        this.cid = cid;
        this.cname = cname;
        this.status = status;
        this.generateTime = generateTime;
        this. departureTime = departureTime;
        this.departureAddress = departureAddress;
        this. departureLatitude = departureLatitude;
        this.departureLongitude = departureLongitude;
        this.destinationAddress = destinationAddress;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
        this.currentNumber = currentNumber;
        this.maximumNumber = maximumNumber;
    }
}
