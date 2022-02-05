package com.taxisharing.server.waiting_room.domain;

import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "waiting_room")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User host;

    @OneToMany(mappedBy = "waitingRoom")
    private final List<WaitingRoomParticipant> waitingRoomParticipants = new ArrayList<>();

//    @Column(name = "room_name", length = 45, nullable = false)
    @Column(length = 45, nullable = false)
    private String roomName;

//    @Column(name = "host_name", length = 16, nullable = false)
    @Column(length = 16, nullable = false)
    private String hostName;

    @Column(nullable = false)
    private Integer status;

//    @Column(name = "generate_time", nullable = false)
    @Column(nullable = false)
    private LocalDateTime generateTime;
//    @Column(name = "departure_time", nullable = false)
    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(length = 64, nullable = false)
    private String departureAddress;

//    @Column(name = "departure_latitude", nullable = false)
    @Column(nullable = false)
    private Float departureLatitude;
    @Column(nullable = false)
    private Float departureLongitude;

    @Column(length = 64, nullable = false)
    private String destinationAddress;

//    @Column(name = "destination_latitude", nullable = false)
    @Column(nullable = false)
    private Float destinationLatitude;
//    @Column(name = "destination_longitude", nullable = false)
    @Column(nullable = false)
    private Float destinationLongitude;

//    @Column(name = "maximum_number", nullable = false)
    @Column(nullable = false)
    private Integer maximumNumber;
//    @Column(name = "current_number", nullable = false)
    @Column(nullable = false)
    private Integer currentNumber;

    public WaitingRoom(User host, String hostName, Integer status, LocalDateTime generateTime, LocalDateTime departureTime, String departureAddress, Float departureLatitude, Float departureLongitude, String destinationAddress, Float destinationLatitude, Float destinationLongitude, Integer maximumNumber, Integer currentNumber) {
        this.host = host;
        this.hostName = hostName;
        this.status = status;
        this.generateTime = generateTime;
        this.departureTime = departureTime;
        this.departureAddress = departureAddress;
        this.departureLatitude = departureLatitude;
        this.departureLongitude = departureLongitude;
        this.destinationAddress = destinationAddress;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
        this.maximumNumber = maximumNumber;
        this.currentNumber = currentNumber;
    }
}
