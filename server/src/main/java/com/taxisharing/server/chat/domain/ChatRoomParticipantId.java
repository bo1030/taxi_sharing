package com.taxisharing.server.chat.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomParticipantId implements Serializable {
    private int user;
    private int chattingRoom;

    public ChatRoomParticipantId(int user, int chattingRoom) {
        this.user = user;
        this.chattingRoom = chattingRoom;
    }
}
