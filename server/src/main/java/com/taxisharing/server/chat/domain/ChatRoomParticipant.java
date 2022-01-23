package com.taxisharing.server.chat.domain;

import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chat_room_participant")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class ChatRoomParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String name;

    private Integer status;
    private Date readTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chatting_room_id")
    private ChatRoom room;

    public ChatRoomParticipant(String name, Integer status, Date readTime, User user, ChatRoom room){
        this.name = name;
        this.status = status;
        this.readTime = readTime;
        this.user = user;
        this. room = room;
    }
}
