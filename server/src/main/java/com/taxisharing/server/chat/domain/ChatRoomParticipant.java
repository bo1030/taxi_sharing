package com.taxisharing.server.chat.domain;

import com.taxisharing.server.common.domain.BaseTimeEntity;
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
@IdClass(ChatRoomParticipantId.class)
public class ChatRoomParticipant extends BaseTimeEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private ChatRoom chatRoom;

    private Integer status;

    @Column(length = 45, nullable = false)
    private String name;

    public ChatRoomParticipant(String name, Integer status, User user){
        this.name = name;
        this.status = status;
        this.user = user;
    }
}
