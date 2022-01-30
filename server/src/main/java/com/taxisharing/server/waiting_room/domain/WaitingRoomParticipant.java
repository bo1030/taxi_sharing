package com.taxisharing.server.waiting_room.domain;

import com.taxisharing.server.user.domain.User;
import jdk.vm.ci.meta.Local;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "waiting_room_participant") // todo: snake to camel hibernate setting
@Getter
//@IdClass()
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingRoomParticipant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private Integer status;

    @Column(nullable = false)
    private String name;

    @Column(name = "read_time", nullable = false)
    private LocalDateTime readTime;

    public WaitingRoomParticipant(Integer id, User user, Integer status, String name, LocalDateTime readTime) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.name = name;
        this.readTime = readTime;
    }
}