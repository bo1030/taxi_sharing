package com.taxisharing.server.waiting_room.exception;

import com.taxisharing.server.common.exception.BaseException;

public class WaitingRoomListException extends BaseException {
    private static final String ERROR_CODE = "waiting_room-001";
    private static final String MESSAGE = "인자가 잘못되었습니다.";

    public WaitingRoomListException()
    {
        super(ERROR_CODE, MESSAGE);
    }
}
