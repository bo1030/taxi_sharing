package com.taxisharing.server.waiting_room.exception;

import com.taxisharing.server.common.exception.BaseException;

public class CreateWaitingRoomException extends BaseException {
    private static final String ERROR_CODE = "waiting_room-002";
    private static final String MESSAGE = "대기실을 만들수없습니다.";

    public CreateWaitingRoomException()
    {
        super(ERROR_CODE, MESSAGE);
    }
}
