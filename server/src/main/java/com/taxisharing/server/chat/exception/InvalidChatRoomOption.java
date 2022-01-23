package com.taxisharing.server.chat.exception;

import com.taxisharing.server.common.exception.BaseException;

public class InvalidChatRoomOption extends BaseException {
    private static final String ERROR_CODE = "chat-001";
    private static final String MESSAGE = "검색옵션이 잘못되었습니다.";

    public InvalidChatRoomOption() {
        super(ERROR_CODE, MESSAGE);
    }
}
