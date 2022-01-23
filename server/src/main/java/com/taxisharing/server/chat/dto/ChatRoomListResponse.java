package com.taxisharing.server.chat.dto;

import com.taxisharing.server.chat.domain.ChatRoom;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomListResponse {
    private Integer amount;
    private ChatRoom room;

    public ChatRoomListResponse(Integer amount, ChatRoom room){
        this.amount = amount;
        this.room = room;
    }
}
