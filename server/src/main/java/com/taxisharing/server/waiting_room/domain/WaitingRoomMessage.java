package com.taxisharing.server.waiting_room.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingRoomMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 16, nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(name = "read_count", nullable = false)
    private Integer readCount;

    public WaitingRoomMessage(Integer id, String text, LocalDateTime time, Integer readCount) {
        this.id = id;
        this.text = text;
        this.time = time;
        this.readCount = readCount;
    }
}
