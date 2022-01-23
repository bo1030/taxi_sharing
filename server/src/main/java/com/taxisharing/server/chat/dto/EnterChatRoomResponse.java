package com.taxisharing.server.chat.dto;

import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EnterChatRoomResponse {
    private Integer cid;
    private String cname;
    private String hostName;
    private Integer maximumNumber;
    private Integer currentNumber;
    private List<User> users = new ArrayList<>();
    private Integer status;
    private Date generateTime;
    private Date departureTime;
    private String departureAddress;
    private float departureLatitude;
    private float departureLongitude;
    private String destinationAddress;
    private float destinationLatitude;
    private float destinationLongitude;

    public EnterChatRoomResponse(Integer cid, String cname, String hostName, Integer maximumNumber, Integer currentNumber, Integer status, Date generateTime, Date departureTime, String departureAddress, float departureLatitude, float departureLongitude, String destinationAddress, float destinationLatitude, float destinationLongitude){
        this.cid = cid;
        this.cname = cname;
        this.hostName = hostName;
        this.maximumNumber = maximumNumber;
        this.currentNumber = currentNumber;
        this.status = status;
        this.generateTime = generateTime;
        this.departureTime = departureTime;
        this.departureAddress = departureAddress;
        this.departureLatitude = departureLatitude;
        this.departureLongitude = departureLongitude;
        this.destinationAddress = destinationAddress;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
    }
}
