package com.taxisharing.server.waiting_room.domain;

import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "waiting_room_message")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingRoomMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 16, nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(name = "read_count", nullable = false)
    private Integer readCount;

    public WaitingRoomMessage(User user, String text, LocalDateTime time, Integer readCount) {
        this.user = user;
        this.text = text;
        this.time = time;
        this.readCount = readCount;
    }
}
