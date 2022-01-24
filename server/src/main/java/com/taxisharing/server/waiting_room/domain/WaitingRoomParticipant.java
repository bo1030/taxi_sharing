package com.taxisharing.server.waiting_room.domain;

import jdk.vm.ci.meta.Local;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingRoomParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer status;

    @Column(nullable = false)
    private String name;

    @Column(name = "read_time", nullable = false)
    private LocalDateTime readTime;

    public WaitingRoomParticipant(Integer id, Integer status, String name, LocalDateTime readTime) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.readTime = readTime;
    }
}