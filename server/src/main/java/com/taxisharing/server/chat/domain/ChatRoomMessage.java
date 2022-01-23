package com.taxisharing.server.chat.domain;

import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chat_room_message")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String text;

    private Date time;
    private Integer readCount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public ChatRoomMessage(String text, Date time, Integer readCount, User user){
        this.text = text;
        this.time = time;
        this.readCount = readCount;
        this.user = user;
    }
    public ChatRoomMessage(String text, Date time, User user, ChatRoom room){
        this(text, time, 1, user);
    }
}
