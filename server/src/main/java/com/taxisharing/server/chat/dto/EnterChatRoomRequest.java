package com.taxisharing.server.chat.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EnterChatRoomRequest {
    private Integer wid;
    private Integer uid;

    public EnterChatRoomRequest(Integer wid, Integer uid){
        this.wid = wid;
        this.uid = uid;
    }
}
