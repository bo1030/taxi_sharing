package com.taxisharing.server.waiting_room.domain;

import com.taxisharing.server.common.domain.BaseTimeEntity;
import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "waiting_room_participant") // todo: snake to camel hibernate setting
@Getter
@IdClass(WaitingRoomParticipantId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingRoomParticipant extends BaseTimeEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private WaitingRoom waitingRoom;

    private Integer status;

    @Column(nullable = false)
    private String name;

    @Column(name = "read_time", nullable = false)
    private LocalDateTime readTime;



    public WaitingRoomParticipant(Integer status, String name, LocalDateTime readTime) {
        this.status = status;
        this.name = name;
        this.readTime = readTime;
    }
}